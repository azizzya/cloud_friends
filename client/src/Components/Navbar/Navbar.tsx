import React, { FC } from 'react'
import { useLocation, useNavigate } from 'react-router-dom';
import './style.scss'
import { HomeSVGComponent } from '../../Shared/SVGs/Home.SVG.Component';
import { TaskSVGComponent } from '../../Shared/SVGs/Tasks.SVG.Component';
import { MenuSVGComponent } from '../../Shared/SVGs/Menu.SVG.Component';
import { ProfileSVGComponent } from '../../Shared/SVGs/Profile.SVG.Component';


const Navbar: FC = () => {
	const navigate = useNavigate();
	const location = useLocation();
    
	const activeIcon = location.pathname.split('/')[1] || '';

	const handleClick = (iconId: string) => {
		navigate(`/${iconId}`);
	};

    return (
        <nav className={activeIcon === 'auth' ? 'navbar-wrapper-none' : 'navbar-wrapper'}>
            <button onClick={() => handleClick('')}>
                <HomeSVGComponent width='26px' height='26px' className={activeIcon === '' ? 'navbar-svg-active' : 'navbar-svg'} />
            </button>
            <button onClick={() => handleClick('tasks')}>
                <TaskSVGComponent width='24px' height='24px' className={activeIcon === 'tasks' ? 'navbar-svg-active' : 'navbar-svg'} />
            </button>
            <button onClick={() => handleClick('menu')}>
                <MenuSVGComponent width='26px' height='26px' className={activeIcon === 'menu' ? 'navbar-svg-active' : 'navbar-svg'} />
            </button>
            <button onClick={() => handleClick('profile')}>
                <ProfileSVGComponent width='26px' height='26px' className={activeIcon === 'profile' ? 'navbar-svg-active' : 'navbar-svg'} />
            </button>
        </nav>
    )
}

export default Navbar;