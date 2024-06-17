import React, { FC, useEffect, useState } from 'react'
import './style.scss'
import instance from '../../Shared/Api/Axios.api'
import Tamagotchi, { ITamagotchi } from '../../Components/Tamagotchi/Tamagotchi';
import { getUserTestData } from '../../Shared/Helpers/LocalStorage.helpers';
import TestModal from '../../Components/TestModal/TestModal';

interface MainPageProps {
    
}

const MainPage: FC<MainPageProps> = () => {
    const [tamagotchi, setTamagotchi] = useState<ITamagotchi>();
    const [isLoading, setIsLoading] = useState(true);
    const [isError, setIsError] = useState(false);
    const [isTested, setIsTested] = useState(Boolean);

    useEffect(() => {
        const fetchTamagotchi = async () => {
            try {
                const response = await instance.get<ITamagotchi>('tamagotchi')
                setTamagotchi(response.data)
            } catch (error) {
                console.error("Failed to fetch tamagotchi data", error)
                setIsError(true)
            } finally {
                setIsLoading(false);
            }
        }
        fetchTamagotchi()        
    }, [])

    useEffect(() => { 
        const checkIsTested = () => {
            const tested = getUserTestData()
            setIsTested(Boolean(tested))
        }
        checkIsTested()
    })


    if (isLoading) {
        return <div className='loading'>Загрузка...</div>
    }

    if (isError) {
        return <div className='loading'>Ошибка загрузки</div>
    }

    return (
        <div className="page-wrapper">
            {!isTested ? <TestModal /> : ''}
            <Tamagotchi happiness={tamagotchi?.happiness}/>
        </div>
    )
}

export default MainPage;