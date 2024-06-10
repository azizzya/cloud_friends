import React, { FC } from 'react'
import './style.scss'
import { BackArrowSVGComponent } from '../../Shared/SVGs/BackArrow.SVG.Component'
import { useNavigate } from 'react-router'
import StoreGrid from '../../Components/Store/StoreGrid'
import { ShoppingCartSVGComponent } from '../../Shared/SVGs/ShoppingCart.SVG.Component'
import { StoreBalance } from '../../Components/Store/StoreBalance'

const StorePage: FC = () => {
    const navigate = useNavigate();
    return (
        <div className='page-wrapper'>
            <header className='store-header'>
                <div className="store-header-left">
                    <button className='arrow-button' onClick={() => navigate('/menu')}>
                        <BackArrowSVGComponent width='24px' height='21px' className='arrow-button-svg'/>
                    </button>
                    <h1 className='heading1'>Маркет</h1>
                </div>
                <div className='store-header-right'>
                    <StoreBalance className='store-header-balance'/>
                    <ShoppingCartSVGComponent width='26px' height='24px' className='store-header-cart'/>
                </div>
            </header>
            <StoreGrid />
        </div>
    )
}

export default StorePage;