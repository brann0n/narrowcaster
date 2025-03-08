// import * as React from 'react';
import { AppBar } from 'react-admin';
import CustomUserMenu from './customUserMenu';
// userMenu={<CustomUserMenu />}
const customAppBar = props => (
    <AppBar {...props}  />
);

export default customAppBar;
