import { LeaderBoardUserProps } from './interface';
import './style.scss';

export const LeaderBoardUser: React.FC<LeaderBoardUserProps> = ({
	firstname,
	coin_balance,
	pos,
	username,
	lastname,
}) => {
	return (
		<div className='leaderBoard-user-wrapper'>
			<div className='leaderBoard-user-item'>
				<div className='leaderBoard-user-item-pos'>
					<div className='leaderBoard-user-item-pos-num'>{pos}</div>
					<div className='leaderBoard-user-item-pos-dash'>–</div>
				</div>

				<div className='leaderBoard-user-item-img'>
					{/* <img
						src={img_path}
						alt='Profile_img'
					></img> */}
				</div>

				<div className='leaderBoard-user-item-text'>
					<div className='leaderBoard-user-item-text-name'>{`${firstname} ${lastname}`}</div>
					<div className='leaderBoard-user-item-text-login'>{'@' + username}</div>
				</div>
			</div>
			

			<div className='leaderBoard-user-item'>
				<div className='leaderBoard-user-item-score'>{`${coin_balance}¢`}</div>
			</div>
		</div>
	);
};
