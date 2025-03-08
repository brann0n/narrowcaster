import React from 'react';
import { Edit, TextInput, SimpleForm, ImageField, ImageInput, useGetIdentity } from 'react-admin';

const ProfileEdit = ({ staticContext, ...props }) => {
    const { identity, loading: identityLoading } = useGetIdentity();
    if (identityLoading) return <>Loading...</>;
    return (
        <Edit
            id={identity.id}
            resource="users"
            basePath="/profile"
            redirect={false}
            title={identity.fullName + "'s profile"}
            {...props}
        >
            <SimpleForm>
                <TextInput source="username" />
                <TextInput source="password" placeholder="(leave blank to not change)" />
                <ImageField source="pfpLocation" label="Profile Picture" emptyText="Picture not available" />
                <ImageInput source="pfpLocation" label="Upload a new picture" accept="image/*">
                    <ImageField source="src" title="title" />
                </ImageInput>
            </SimpleForm>
        </Edit>
    );
};

export default ProfileEdit;
