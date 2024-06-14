import React from 'react';
import { Navigate, Outlet } from 'react-router-dom';
import { getUserDataFromLocalStorage } from '../Shared/Helpers/LocalStorage.helpers';

const GuestRoute: React.FC = () => {
    const user = getUserDataFromLocalStorage();

    if (user) {
        return <Navigate to="/" replace />;
    }

    return <Outlet />;
};

export default GuestRoute;
