import { FC } from 'react';
import { Navigate, Outlet } from 'react-router-dom';
import { getUserDataFromLocalStorage } from '../Shared/Helpers/LocalStorage.helpers';

const ProtectedRoute: FC = () => {
    const user = getUserDataFromLocalStorage();

    if (!user) {
        return <Navigate to="/auth" replace />;
    }

    return <Outlet />;
};

export default ProtectedRoute;
