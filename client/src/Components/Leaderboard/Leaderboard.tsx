import React, { FC, lazy, useEffect, useState } from 'react'
import './style.scss'
import { LeaderBoardUser } from './LeaderboardUser';
import instance from '../../Shared/Api/Axios.api';
import { ILeaderBoardUser } from './interface';

const LeaderBoard: FC = () => {
    const [leaderboard, setLeaderboard] = useState([])
    const [isLoading, setIsLoading] = useState(true)
    
    useEffect(() => {
        const fetchLeaderboard = async () => {
            try {
                const response = await instance.get('/users/leaderboard');
                setLeaderboard(response.data);
            } catch (error) {
                console.error("Failed to fetch leaderboard data", error);
            } finally {
                setIsLoading(false)
            }
        };
        fetchLeaderboard();
    }, []);
    
    if (isLoading) {
        return <div className='loading'>Загрузка...</div>
    }

    return (
        <div className='leaderBoard-wrapper'>
			{leaderboard.map((user: ILeaderBoardUser, index: number) => (
				<LeaderBoardUser
					pos={index + 1}
					key={user.user_id}
					firstname={user.firstname}
					coin_total_score={user.coin_total_score}
					username={user.username}
					lastname={user.lastname}
                    profile_image_name={user.profile_image_name}
				/>
			))}
		</div>
    )
}

export default LeaderBoard;