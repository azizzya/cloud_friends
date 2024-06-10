import { FC, useEffect, useState } from "react";
import instance from "../../Shared/Api/Axios.api";

interface IStoreBalance {
    className: string;
}

export const StoreBalance: FC<IStoreBalance> = ({className}) => {
    const [balance, setBalance] = useState(Number)
    useEffect(() => {
        const fetchUserBalance = async () => {
            try {
                const response = await instance.get('users/profile');
                setBalance(response.data.coin_balance)
            } catch (error) {
                console.error("Failed to fetch balance", error);
            }
        }
        fetchUserBalance();
    })
	return <div className={'storeBalance-wrapper ' + className}>{`${balance}¢`}</div>; //заготовка
};