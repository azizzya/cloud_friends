export interface ILeaderBoardUser {
	user_id?: number;
	firstname: string;
	lastname: string;
	username: string;
	coin_balance: number;
}

export interface LeaderBoardUserProps extends ILeaderBoardUser {
	pos: number;
}
