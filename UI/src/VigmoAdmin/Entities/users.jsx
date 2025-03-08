import * as React from "react";
import { List, Datagrid, TextField, BooleanField, ImageField, SelectField, Edit, TextInput, BooleanInput, SimpleForm, Create, ReferenceInput, SelectInput, ImageInput } from 'react-admin';
import { userRoles } from '../Constants';
import { makeStyles } from '@mui/styles';


const useImageFieldStyles = makeStyles(theme => ({
    image: {
        height: 25,
        display: "table"
    }
}));

export const UsersList = props => {

    //get styles for the ImageField
    const imageFieldClasses = useImageFieldStyles();

    return (
        <List {...props}>
            <Datagrid rowClick="edit">
                <TextField source="id" />
                <TextField source="username" />
                <SelectField source="role" choices={userRoles} />
                <ImageField classes={imageFieldClasses} source="pfpLocation" label="Profile Picture" emptyText="Picture not available" />
                <BooleanField source="enabled" />
            </Datagrid>
        </List>
    );
};

export const UsersEdit = props => (
    <Edit {...props}>
        <SimpleForm>
            <TextInput disabled source="id" />
            <TextInput source="username" />
            <TextInput source="password" placeholder="(leave blank to not change)" />
            <BooleanInput source="enabled" checked />
            <SelectInput source="role" choices={userRoles} />
            <ImageField source="pfpLocation" label="Profile Picture" emptyText="Picture not available" />
            <ImageInput source="pfpLocation" label="Upload a new picture" accept="image/*">
                <ImageField source="src" title="title" />
            </ImageInput>
        </SimpleForm>
    </Edit>
);

export const UsersCreate = props => (
    <Create {...props}>
        <SimpleForm>
            <TextInput source="username" />
            <TextInput source="password" />
            <BooleanInput source="enabled" defaultValue />
            <SelectInput source="role" choices={userRoles} />
            <ImageField source="pfpLocation" label="Profile Picture" emptyText="Picture not available" />
            <ImageInput source="pfpLocation" label="Upload a new picture" accept="image/*">
                <ImageField source="src" title="title" />
            </ImageInput>
        </SimpleForm>
    </Create>
);