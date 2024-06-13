import { motion } from 'framer-motion';
import React, { FC } from 'react'
import SadTamagotchiSVG from './SVG/SadTamagotchiSVG';
import TamagotchiLabel from './Label/TamagotchiLabel';

const SadTamagotchi: FC = () => {
    return (
        <div className='tamagotchi-wrapper'>
            <div className="tamagotchi-frame">
                <SadTamagotchiSVG />
            </div>
            <TamagotchiLabel />
            <div className="scale">
                <motion.div 
                    className="scale-el scale-el-red"
                    animate={{ width: ['5%', '33%', '33%', '33%', '5%'] }}
                    transition={{
                        times: [0, 1],
                        duration: 6,
                        repeat: Infinity,
                        type: "keyframes",
                        ease: "easeInOut"
                    }}
                ></motion.div>
            </div>
        </div>
    )
}

export default SadTamagotchi;