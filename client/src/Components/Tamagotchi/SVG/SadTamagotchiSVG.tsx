import { motion } from "framer-motion"
import * as React from "react"
import { SVGProps } from "react"
const SadTamagotchiSVG = (props: SVGProps<SVGSVGElement>) => (
  <svg
    width={300}
    viewBox="0 0 210 160"
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
        <path d="M40 80H50V90H40V80Z" fill="#C5DAE6" />
        <path d="M30 80H40V90H30V80Z" fill="#C5DAE6" />
        <path d="M30 70H40V80H30V70Z" fill="#C5DAE6" />
        <path d="M20 70H30V80H20V70Z" fill="#C5DAE6" />
        <path d="M30 60H40V70H30V60Z" fill="#C5DAE6" />
        <path d="M40 60H50V70H40V60Z" fill="#C5DAE6" />
        <path d="M40 70H50V80H40V70Z" fill="#C5DAE6" />
        <path d="M50 70H60V80H50V70Z" fill="#C5DAE6" />
        <path d="M50 80H60V90H50V80Z" fill="#C5DAE6" />
        <path d="M50 60H60V70H50V60Z" fill="#C5DAE6" />
        <path d="M60 50H70V60H60V50Z" fill="#C5DAE6" />
        <path d="M70 30H80V40H70V30Z" fill="#C5DAE6" />
        <path d="M90 30H100V40H90V30Z" fill="#C5DAE6" />
        <path d="M80 30H90V40H80V30Z" fill="#C5DAE6" />
        <path d="M70 40H80V50H70V40Z" fill="#C5DAE6" />
        <path d="M70 50H80V60H70V50Z" fill="#C5DAE6" />
        <path d="M70 60H80V70H70V60Z" fill="#C5DAE6" />
        <path d="M60 60H70V70H60V60Z" fill="#C5DAE6" />
        <path d="M60 70H70V80H60V70Z" fill="#C5DAE6" />
        <path d="M60 80H70V90H60V80Z" fill="#C5DAE6" />
        <path d="M70 80H80V90H70V80Z" fill="#C5DAE6" />
        <path d="M70 70H80V80H70V70Z" fill="#C5DAE6" />
        <path d="M80 70H90V80H80V70Z" fill="#C5DAE6" />
        <path d="M80 60H90V70H80V60Z" fill="#C5DAE6" />
        <path d="M90 60H100V70H90V60Z" fill="#C5DAE6" />
        <path d="M90 50H100V60H90V50Z" fill="#C5DAE6" />
        <path d="M80 50H90V60H80V50Z" fill="#C5DAE6" />
        <path d="M80 40H90V50H80V40Z" fill="#C5DAE6" />
        <path d="M130 50H140V60H130V50Z" fill="#C5DAE6" />
        <path d="M140 50H150V60H140V50Z" fill="#C5DAE6" />
        <path d="M140 40H150V50H140V40Z" fill="#C5DAE6" />
        <path d="M130 80H140V90H130V80Z" fill="#C5DAE6" />
        <path d="M120 70H130V80H120V70Z" fill="#C5DAE6" />
        <path d="M110 70H120V80H110V70Z" fill="#C5DAE6" />
        <path d="M100 70H110V80H100V70Z" fill="#C5DAE6" />
        <path d="M90 80H100V90H90V80Z" fill="#C5DAE6" />
        <path d="M100 60H110V70H100V60Z" fill="#C5DAE6" />
        <path d="M100 50H110V60H100V50Z" fill="#C5DAE6" />
        <path d="M100 40H110V50H100V40Z" fill="#C5DAE6" />
        <path d="M100 30H110V40H100V30Z" fill="#C5DAE6" />
        <path d="M100 20H110V30H100V20Z" fill="#C5DAE6" />
        <path d="M130 20H140V30H130V20Z" fill="#C5DAE6" />
        <path d="M120 20H130V30H120V20Z" fill="#C5DAE6" />
        <path d="M110 20H120V30H110V20Z" fill="#C5DAE6" />
        <path d="M110 30H120V40H110V30Z" fill="#C5DAE6" />
        <path d="M110 40H120V50H110V40Z" fill="#C5DAE6" />
        <path d="M110 50H120V60H110V50Z" fill="#C5DAE6" />
        <path d="M110 60H120V70H110V60Z" fill="#C5DAE6" />
        <path d="M120 60H130V70H120V60Z" fill="#C5DAE6" />
        <path d="M120 50H130V60H120V50Z" fill="#C5DAE6" />
        <path d="M120 40H130V50H120V40Z" fill="#C5DAE6" />
        <path d="M130 40H140V50H130V40Z" fill="#C5DAE6" />
        <path d="M140 30H150V40H140V30Z" fill="#C5DAE6" />
        <path d="M150 30H160V40H150V30Z" fill="#C5DAE6" />
        <path d="M160 40H170V50H160V40Z" fill="#C5DAE6" />
        <path d="M150 50H160V60H150V50Z" fill="#C5DAE6" />
        <path d="M140 80H150V90H140V80Z" fill="#C5DAE6" />
        <path d="M170 70H180V80H170V70Z" fill="#C5DAE6" />
        <path d="M130 70H140V80H130V70Z" fill="#C5DAE6" />
        <path d="M180 70H190V80H180V70Z" fill="#C5DAE6" />
        <path d="M160 60H170V70H160V60Z" fill="#C5DAE6" />
        <path d="M150 70H160V80H150V70Z" fill="#C5DAE6" />
        <path d="M120 30H130V40H120V30Z" fill="#C5DAE6" />
        <path d="M130 30H140V40H130V30Z" fill="#C5DAE6" />
        <path d="M150 40H160V50H150V40Z" fill="#C5DAE6" />
        <path d="M140 70H150V80H140V70Z" fill="#C5DAE6" />
        <path d="M140 60H150V70H140V60Z" fill="#C5DAE6" />
        <path d="M170 60H180V70H170V60Z" fill="#C5DAE6" />
        <path d="M160 70H170V80H160V70Z" fill="#C5DAE6" />
        <path d="M160 80H170V90H160V80Z" fill="#C5DAE6" />
        <path d="M150 80H160V90H150V80Z" fill="#C5DAE6" />
        <path d="M130 60H140V70H130V60Z" fill="#C5DAE6" />
        <path d="M130 90H140V100H130V90Z" fill="#C5DAE6" />
        <path d="M120 80H130V90H120V80Z" fill="#C5DAE6" />
        <path d="M120 90H130V100H120V90Z" fill="#C5DAE6" />
        <path d="M110 90H120V100H110V90Z" fill="#C5DAE6" />
        <path d="M100 90H110V100H100V90Z" fill="#C5DAE6" />
        <path d="M110 80H120V90H110V80Z" fill="#C5DAE6" />
        <path d="M100 80H110V90H100V80Z" fill="#C5DAE6" />
        <path d="M160 50H170V60H160V50Z" fill="#C5DAE6" />
        <path d="M150 60H160V70H150V60Z" fill="#C5DAE6" />
        <path d="M140 90H150V100H140V90Z" fill="#C5DAE6" />
        <path d="M170 80H180V90H170V80Z" fill="#C5DAE6" />
        <path d="M180 80H190V90H180V80Z" fill="#C5DAE6" />
        <path d="M90 40H100V50H90V40Z" fill="#C5DAE6" />
        <path d="M90 70H100V80H90V70Z" fill="#C5DAE6" />
        <path d="M90 90H100V100H90V90Z" fill="#C5DAE6" />
        <path d="M80 90H90V100H80V90Z" fill="#C5DAE6" />
        <path d="M80 80H90V90H80V80Z" fill="#C5DAE6" />
        <path d="M170 40H180V50H170V40Z" fill="#CEDEE9" />
        <path d="M170 50H180V60H170V50Z" fill="#CEDEE9" />
        <path d="M180 60H190V70H180V60Z" fill="#CEDEE9" />
        <path d="M190 60H200V70H190V60Z" fill="#CEDEE9" />
        <path d="M190 70H200V80H190V70Z" fill="#CEDEE9" />
        <path d="M190 80H200V90H190V80Z" fill="#CEDEE9" />
        <path d="M180 90H190V100H180V90Z" fill="#CEDEE9" />
        <path d="M170 90H180V100H170V90Z" fill="#CEDEE9" />
        <path d="M150 90H160V100H150V90Z" fill="#CEDEE9" />
        <path d="M140 100H150V110H140V100Z" fill="#CEDEE9" />
        <path d="M130 100H140V110H130V100Z" fill="#CEDEE9" />
        <path d="M90 100H100V110H90V100Z" fill="#CEDEE9" />
        <path d="M80 100H90V110H80V100Z" fill="#CEDEE9" />
        <path d="M70 90H80V100H70V90Z" fill="#CEDEE9" />
        <path d="M50 90H60V100H50V90Z" fill="#CEDEE9" />
        <path d="M40 90H50V100H40V90Z" fill="#CEDEE9" />
        <path d="M30 90H40V100H30V90Z" fill="#CEDEE9" />
        <path d="M20 90H30V100H20V90Z" fill="#CEDEE9" />
        <path d="M20 80H30V90H20V80Z" fill="#CEDEE9" />
        <path d="M10 70H20V80H10V70Z" fill="#CEDEE9" />
        <path d="M10 80H20V90H10V80Z" fill="#CEDEE9" />
        <path d="M10 70H20V80H10V70Z" fill="#CEDEE9" />
        <path d="M20 60H30V70H20V60Z" fill="#CEDEE9" />
        <path d="M30 50H40V60H30V50Z" fill="#CEDEE9" />
        <path d="M40 50H50V60H40V50Z" fill="#CEDEE9" />
        <path d="M50 50H60V60H50V50Z" fill="#CEDEE9" />
        <path d="M60 40H70V50H60V40Z" fill="#CEDEE9" />
        <path d="M60 30H70V40H60V30Z" fill="#CEDEE9" />
        <path d="M70 20H80V30H70V20Z" fill="#CEDEE9" />
        <path d="M80 20H90V30H80V20Z" fill="#CEDEE9" />
        <path d="M90 20H100V30H90V20Z" fill="#CEDEE9" />
        <path d="M100 10H110V20H100V10Z" fill="#CEDEE9" />
        <path d="M110 10H120V20H110V10Z" fill="#CEDEE9" />
        <path d="M120 10H130V20H120V10Z" fill="#CEDEE9" />
        <path d="M130 10H140V20H130V10Z" fill="#CEDEE9" />
        <path d="M140 20H150V30H140V20Z" fill="#CEDEE9" />
        <path d="M150 20H160V30H150V20Z" fill="#CEDEE9" />
        <path d="M160 30H170V40H160V30Z" fill="#CEDEE9" />
        <path d="M30 40H40V50H30V40Z" fill="#CFDCE5" />
        <path d="M40 40H50V50H40V40Z" fill="#CFDCE5" />
        <path d="M50 40H60V50H50V40Z" fill="#CFDCE5" />
        <path d="M50 30H60V40H50V30Z" fill="#CFDCE5" />
        <path d="M60 20H70V30H60V20Z" fill="#CFDCE5" />
        <path d="M70 10H80V20H70V10Z" fill="#CFDCE5" />
        <path d="M80 10H90V20H80V10Z" fill="#CFDCE5" />
        <path d="M90 10H100V20H90V10Z" fill="#CFDCE5" />
        <path d="M100 0H110V10H100V0Z" fill="#CFDCE5" />
        <path d="M110 0H120V10H110V0Z" fill="#CFDCE5" />
        <path d="M120 0H130V10H120V0Z" fill="#CFDCE5" />
        <path d="M130 0H140V10H130V0Z" fill="#CFDCE5" />
        <path d="M140 10H150V20H140V10Z" fill="#CFDCE5" />
        <path d="M150 10H160V20H150V10Z" fill="#CFDCE5" />
        <path d="M160 20H170V30H160V20Z" fill="#CFDCE5" />
        <path d="M170 30H180V40H170V30Z" fill="#CFDCE5" />
        <path d="M180 40H190V50H180V40Z" fill="#CFDCE5" />
        <path d="M180 50H190V60H180V50Z" fill="#CFDCE5" />
        <path d="M190 50H200V60H190V50Z" fill="#CFDCE5" />
        <path d="M200 60H210V70H200V60Z" fill="#CFDCE5" />
        <path d="M200 70H210V80H200V70Z" fill="#CFDCE5" />
        <path d="M200 80H210V90H200V80Z" fill="#CFDCE5" />
        <path d="M190 90H200V100H190V90Z" fill="#CFDCE5" />
        <path d="M190 100H200V110H190V100Z" fill="#CFDCE5" />
        <path d="M190 100H200V110H190V100Z" fill="#CFDCE5" />
        <path d="M180 100H190V110H180V100Z" fill="#CFDCE5" />
        <path d="M170 100H180V110H170V100Z" fill="#CFDCE5" />
        <path d="M160 90H170V100H160V90Z" fill="#CFDCE5" />
        <path d="M150 100H160V110H150V100Z" fill="#CFDCE5" />
        <path d="M140 110H150V120H140V110Z" fill="#CFDCE5" />
        <path d="M130 110H140V120H130V110Z" fill="#CFDCE5" />
        <path d="M120 100H130V110H120V100Z" fill="#CFDCE5" />
        <path d="M110 100H120V110H110V100Z" fill="#CFDCE5" />
        <path d="M100 100H110V110H100V100Z" fill="#CFDCE5" />
        <path d="M90 110H100V120H90V110Z" fill="#CFDCE5" />
        <path d="M80 110H90V120H80V110Z" fill="#CFDCE5" />
        <path d="M70 100H80V110H70V100Z" fill="#CFDCE5" />
        <path d="M60 90H70V100H60V90Z" fill="#CFDCE5" />
        <path d="M50 100H60V110H50V100Z" fill="#CFDCE5" />
        <path d="M40 100H50V110H40V100Z" fill="#CFDCE5" />
        <path d="M30 100H40V110H30V100Z" fill="#CFDCE5" />
        <path d="M20 100H30V110H20V100Z" fill="#CFDCE5" />
        <path d="M10 90H20V100H10V90Z" fill="#CFDCE5" />
        <path d="M0 80H10V90H0V80Z" fill="#CFDCE5" />
        <path d="M0 70H10V80H0V70Z" fill="#CFDCE5" />
        <path d="M10 60H20V70H10V60Z" fill="#CFDCE5" />
        <path d="M20 50H30V60H20V50Z" fill="#CFDCE5" />
        <path d="M10 70H20V80H10V70Z" fill="#CEDEE9" />
      </g>
      <motion.g 
        id="rain1"
        animate={{y: [-20, 100], opacity: [0, 0.9, 0.6, 0]}}
        transition={{
          duration: 1.5,
          repeat: Infinity,
          ease: 'easeIn'
        }}
      >
        <path d="M20 120H30V130H20V120Z" fill="#63B4FF" />
        <path d="M90 130H100V140H90V130Z" fill="#63B4FF" />
        <path d="M70 150H80V160H70V150Z" fill="#63B4FF" />
        <path d="M180 120H190V130H180V120Z" fill="#63B4FF" />
      </motion.g>
      <motion.g 
        id="rain2"
        animate={{y: [-10, 100], opacity: [0, 0.9, 0.6, 0]}}
        transition={{
          duration: 1,
          repeat: Infinity,
          ease: 'easeIn',
          delay: 1
        }}
      >
        <path d="M160 130H170V140H160V130Z" fill="#63B4FF" />
        <path d="M120 140H130V150H120V140Z" fill="#63B4FF" />
        <path d="M60 130H70V140H60V130Z" fill="#63B4FF" />
        <path d="M40 140H50V150H40V140Z" fill="#63B4FF" />
        <path d="M40 110H50V120H40V110Z" fill="#63B4FF" />
      </motion.g>
      <motion.g 
        id="rain3"
        animate={{y: [-5, 100], opacity: [0, 0.9, 0.6, 0]}}
        transition={{
          duration: 1.5,
          repeat: Infinity,
          ease: 'easeIn',
          delay: 2,
          
        }}
      >
        <path d="M110 110H120V120H110V110Z" fill="#63B4FF" />
        <path d="M100 150H110V160H100V150Z" fill="#63B4FF" />
        <path d="M140 150H150V160H140V150Z" fill="#63B4FF" />
        <path d="M170 150H180V160H170V150Z" fill="#63B4FF" />
      </motion.g>
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
          <path d="M110 70H120V80H110V70Z" fill="#6B6B6B" />
          <path d="M120 70H130V80H120V70Z" fill="#6B6B6B" />
          <path d="M100 70H110V80H100V70Z" fill="#6B6B6B" />
          <path d="M90 40H100V50H90V40Z" fill="#6B6B6B" />
          <path d="M90 50H100V60H90V50Z" fill="#6B6B6B" />
          <path d="M80 50H90V60H80V50Z" fill="#6B6B6B" />
          <path d="M130 40H140V50H130V40Z" fill="#6B6B6B" />
          <path d="M130 50H140V60H130V50Z" fill="#6B6B6B" />
          <path d="M140 50H150V60H140V50Z" fill="#6B6B6B" />
          <path d="M90 80H100V90H90V80Z" fill="#6B6B6B" />
          <path d="M130 80H140V90H130V80Z" fill="#6B6B6B" />
        </motion.g>
      </motion.g>
    </motion.g>
  </svg>
)
export default SadTamagotchiSVG
