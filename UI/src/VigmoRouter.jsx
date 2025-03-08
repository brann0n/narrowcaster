import React from 'react';
import { Route, Routes } from 'react-router-dom';
import VigmoDashboard from './VigmoDashboard/VigmoDashboard';
import VigmoAdmin from './VigmoAdmin/VigmoAdmin';

const VigmoRouter = () => {
    console.log("Je moeder")
    return (
        <Routes>
            <Route exact path='/admin/*' element={<VigmoAdmin />}></Route>
            <Route index path="*" element={<VigmoDashboard />} ></Route>
        </Routes>
    );
}

export default VigmoRouter;