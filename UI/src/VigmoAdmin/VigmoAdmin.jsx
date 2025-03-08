import { Admin, Resource } from 'react-admin';
import { createBrowserHistory as createHistory } from 'history';
import authProvider from './authProvider';
import customDataProvider from './Customs/customDataProvider';
import customRoutes from "./Customs/customRoutes";
import customLayout from "./Customs/customLayout.jsx";

import {
People as UserIcon,
EventAvailable as AvailablilityIcon,
HourglassEmptyOutlined as ConsultationHourIcon,
DesktopWindows as ScreenIcon,
Slideshow as SlideshowIcon,
Functions as SlideshowVariableIcon,
RssFeed as RssSlideIcon,
PermMedia as MediaSlideIcon,
Assignment as TextSlideIcon
} from '@mui/icons-material'

import { UsersList, UsersEdit, UsersCreate } from './Entities/users';
import { AvailabilitiesList, AvailabilitiesEdit, AvailabilitiesCreate } from './Entities/availabilities';
import { ConsultationHoursList, ConsultationHoursEdit, ConsultationHoursCreate } from './Entities/consultation_hours';
import { ScreensList, ScreensEdit, ScreensCreate } from './Entities/screens';
import { SlideshowList, SlideshowEdit, SlideshowCreate } from './Entities/slideshows';
import { SlideshowVariablesList, SlideshowVariablesEdit, SlideshowVariablesCreate } from './Entities/slideshow_variables';
import { RssSlidesList, RssSlidesEdit, RssSlidesCreate } from './Entities/rss_slides';
import { MediaSlidesList, MediaSlidesEdit, MediaSlidesCreate } from './Entities/media_slides';
import { TextSlidesList, TextSlidesEdit, TextSlidesCreate } from './Entities/text_slides';

const VigmoAdmin = (params) => {
    const newHistory = createHistory({ basename: '/admin', history: params.history });

    return (
        <Admin dataProvider={customDataProvider} authProvider={authProvider} layout={customLayout} customRoutes={customRoutes} disableTelemetry={true} basename="/admin" history={newHistory}>
            {permissions => [
                permissions === 'ROLE_ADMIN' ? (
                    <Resource name="users" list={UsersList} edit={UsersEdit} create={UsersCreate} icon={UserIcon} />
                ) : null,

                permissions === 'ROLE_ADMIN' ? (
                    <Resource name="consultation_hours" list={ConsultationHoursList} edit={ConsultationHoursEdit} create={ConsultationHoursCreate} icon={ConsultationHourIcon} />
                ) : null,

                permissions === 'ROLE_ADMIN' ? (
                    <Resource name="availabilities" list={AvailabilitiesList} edit={AvailabilitiesEdit} create={AvailabilitiesCreate} icon={AvailablilityIcon} />
                ) : null,

                <Resource name="screens" list={ScreensList} edit={ScreensEdit} create={ScreensCreate} icon={ScreenIcon} />,
                <Resource name="slideshows" list={SlideshowList} edit={SlideshowEdit} create={SlideshowCreate} icon={SlideshowIcon} />,
                <Resource name="slideshow_variables" list={SlideshowVariablesList} edit={SlideshowVariablesEdit} create={SlideshowVariablesCreate} icon={SlideshowVariableIcon} />,

                <Resource name="rss_slides" list={RssSlidesList} edit={RssSlidesEdit} create={RssSlidesCreate} icon={RssSlideIcon} />,
                <Resource name="media_slides" list={MediaSlidesList} edit={MediaSlidesEdit} create={MediaSlidesCreate} icon={MediaSlideIcon} />,
                <Resource name="text_slides" list={TextSlidesList} edit={TextSlidesEdit} create={TextSlidesCreate} icon={TextSlideIcon} />,
            ]}
        </Admin>
    );
}

export default VigmoAdmin;