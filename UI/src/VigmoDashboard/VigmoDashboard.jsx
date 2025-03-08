import * as React from "react";
import SideBarPanel from "./component/SideBarPanel";
import SlideShowPanel from "./component/SlideShowPanel";
import { useLocation } from 'react-router-dom'
import { Link } from "react-router-dom";
import './VigmoDashboard.css'
import authProvider from "./logic/authProvider";
import apiHandler from "./logic/apiHandler";
import "@fontsource/plus-jakarta-sans";
import { fetchUtils } from 'ra-core';
import global_vars from '../env.json'

const httpClient = (url, options = {}) => {
    if (!options.headers) {
        options.headers = new Headers({ Accept: 'application/json' });
    }
    const token = localStorage.getItem('screen_token');
    options.headers.set('Authorization', `Bearer ${token}`);
    return fetchUtils.fetchJson(url, options);
};

const dataProvider = apiHandler(global_vars.REACT_APP_DATA_URL, httpClient);

const loginWithScreenKey = (key) => new Promise((resolve, reject) => {
    authProvider.getName()
        .then((name) => {
            return resolve(localStorage.getItem('screen_token'));
        })
        .catch((error) => {
            console.log("Token expired, getting new token.");
            const token = authProvider.login(key);
            return resolve(token);
        });
});

const VigmoDashboard = (props) => {
    const loc = useLocation();
    const path = loc.pathname
    if (path === '/') {
        return ((
            <div className="component-app-no-screen">
                <div className="no-screen-center">
                    <h3>Narrowcaster Dashboard</h3>
                    <p>You have not provided a ScreenKey.</p>
                    <Link to="/admin" className="no-screen-admin-button">
                        Go to admin panel
                    </Link>
                </div>
            </div>
        ))
    }
    else {
        const signInKey = path.replace("/", "");
        const [loaded, setLoaded] = React.useState(false);

        React.useEffect(() => {
            loginWithScreenKey(signInKey).then((result) => {
                setLoaded(true);
            });
        }, []);

        if (!loaded) {
            return (<div className="loading-screen">
                <div>Please wait while narrowcaster is attempting verification...</div>
            </div>);
        }

        return ((
            <div className="component-app">
                <SideBarPanel />
                <SlideShowPanel apiHandler={dataProvider} />
            </div>
        ))
    }
};

export default VigmoDashboard;