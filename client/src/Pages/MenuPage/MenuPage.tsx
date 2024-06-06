import React, { FC } from 'react'
import './style.scss'
import { ServiceList } from '../../Components/Services/ServiceList';

const MenuPage: FC = () => {
    return (
        <div className='page-wrapper'>
            <h1 className='heading1'>Ещё</h1>
            <ServiceList />
        </div>
    )
}

export default MenuPage;