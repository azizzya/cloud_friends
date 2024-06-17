import React, { FC, useState } from 'react'
import { useNavigate } from 'react-router'
import './style.scss'

const TestModal: FC = () => {
    const [modalVisible, setModalVisible] = useState(true)
    const navigate = useNavigate()
    
    return (
        <div className='testModal' style={modalVisible ? {display: 'block'} : {display: 'none'}} >
            <div className="testModal-label">
                Пройдите тест для определения интровертности-экстравертности. Определение этого поможет точнее выдавать вам задания.
            </div>
            <div className="testModal-buttons">
                <div className="testModal-buttons-deny testModal-button" onClick={() => setModalVisible(false)}>
                    Позже
                </div>
                <div className="testModal-buttons-accept testModal-button" onClick={() => navigate('test')}>
                    Тест
                </div>
            </div>
        </div>
    )
}

export default TestModal;