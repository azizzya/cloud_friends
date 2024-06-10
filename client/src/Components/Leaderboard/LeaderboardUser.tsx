import { useEffect, useState } from 'react';
import instance from '../../Shared/Api/Axios.api';
import { LeaderBoardUserProps } from './interface';
import './style.scss';

export const LeaderBoardUser: React.FC<LeaderBoardUserProps> = ({
	firstname,
	coin_total_score,
	pos,
	username,
	lastname,
	profile_image_name
}) => {
	const [image, setImage] = useState<any>();
	useEffect(() => {
		const getImage = async (profile_image_name: string) => {
			try {
				const response = await instance.get(`users/images/${profile_image_name}`, { responseType: 'blob' });
				const imageBlob = response.data;
				const imageUrl = URL.createObjectURL(imageBlob);
				setImage(imageUrl);
			} catch (e) {
				console.error('Error loading image:', e);
			}
		};
		if (profile_image_name) {
			getImage(profile_image_name);
		}
	}, [profile_image_name]);
	
	return (
		<div className='leaderBoard-user-wrapper'>
			<div className='leaderBoard-user-item'>
				<div className='leaderBoard-user-item-pos'>
					<div className='leaderBoard-user-item-pos-num'>{pos}</div>
					<div className='leaderBoard-user-item-pos-dash'>–</div>
				</div>

				<div className='leaderBoard-user-item-img'>
					<img
						src={image}
						alt='Profile_img'
					></img>
				</div>

				<div className='leaderBoard-user-item-text'>
					<div className='leaderBoard-user-item-text-name'>{`${firstname} ${lastname}`}</div>
					<div className='leaderBoard-user-item-text-login'>{'@' + username}</div>
				</div>
			</div>
			

			<div className='leaderBoard-user-item'>
				<div className='leaderBoard-user-item-score'>{`${coin_total_score}¢`}</div>
			</div>
		</div>
	);
};
