import { jwtDecode } from 'jwt-decode';
import vars from '../../env.json'
export default {
  login: (authKey) => {
    const request = new Request(vars.REACT_APP_SCREEN_AUTH_URL + "/" + authKey, { method: 'GET' });
    return fetch(request)
      .then(response => {
        if (response.status < 200 || response.status >= 300) {
          let errorMessage;
          if (response.status === 404) {
            errorMessage = "Bad auth token. ";
          }
          throw new Error(response.statusText + errorMessage + "We could not sign you in");
        }
        return response.headers.get('jwt-token');
      })
      .then((token) => {
        localStorage.setItem('screen_token', token);

        return token;
      });
  },
  logout: () => {
    localStorage.removeItem('screen_token');
    return Promise.resolve();
  },
  checkError: error => {
    const status = error.status;
    if (status === 401 || status === 403) {
      localStorage.removeItem('screen_token');
      return Promise.reject();
    }
    return Promise.resolve();
  },
  checkAuth: () => {
    return localStorage.getItem('screen_token') ? Promise.resolve() : Promise.reject();
  },
  getName: () => {
    try {
      const token = localStorage.getItem('screen_token');
      const { sub, exp } = jwtDecode(token);

      let currentDate = new Date();

      // JWT exp is in seconds
      if (exp * 1000 < currentDate.getTime()) {
        return Promise.reject("Token expired");
      } else {
        let screenName = sub;
        return Promise.resolve({ screenName });
      }
    } catch (error) {
      return Promise.reject(error);
    }
  }
};