import axios from 'axios';
import { IUserLogIn } from '../Interfaces/User.interface';
import { setUserDataToLocalStorage } from '../Helpers/LocalStorage.helpers';

class AuthService {
	async auth({username, password}: IUserLogIn) {
		return axios.post('http://31.128.36.245:8080/auth', {username, password}).then(response => {
			if (response.data === '') {
				setUserDataToLocalStorage(password, username)
			}
			return response;
		});
	}
}

export const authService = new AuthService();
