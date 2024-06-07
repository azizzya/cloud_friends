import React, { FC } from 'react'
import './style.scss'
import instance from '../../Shared/Api/Axios.api'

interface StorePageProps {
    
}

const StorePage: FC<StorePageProps> = ({  }) => {
    instance.get('store/items').then(response => console.log(response))
    return (
        <div>
            
        </div>
    )
}

export default StorePage;