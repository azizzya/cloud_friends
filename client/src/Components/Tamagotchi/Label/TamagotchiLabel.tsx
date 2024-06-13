import React, { FC, useState } from 'react'
import './style.scss'

const TamagotchiLabel: FC = () => {
    const [tooltipVisible, setTooltipVisible] = useState(false)
    const tooltipButtonHadler = () => {
        if (tooltipVisible) {
            setTooltipVisible(false)
        } else if (!tooltipVisible) {
            setTooltipVisible(true)
        }
    }
    return (
        <div className='happy-label'>
            <label>Уровень счастья</label>
            <div className='tooltip'>
                <button className='tooltip-button' onClick={() => tooltipButtonHadler()}>?</button>
                <span className='tooltip-text' style={tooltipVisible ? {display: 'block'} : {display: 'none'}}>Уровень счастья описывает множитель к получаемым за задание монетам. Каждое заполненное деление означает множитель в 1, 2 и 3 раза.</span>
            </div>
        </div>
    )
}

export default TamagotchiLabel;