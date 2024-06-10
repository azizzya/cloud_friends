import { FC, useEffect, useState } from "react";
import instance from "../../Shared/Api/Axios.api";

interface IProductCardProps {
	item_image_name: string;
	name: string;
	price: number;
}

const ProductCard: FC<IProductCardProps> = ({
	item_image_name,
	name,
	price,
}) => {
	const [image, setImage] = useState<any>();
    useEffect(() => {
		const getImage = async (item_image_name: string) => {
			try {
				const response = await instance.get(`/store/items/images/${item_image_name}`, { responseType: 'blob' });
				const imageBlob = response.data;
				const imageUrl = URL.createObjectURL(imageBlob);
				setImage(imageUrl);
			} catch (e) {
				console.error('Error loading image:', e);
			}
		};
		if (item_image_name) {
			getImage(item_image_name);
		}
	}, [item_image_name]);
	return (
		<div className='card-wrapper'>
			<img src={image} className='product-image' alt="" />
            <div className='product-price'>{`${price}¢`}</div>
            <div className='product-name'>{name}</div>
		</div>
	);
};

export default ProductCard;