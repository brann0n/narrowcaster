import * as React from "react";
import { List, Datagrid, TextField, SelectField, Edit, TextInput, SimpleForm, Create, ReferenceField, ReferenceInput, SelectInput } from 'react-admin';
import { workDays } from '../Constants';

export const AvailabilitiesList = props => (
    <List {...props}>
        <Datagrid rowClick="edit">
            <TextField source="id" />
            <ReferenceField source="userId" reference="users"><TextField source="username" /></ReferenceField>
            <TextField source="weekDay" />
            <SelectField source="weekDay" choices={workDays}/>
            <TextField source="startTime" />
            <TextField source="endTime" />
        </Datagrid>
    </List>
);

export const AvailabilitiesEdit = props => (
    <Edit {...props}>
        <SimpleForm>
            <TextInput source="id" disabled />
            <ReferenceInput source="userId" reference="users"><SelectInput optionText="username" /></ReferenceInput>
            <SelectInput source="weekDay" choices={workDays} />
            <TextInput source="startTime" />
            <TextInput source="endTime" />
        </SimpleForm>
    </Edit>
);

export const AvailabilitiesCreate = props => (
    <Create {...props}>
        <SimpleForm>
            <ReferenceInput source="userId" reference="users"><SelectInput optionText="username" /></ReferenceInput>
            <SelectInput source="weekDay" choices={workDays} />
            <TextInput source="startTime" />
            <TextInput source="endTime" />
        </SimpleForm>
    </Create>
);