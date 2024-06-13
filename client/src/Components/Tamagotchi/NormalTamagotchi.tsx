import { motion } from 'framer-motion';
import React, { FC } from 'react'
import NormalTamagotchiSVG from './SVG/NormalTamagotchiSVG';
import TamagotchiLabel from './Label/TamagotchiLabel';

const NormalTamagotchi: FC = () => {
    return (
        <div className='tamagotchi-wrapper'>
            <div className="tamagotchi-frame">
                <NormalTamagotchiSVG />
            </div>
            <TamagotchiLabel />
            <div className="scale">
                <motion.div 
                    className="scale-el scale-el-yellow"
                    animate={{ width: ['5%', '33%', '66%', '66%', '66%', '5%'] }}
                    transition={{
                        times: [0, 1],
                        duration: 8,
                        repeat: Infinity,
                        type: "keyframes",
                        ease: "easeInOut"
                    }}
                ></motion.div>
            </div>
        </div>
    )
}

export default NormalTamagotchi;