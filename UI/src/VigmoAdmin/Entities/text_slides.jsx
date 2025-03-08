import * as React from "react";
import { List, Datagrid, TextField, ReferenceField, BooleanField, NumberField, DateField, RichTextField, Edit, TextInput, BooleanInput, NumberInput, DateInput, SimpleForm, Create, ReferenceInput, SelectInput } from 'react-admin';
import { RichTextInput } from 'ra-input-rich-text';

export const TextSlidesList = props => (
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
            <TextField source="title" />
            <RichTextField source="message" />
        </Datagrid>
    </List>
);

export const TextSlidesEdit = props => (
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
            <TextInput source="title" />
            <RichTextInput source="message" />
        </SimpleForm>
    </Edit>
);

export const TextSlidesCreate = props => (
    <Create {...props}>
        <SimpleForm>
            <ReferenceInput source="slideshowId" reference="slideshows"><SelectInput optionText="name" /></ReferenceInput>
            <BooleanInput source="isActive" />
            <NumberInput source="duration" />
            <DateInput source="startDate" />
            <DateInput source="endDate" />
            <TextInput source="startTime" />
            <TextInput source="endTime" />
            <TextInput source="title" />
            <RichTextInput source="message" />
        </SimpleForm>
    </Create>
);