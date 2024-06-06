import { useNavigate } from 'react-router-dom';
import { IServiceCardProps } from './interface';
import { useState } from 'react';

export const ServiceCard: React.FC<IServiceCardProps> = ({
	text,
	SVGComponent,
	label,
}) => {
	const navigate = useNavigate();

	const onClickHandler = () => {
		navigate(`/menu/${label}`);
	};

	return (
		<button className='primary-button' onClick={onClickHandler}>
			<div className='menu-button-content-container'>
				<div className='menu-button-content-container-img'> 
					<SVGComponent fillColor='white' width='30px' height='30px' />
				</div>
				<div className='menu-button-content-container-text'>{text}</div>
			</div>
		</button>
	);
};
