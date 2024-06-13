import React, { FC } from 'react'
import HappyTamagotchiSVG from './SVG/HappyTamagotchiSVG';
import './style.scss'
import { motion } from 'framer-motion';
import TamagotchiLabel from './Label/TamagotchiLabel';

const HappyTamagotchi: FC = () => {
    return (
        <div className='tamagotchi-wrapper'>
            <div className="tamagotchi-frame">
                <HappyTamagotchiSVG />
            </div>
            <TamagotchiLabel />
            <div className="scale">
                <motion.div 
                    className="scale-el scale-el-green"
                    animate={{ width: ['5%', '33%', '66%', '100%', '100%', '100%', '5%'] }}
                    transition={{
                        times: [0, 1],
                        duration: 10,
                        repeat: Infinity,
                        type: "keyframes",
                        ease: "easeInOut"
                    }}
                ></motion.div>
            </div>
        </div>
    )
}

export default HappyTamagotchi;