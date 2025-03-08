import * as React from "react";
import { List, Datagrid, TextField, SelectField, Edit, TextInput, BooleanInput, SimpleForm, SelectInput, Create } from 'react-admin';
import { workDays } from '../Constants';

export const ConsultationHoursList = props => (
    <List {...props}>
        <Datagrid rowClick="edit">
            <TextField source="id" />
            <TextField source="description" />
            <SelectField source="weekDay" choices={workDays}/>
            <TextField source="startTime" />
            <TextField source="endTime" />
        </Datagrid>
    </List>
);

export const ConsultationHoursEdit = props => (
    <Edit {...props}>
        <SimpleForm>
            <TextInput source="id" disabled />
            <TextInput source="description" />
            <SelectInput source="weekDay" choices={workDays} />
            <TextInput source="startTime" />
            <TextInput source="endTime" />
        </SimpleForm>
    </Edit>
);

export const ConsultationHoursCreate = props => (
    <Create {...props}>
        <SimpleForm>
            <TextInput source="description" />
            <SelectInput source="weekDay" choices={workDays} />
            <TextInput source="startTime" />
            <TextInput source="endTime" />
        </SimpleForm>
    </Create>
);