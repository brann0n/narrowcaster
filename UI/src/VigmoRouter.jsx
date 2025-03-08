import { Route, Routes } from 'react-router-dom';
import VigmoDashboard from './VigmoDashboard/VigmoDashboard';
import VigmoAdmin from './VigmoAdmin/VigmoAdmin';

const VigmoRouter = () => {
    return (
        <Routes>
            <Route exact path='/admin/*' element={<VigmoAdmin />} />
            <Route index path="*" element={<VigmoDashboard />} />
        </Routes>
    );
}

export default VigmoRouter;