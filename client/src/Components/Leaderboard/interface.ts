export interface ILeaderBoardUser {
	user_id?: number;
	firstname: string;
	lastname: string;
	username: string;
	coin_total_score: number;
	profile_image_name: string;
}

export interface LeaderBoardUserProps extends ILeaderBoardUser {
	pos: number;
}
