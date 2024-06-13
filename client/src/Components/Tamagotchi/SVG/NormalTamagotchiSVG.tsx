import { motion } from "framer-motion"
import * as React from "react"
import { SVGProps } from "react"
const NormalTamagotchiSVG = (props: SVGProps<SVGSVGElement>) => (
  <svg
    width={300}
    viewBox="0 0 210 120"
    fill="none"
    xmlns="http://www.w3.org/2000/svg"
    {...props}
    style={{overflow: "visible"}}
  >
    <motion.g 
        id="normal"
        animate={{ y: [-4, 4, -4]}}
        transition={{
            times: [0, 1],
            duration: 5,
            repeat: Infinity,
            type: "keyframes",
            ease: 'easeInOut'
        }}
    >
      <g id="body">
        <path
          d="M100 20H140V30H160V40H170V60H180V70H190V90H150V100H80V90H30V80H20V70H30V60H60V50H70V30H100V20Z"
          fill="#EFF8FF"
        />
        <path d="M170 40H180V50H170V40Z" fill="#E0F2FF" />
        <path d="M170 50H180V60H170V50Z" fill="#E0F2FF" />
        <path d="M180 60H190V70H180V60Z" fill="#E0F2FF" />
        <path d="M190 60H200V70H190V60Z" fill="#E0F2FF" />
        <path d="M190 70H200V80H190V70Z" fill="#E0F2FF" />
        <path d="M190 80H200V90H190V80Z" fill="#E0F2FF" />
        <path d="M180 90H190V100H180V90Z" fill="#E0F2FF" />
        <path d="M170 90H180V100H170V90Z" fill="#E0F2FF" />
        <path d="M150 90H160V100H150V90Z" fill="#E0F2FF" />
        <path d="M140 100H150V110H140V100Z" fill="#E0F2FF" />
        <path d="M130 100H140V110H130V100Z" fill="#E0F2FF" />
        <path d="M90 100H100V110H90V100Z" fill="#E0F2FF" />
        <path d="M80 100H90V110H80V100Z" fill="#E0F2FF" />
        <path d="M70 90H80V100H70V90Z" fill="#E0F2FF" />
        <path d="M50 90H60V100H50V90Z" fill="#E0F2FF" />
        <path d="M40 90H50V100H40V90Z" fill="#E0F2FF" />
        <path d="M30 90H40V100H30V90Z" fill="#E0F2FF" />
        <path d="M20 90H30V100H20V90Z" fill="#E0F2FF" />
        <path d="M20 80H30V90H20V80Z" fill="#E0F2FF" />
        <path d="M10 70H20V80H10V70Z" fill="#E0F2FF" />
        <path d="M10 80H20V90H10V80Z" fill="#E0F2FF" />
        <path d="M10 70H20V80H10V70Z" fill="#E0F2FF" />
        <path d="M20 60H30V70H20V60Z" fill="#E0F2FF" />
        <path d="M30 50H40V60H30V50Z" fill="#E0F2FF" />
        <path d="M40 50H50V60H40V50Z" fill="#E0F2FF" />
        <path d="M50 50H60V60H50V50Z" fill="#E0F2FF" />
        <path d="M60 40H70V50H60V40Z" fill="#E0F2FF" />
        <path d="M60 30H70V40H60V30Z" fill="#E0F2FF" />
        <path d="M70 20H80V30H70V20Z" fill="#E0F2FF" />
        <path d="M80 20H90V30H80V20Z" fill="#E0F2FF" />
        <path d="M90 20H100V30H90V20Z" fill="#E0F2FF" />
        <path d="M100 10H110V20H100V10Z" fill="#E0F2FF" />
        <path d="M110 10H120V20H110V10Z" fill="#E0F2FF" />
        <path d="M120 10H130V20H120V10Z" fill="#E0F2FF" />
        <path d="M130 10H140V20H130V10Z" fill="#E0F2FF" />
        <path d="M140 20H150V30H140V20Z" fill="#E0F2FF" />
        <path d="M150 20H160V30H150V20Z" fill="#E0F2FF" />
        <path d="M160 30H170V40H160V30Z" fill="#E0F2FF" />
        <path d="M30 40H40V50H30V40Z" fill="#CBE9FF" />
        <path d="M40 40H50V50H40V40Z" fill="#CBE9FF" />
        <path d="M50 40H60V50H50V40Z" fill="#CBE9FF" />
        <path d="M50 30H60V40H50V30Z" fill="#CBE9FF" />
        <path d="M60 20H70V30H60V20Z" fill="#CBE9FF" />
        <path d="M70 10H80V20H70V10Z" fill="#CBE9FF" />
        <path d="M80 10H90V20H80V10Z" fill="#CBE9FF" />
        <path d="M90 10H100V20H90V10Z" fill="#CBE9FF" />
        <path d="M100 0H110V10H100V0Z" fill="#CBE9FF" />
        <path d="M110 0H120V10H110V0Z" fill="#CBE9FF" />
        <path d="M120 0H130V10H120V0Z" fill="#CBE9FF" />
        <path d="M130 0H140V10H130V0Z" fill="#CBE9FF" />
        <path d="M140 10H150V20H140V10Z" fill="#CBE9FF" />
        <path d="M150 10H160V20H150V10Z" fill="#CBE9FF" />
        <path d="M160 20H170V30H160V20Z" fill="#CBE9FF" />
        <path d="M170 30H180V40H170V30Z" fill="#CBE9FF" />
        <path d="M180 40H190V50H180V40Z" fill="#CBE9FF" />
        <path d="M180 50H190V60H180V50Z" fill="#CBE9FF" />
        <path d="M190 50H200V60H190V50Z" fill="#CBE9FF" />
        <path d="M200 60H210V70H200V60Z" fill="#CBE9FF" />
        <path d="M200 70H210V80H200V70Z" fill="#CBE9FF" />
        <path d="M200 80H210V90H200V80Z" fill="#CBE9FF" />
        <path d="M190 90H200V100H190V90Z" fill="#CBE9FF" />
        <path d="M190 100H200V110H190V100Z" fill="#CBE9FF" />
        <path d="M190 100H200V110H190V100Z" fill="#CBE9FF" />
        <path d="M180 100H190V110H180V100Z" fill="#CBE9FF" />
        <path d="M170 100H180V110H170V100Z" fill="#CBE9FF" />
        <path d="M160 90H170V100H160V90Z" fill="#CBE9FF" />
        <path d="M150 100H160V110H150V100Z" fill="#CBE9FF" />
        <path d="M140 110H150V120H140V110Z" fill="#CBE9FF" />
        <path d="M130 110H140V120H130V110Z" fill="#CBE9FF" />
        <path d="M120 100H130V110H120V100Z" fill="#CBE9FF" />
        <path d="M110 100H120V110H110V100Z" fill="#CBE9FF" />
        <path d="M100 100H110V110H100V100Z" fill="#CBE9FF" />
        <path d="M90 110H100V120H90V110Z" fill="#CBE9FF" />
        <path d="M80 110H90V120H80V110Z" fill="#CBE9FF" />
        <path d="M70 100H80V110H70V100Z" fill="#CBE9FF" />
        <path d="M60 90H70V100H60V90Z" fill="#CBE9FF" />
        <path d="M50 100H60V110H50V100Z" fill="#CBE9FF" />
        <path d="M40 100H50V110H40V100Z" fill="#CBE9FF" />
        <path d="M30 100H40V110H30V100Z" fill="#CBE9FF" />
        <path d="M20 100H30V110H20V100Z" fill="#CBE9FF" />
        <path d="M10 90H20V100H10V90Z" fill="#CBE9FF" />
        <path d="M0 80H10V90H0V80Z" fill="#CBE9FF" />
        <path d="M0 70H10V80H0V70Z" fill="#CBE9FF" />
        <path d="M10 60H20V70H10V60Z" fill="#CBE9FF" />
        <path d="M20 50H30V60H20V50Z" fill="#CBE9FF" />
        <path d="M10 70H20V80H10V70Z" fill="#DFF2FF" />
      </g>
      <motion.g
        id="face"
        animate={{y: [-4, 0, -4]}}
        transition={{
          times: [0, 1],
          duration: 5,
          repeat: Infinity,
          type: 'keyframes',
          ease: 'easeInOut',
        }}
      >
        <motion.g
          id="face-2"
          animate={{x: [0, -3, -3, -6, 0, 6, 0, 0, 0, 3, 0, 0]}}
          transition={{
            times: [0, 1],
            duration: 20,
            repeat: Infinity,
            type: 'keyframes',
            ease: 'easeInOut',
            delay: 1
          }}
        >
          <path d="M90 50H100V60H90V50Z" fill="#92D1FF" />
          <path d="M80 50H90V60H80V50Z" fill="#92D1FF" />
          <path d="M130 50H140V60H130V50Z" fill="#92D1FF" />
          <path d="M140 50H150V60H140V50Z" fill="#92D1FF" />
          <path d="M120 80H130V90H120V80Z" fill="#92D1FF" />
          <path d="M110 80H120V90H110V80Z" fill="#92D1FF" />
          <path d="M100 80H110V90H100V80Z" fill="#92D1FF" />
          <path d="M90 80H100V90H90V80Z" fill="#92D1FF" />
          <path d="M130 80H140V90H130V80Z" fill="#92D1FF" />
        </motion.g>  
      </motion.g>
    </motion.g>
  </svg>
)
export default NormalTamagotchiSVG
