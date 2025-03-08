import { Layout } from 'react-admin';
import customAppBar from './customAppBar';

const customLayout = props => (
    <Layout {...props} appBar={customAppBar}/>
);

export default customLayout;
