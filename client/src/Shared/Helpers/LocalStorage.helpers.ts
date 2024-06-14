export function getUserDataFromLocalStorage() {
	let data = localStorage.getItem('userData');
	return data ? JSON.parse(data) : null
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
