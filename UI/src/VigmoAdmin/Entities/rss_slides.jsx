import * as React from "react";
import { List, Datagrid, TextField, ReferenceField, BooleanField, NumberField, DateField, UrlField, Edit, TextInput, BooleanInput, NumberInput, DateInput, SimpleForm, Create, ReferenceInput, SelectInput } from 'react-admin';

export const RssSlidesList = props => (
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
            <UrlField source="url" />
            <TextField source="titleTag" />
            <TextField source="descriptionTag" />
            <TextField source="authorTag" />
            <TextField source="categoryTag" />
            <TextField source="imageTag" />
        </Datagrid>
    </List>
);

export const RssSlidesEdit = props => (
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
            <TextInput source="url" />
            <TextInput source="titleTag" />
            <TextInput source="descriptionTag" />
            <TextInput source="authorTag" />
            <TextInput source="categoryTag" />
            <TextInput source="imageTag" />
        </SimpleForm>
    </Edit>
);

export const RssSlidesCreate = props => (
    <Create {...props}>
        <SimpleForm>
            <ReferenceInput source="slideshowId" reference="slideshows"><SelectInput optionText="name" /></ReferenceInput>
            <BooleanInput source="isActive" />
            <NumberInput source="duration" />
            <DateInput source="startDate" />
            <DateInput source="endDate" />
            <TextInput source="startTime" />
            <TextInput source="endTime" />
            <TextInput source="url" />
            <TextInput source="titleTag" />
            <TextInput source="descriptionTag" />
            <TextInput source="authorTag" />
            <TextInput source="categoryTag" />
            <TextInput source="imageTag" />
        </SimpleForm>
    </Create>
);