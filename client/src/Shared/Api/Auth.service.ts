import { IUserLogIn } from '../Interfaces/User.interface';
import instance from './Axios.api';

class AuthService {
	async auth(user: IUserLogIn) {
		return instance.post('/auth', user);
	}
}

export const authService = new AuthService();
