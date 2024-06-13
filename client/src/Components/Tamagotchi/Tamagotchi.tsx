import React, { FC } from 'react'
import SadTamagotchi from './SadTamagotci';
import NormalTamagotchi from './NormalTamagotchi';
import HappyTamagotchi from './HappyTamagotchi';

export interface ITamagotchi {
    happiness?: number;
}

const Tamagotchi: FC<ITamagotchi> = ({ happiness }) => {
    if (happiness === 1) {
        return <SadTamagotchi />
    }
    if (happiness === 2) {
        return <NormalTamagotchi />
    }
    if (happiness === 3) {
        return <HappyTamagotchi />
    }
    return (
        <div className="loading">
            Ошибка отображения тамагочи
        </div>
    )
}

export default Tamagotchi;