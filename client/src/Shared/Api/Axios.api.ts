import axios from 'axios';
import { getUserDataFromLocalStorage } from '../Helpers/LocalStorage.helpers';

const instance = axios.create({
	baseURL: 'http://localhost:8080/',
	withCredentials: true,
});

instance.interceptors.request.use(
	config => {
		const userData = getUserDataFromLocalStorage();
		if (userData) {
			const { Username, Password } = userData;
			const base64Credentials = btoa(`${Username}:${Password}`);
			config.headers.Authorization = `Basic ${base64Credentials}`;
		}
		return config;
	},
	error => {
		return Promise.reject(error);
	}
);

export default instance