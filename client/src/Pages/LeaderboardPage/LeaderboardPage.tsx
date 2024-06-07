import React, { FC } from 'react'
import './style.scss'
import { BackArrowSVGComponent } from '../../Shared/SVGs/BackArrow.SVG.Component'
import LeaderBoard from '../../Components/Leaderboard/Leaderboard'
import { useNavigate } from 'react-router'

const LeaderboardPage: FC = () => {
    const navigate = useNavigate();
    return (
        <div className='page-wrapper'>
            <header className='page-header'>
                <button className='arrow-button' onClick={() => navigate('/menu')}>
                    <BackArrowSVGComponent width='24px' height='21px' className='arrow-button-svg'/>
                </button>
                <h1 className='heading1'>Лидерборд</h1>
            </header>
            <LeaderBoard />            
        </div>
    )
}

export default LeaderboardPage;