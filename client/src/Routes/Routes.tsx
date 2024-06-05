import { createBrowserRouter } from "react-router-dom";
import App from "../App";
import AuthPage from "../Pages/AuthPage/AuthPage";
import LeaderboardPage from "../Pages/LeaderboardPage/LeaderboardPage";
import MainPage from "../Pages/MainPage/MainPage";
import StorePage from "../Pages/StorePage/StorePage";
import MenuPage from "../Pages/MenuPage/MenuPage";
import ProfilePage from "../Pages/ProfilePage/ProfilePage";
import TasksPage from "../Pages/TasksPage/TasksPage";

export const router = createBrowserRouter([
    {
        path: '/',
        element: <App />,
        children: [
            {path: '', element: <MainPage />},
            {path: 'auth', element: <AuthPage />},
            {path: 'menu/leaderboard', element: <LeaderboardPage />},
            {path: 'menu/store', element: <StorePage />},
            {path: 'menu', element: <MenuPage />},
            {path: 'profile', element: <ProfilePage />},
            {path: 'tasks', element: <TasksPage />},
        ]
    }
])