// in src/customRoutes.js
import * as React from "react";
import { Route } from 'react-router-dom';
import profile from '../profile';

export default [
    <Route key="profile" path="/profile" component={profile.edit}/>
];