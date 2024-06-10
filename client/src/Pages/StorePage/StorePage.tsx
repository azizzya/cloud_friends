import React, { FC } from 'react'
import './style.scss'
import instance from '../../Shared/Api/Axios.api'
import { BackArrowSVGComponent } from '../../Shared/SVGs/BackArrow.SVG.Component'
import { useNavigate } from 'react-router'

const StorePage: FC = () => {
    const navigate = useNavigate();
    instance.get('store/items').then(response => console.log(response))
    return (
        <div>
            <div className='page-wrapper'>
            <header className='page-header'>
                <button className='arrow-button' onClick={() => navigate('/menu')}>
                    <BackArrowSVGComponent width='24px' height='21px' className='arrow-button-svg'/>
                </button>
                <h1 className='heading1'>Маркет</h1>
            </header>
        </div>
        </div>
    )
}

export default StorePage;