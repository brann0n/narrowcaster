import { jwtDecode } from 'jwt-decode';
import vars from '../env.json'

export default {
  login: ({ username, password }) => {
    const request = new Request(vars.REACT_APP_AUTH_URL, {
      method: 'POST',
      body: JSON.stringify({ username, password }),
      headers: new Headers({ 'Content-Type': 'application/json' }),
    });
    return fetch(request)
      .then(response => {
        if (response.status < 200 || response.status >= 300) {
          let errorMessage;
          if (response.status === 401) {
            errorMessage = "Bad credentials. ";
          } else if (response.status === 403) {
            errorMessage = "Account disabled. ";
          }
          throw new Error(response.statusText + errorMessage + "We could not sign you in");
        }
        return response.headers.get('jwt-token');
      })
      .then((token) => {
        localStorage.setItem('token', token);
      });
  },
  logout: () => {
    localStorage.removeItem('token');
    return Promise.resolve();
  },
  checkError: error => {
    const status = error.status;
    if (status === 401 || status === 403) {
      localStorage.removeItem('token');
      return Promise.reject();
    }
    return Promise.resolve();
  },
  checkAuth: () => {
    return localStorage.getItem('token') ? Promise.resolve() : Promise.reject();
  },
  getPermissions: () => {
    const { role } = jwtDecode(localStorage.getItem('token'));
    return role ? Promise.resolve(role) : Promise.reject();
  },
  getIdentity: () => {
    try {
      const token = localStorage.getItem('token');
      const { id, sub, role, pfp_location } = jwtDecode(token);
      let fullName = sub;
      let avatar = pfp_location;
      return Promise.resolve({ id, fullName, avatar });
    } catch (error) {
      return Promise.reject(error);
    }
  }
};