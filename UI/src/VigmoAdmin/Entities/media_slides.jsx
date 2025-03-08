import * as React from "react";
import { List, Datagrid, TextField, ReferenceField, BooleanField, NumberField, DateField, UrlField, Edit, TextInput, BooleanInput, NumberInput, DateInput, SimpleForm, Create, ReferenceInput, SelectInput, FileInput, FileField } from 'react-admin';

export const MediaSlidesList = props => (
    <List {...props}>
        <Datagrid rowClick="edit">
            <TextField source="id" />
            <ReferenceField source="slideshowId" reference="slideshows"><TextField source="name" /></ReferenceField>
            <BooleanField source="isActive" />
            <NumberField source="duration" />
            <DateField source="startDate" />
            <DateField source="endDate" />
            <TextField source="startTime" />
            <TextField source="endTime" />
            <BooleanField source="audioEnabled" />
            <TextField source="type" />
            <FileField source="resource" title="resource" />
        </Datagrid>
    </List>
);

export const MediaSlidesEdit = props => (
    <Edit {...props}>
        <SimpleForm>
            <TextInput disabled source="id" />
            <ReferenceInput source="slideshowId" reference="slideshows"><SelectInput optionText="name" /></ReferenceInput>
            <BooleanInput source="isActive" />
            <NumberInput source="duration" />
            <DateInput source="startDate" />
            <DateInput source="endDate" />
            <TextInput source="startTime" />
            <TextInput source="endTime" />
            <BooleanInput source="audioEnabled" />
            <FileInput source="resource" label="Related files">
                <FileField source="src" title="name" />
            </FileInput>
        </SimpleForm>
    </Edit>
);

export const MediaSlidesCreate = props => (
    <Create {...props}>
        <SimpleForm>
            <ReferenceInput source="slideshowId" reference="slideshows"><SelectInput optionText="name" /></ReferenceInput>
            <BooleanInput source="isActive" />
            <NumberInput source="duration" />
            <DateInput source="startDate" />
            <DateInput source="endDate" />
            <TextInput source="startTime" />
            <TextInput source="endTime" />
            <BooleanInput source="audioEnabled" />
            <FileInput source="resource" label="Related files">
                <FileField source="src" title="name" />
            </FileInput>
        </SimpleForm>
    </Create>
);