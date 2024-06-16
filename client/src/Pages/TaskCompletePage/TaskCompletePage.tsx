import React, { FC, useEffect, useState } from 'react'
import instance from '../../Shared/Api/Axios.api'
import { useNavigate } from 'react-router'

const TaskCompletePage: FC = () => {
    const navigate = useNavigate()
    const URL = new URLSearchParams(window.location.search)
    const friend_id = URL.get('friend_id')
    
    const [isLoading, setIsLoading] = useState(true)
    const [isError, setIsError] = useState(false)

    useEffect(() => {
        const fetchComplete = async () => {
            try {
                await instance.patch(`tasks/details/complete?friend_id=${friend_id}`)
            } catch (error) {
                console.error("Failed to fetch TaskComplete", error)
                setIsError(true)
            } finally {
                setIsLoading(false)
                setTimeout(() => {
                    navigate('/tasks')
                }, 5000)
            }
        }
        fetchComplete()
    }, [friend_id, navigate])

    
    if (isLoading) {
        return <div className='loading'>Загрузка...</div>
    }

    if (isError) {
        return <div className='loading'>Ошибка выполнения задания. <br /> Проверьте, есть ли у вас со владельцем QR-кода совместное задание.</div>
    }

    return (
        <div className="page-wrapper">
            <div className='loading'>
                Задание успешно завершено! <br />
                Вы будете перенаправлены на страницу заданий через 5 секунд...
            </div>
        </div>
    )
}

export default TaskCompletePage;