//test for narrowcasteradmin
import * as React from "react";
import { render } from '@testing-library/react';
import { Tab, TextField } from 'react-admin';

import VigmoAdmin from '../VigmoAdmin/VigmoAdmin.js';

describe('VigmoAdmin', () => {
    describe('As User', () => {
        it('should display one tab', () => {
            const testUtils = render(<VigmoAdmin permissions="ROLE_ADMIN" />);
            testUtils.rerender();

            //test fails because somehow it wont render the admin panel in memory.
            expect(testUtils.queryAllByText("Users").length).toEqual(1);
        });

        // it('should show the user identity in the first tab', () => {
        //     const dataProvider = {
        //         getOne: jest.fn().resolve({
        //             id: 1,
        //             name: 'Leila'
        //         })
        //     }
        //     const testUtils = render(
        //         <TestContext>
        //             <VigmoAdmin permissions="user" id="1" />
        //         </TestContext>
        //     );

        //     expect(testUtils.queryByDisplayValue('1')).not.toBeNull();
        //     expect(testUtils.queryByDisplayValue('Leila')).not.toBeNull();
        // });
    });

    // describe('As Admin', () => {
    //     it('should display two tabs', () => {
    //         const testUtils = render(<VigmoAdmin permissions="user" />);

    //         const tabs = testUtils.queryByRole('tab');
    //         expect(tabs.length).toEqual(2);
    //     });

    //     it('should show the user identity in the first tab', () => {
    //         const dataProvider = {
    //             getOne: jest.fn().resolve({
    //                 id: 1,
    //                 name: 'Leila'
    //             })
    //         }
    //         const testUtils = render(
    //             <TestContext>
    //                 <VigmoAdmin permissions="user" id="1" />
    //             </TestContext>
    //         );

    //         expect(testUtils.queryByDisplayValue('1')).not.toBeNull();
    //         expect(testUtils.queryByDisplayValue('Leila')).not.toBeNull();
    //     });

    //     it('should show the user role in the second tab', () => {
    //         const dataProvider = {
    //             getOne: jest.fn().resolve({
    //                 id: 1,
    //                 name: 'Leila',
    //                 role: 'admin'
    //             })
    //         }
    //         const testUtils = render(
    //             <TestContext>
    //                 <VigmoAdmin permissions="user" id="1" />
    //             </TestContext>
    //         );

    //         fireEvent.click(testUtils.getByText('Security'));
    //         expect(testUtils.queryByDisplayValue('admin')).not.toBeNull();
    //     });
    // });
});