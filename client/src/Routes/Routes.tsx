import { createBrowserRouter } from "react-router-dom";
import App from "../App";
import AuthPage from "../Pages/AuthPage/AuthPage";
import LeaderboardPage from "../Pages/LeaderboardPage/LeaderboardPage";
import MainPage from "../Pages/MainPage/MainPage";
import MarketPage from "../Pages/MarketPage/MarketPage";
import MorePage from "../Pages/MorePage/MorePage";
import ProfilePage from "../Pages/ProfilePage/ProfilePage";
import TasksPage from "../Pages/TasksPage/TasksPage";

export const router = createBrowserRouter([
    {
        path: '/',
        element: <App />,
        children: [
            {path: 'auth', element: <AuthPage />},
            {path: 'leaderboard', element: <LeaderboardPage />},
            {path: 'main', element: <MainPage />},
            {path: 'market', element: <MarketPage />},
            {path: 'more', element: <MorePage />},
            {path: 'profile', element: <ProfilePage />},
            {path: 'tasks', element: <TasksPage />},
        ]
    }
])