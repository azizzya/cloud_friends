import React, { FC, useEffect, useState } from 'react'
import instance from '../../Shared/Api/Axios.api';
import ProductCard from './ProductCard';
import './style.scss'

interface Product {
    item_id: string;
    item_image_name: string;
    name: string;
    price: number;
}

const StoreGrid: FC = () => {
    const [data, setData] = useState<Product[]>([])
    const [isLoading, setIsLoading] = useState(true)
    const [isError, setIsError] = useState(false)

    useEffect(() => {
        const fetchStore = async () => {
            try {
                const response = await instance.get('/store/items');
                setData(response.data);
            } catch (error) {
                console.error("Failed to fetch store data", error);
                setIsError(true)
            } finally {
                setIsLoading(false)
            }
        };
        fetchStore();
    }, []);
    
    if (isLoading) {
        return <div className='loading'>Загрузка...</div>
    }

    if (isError) {
        return <div className='loading'>Ошибка загрузки</div>
    }

    return (
        <div className='store-wrapper'>
            {data.map((product) => (
                <ProductCard
                    key={product.item_id}
                    item_image_name={product.item_image_name}
                    name={product.name}
                    price={product.price}
                />
            ))}
        </div>
    )
}

export default StoreGrid;