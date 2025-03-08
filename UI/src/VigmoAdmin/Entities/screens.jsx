import * as React from "react";
import { List, Datagrid, TextField, BooleanField, Edit, TextInput, BooleanInput, SimpleForm, Create } from 'react-admin';

export const ScreensList = props => (
    <List {...props}>
        <Datagrid rowClick="edit">
            <TextField source="id" />
            <TextField source="name" />
            <TextField source="location" />
        </Datagrid>
    </List>
);

export const ScreensEdit = props => (
    <Edit {...props}>
        <SimpleForm>
            <TextInput disabled source="id" />
            <TextInput source="name" />
            <TextInput source="location" />
            <TextInput source="authKey" />
        </SimpleForm>
    </Edit>
);

export const ScreensCreate = props => (
    <Create {...props}>
        <SimpleForm>
            <TextInput source="name" />
            <TextInput source="location" />
            <TextInput source="authKey" />
        </SimpleForm>
    </Create>
);