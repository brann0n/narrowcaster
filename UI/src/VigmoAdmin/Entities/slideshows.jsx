import * as React from "react";
import { List, Datagrid, TextField, Edit, TextInput, SimpleForm, Create, ReferenceInput, SelectInput, ReferenceField } from 'react-admin';

export const SlideshowList = props => (
    <List {...props}>
        <Datagrid rowClick="edit">
            <TextField source="id" />
            <ReferenceField source="screenId" reference="screens"><TextField source="name" /></ReferenceField>
            <TextField source="name" />
        </Datagrid>
    </List>
);

export const SlideshowEdit = props => (
    <Edit {...props}>
        <SimpleForm>
            <TextInput source="id" disabled />
            <ReferenceInput source="screenId" reference="screens"><SelectInput optionText="name" /></ReferenceInput>
            <TextInput source="name" />
        </SimpleForm>
    </Edit>
);

export const SlideshowCreate = props => (
    <Create {...props}>
        <SimpleForm>
            <ReferenceInput source="screenId" reference="screens"><SelectInput optionText="name" /></ReferenceInput>
            <TextInput source="name" />
        </SimpleForm>
    </Create>
);