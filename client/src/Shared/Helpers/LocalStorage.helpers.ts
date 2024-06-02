export function getUserDataFromLocalStorage(): {
	Username: string;
	Password: string;
} {
	let data = localStorage.getItem('userData');
	const userData = data ? JSON.parse(data) : '';

	return userData;
}

export function setUserDataToLocalStorage(
	userPassword: string,
	userLogin: string
): void {
	if (localStorage.getItem('userData')) {
		localStorage.removeItem('userData');
	}

	localStorage.setItem(
		'userData',
		JSON.stringify({ Password: userPassword, Username: userLogin })
	);
}

export function removeUserDataFromLocalStorage(): void {
	localStorage.removeItem('userData');
}
