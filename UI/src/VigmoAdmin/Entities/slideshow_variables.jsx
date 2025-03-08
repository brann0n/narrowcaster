import * as React from "react";
import { List, Datagrid, TextField, Edit, TextInput, SimpleForm, Create, ReferenceInput, SelectInput, ReferenceField } from 'react-admin';

export const SlideshowVariablesList = props => (
    <List {...props}>
        <Datagrid rowClick="edit">
            <TextField source="id" />
            <ReferenceField source="slideshowId" reference="slideshows"><TextField source="name" /></ReferenceField>
            <TextField source="name" />
            <TextField source="value" />
        </Datagrid>
    </List>
);

export const SlideshowVariablesEdit = props => (
    <Edit {...props}>
        <SimpleForm>
            <TextInput source="id" disabled />
            <ReferenceInput source="slideshowId" reference="slideshows"><SelectInput optionText="name" /></ReferenceInput>
            <TextInput source="name" />
            <TextInput source="value" />
        </SimpleForm>
    </Edit>
);

export const SlideshowVariablesCreate = props => (
    <Create {...props}>
        <SimpleForm>
            <ReferenceInput source="slideshowId" reference="slideshows"><SelectInput optionText="name" /></ReferenceInput>
            <TextInput source="name" />
            <TextInput source="value" />
        </SimpleForm>
    </Create>
);