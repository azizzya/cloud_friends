export function getUserDataFromLocalStorage() {
	let data = localStorage.getItem('userData');
	return data ? JSON.parse(data) : null
}

export function setUserDataToLocalStorage(
	userPassword: string,
	userLogin: string
) {
	if (localStorage.getItem('userData')) {
		localStorage.removeItem('userData');
	}

	localStorage.setItem(
		'userData',
		JSON.stringify({ Password: userPassword, Username: userLogin })
	);
}

export function removeUserDataFromLocalStorage() {
	localStorage.removeItem('userData');
	localStorage.removeItem('isTested');
}

export function setUserTestData(isTested : boolean) {
	if (localStorage.getItem('isTested')) {
		localStorage.removeItem('isTested')
	}
	isTested ? localStorage.setItem('isTested', 'true') : localStorage.setItem('isTested', 'false');
}

export function getUserTestData() {
	return localStorage.getItem('isTested')
}