import React, { FC, useState } from 'react'
import './style.scss'
import { setUserDataToLocalStorage, setUserTestData } from '../../Shared/Helpers/LocalStorage.helpers'
import { useNavigate } from 'react-router-dom'
import instance from '../../Shared/Api/Axios.api'

const AuthPage: FC = () => {
    const navigate = useNavigate()
    const [login, setLogin] = useState('')
    const [password, setPassword] = useState('')
    const [error, setError] = useState('')

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        instance.post('auth', {username: login, password: password}).then(response => {
			if (response.status === 200) {
				setUserDataToLocalStorage(password, login);
                instance.get('users/personality').then(response => {
                    if (response.status === 200 && response.data === '') {
                        setUserTestData(false)
                    } else if (response.status === 200 && response.data !== '') {
                        setUserTestData(true)
                    }
                })
                navigate('/')
            }
            return response
		}).catch(error => setError(error.response.data.message));
    }

    return (
        <div className='auth-page-wrapper'>
            <h1 className='heading1'>Авторизация</h1>
            <form className='auth-form' method='post' onSubmit={handleSubmit}>
                <div className="auth-form-inputs">
                    <input type="text" className='primary-input' placeholder='Логин' value={login} onChange={e => setLogin(e.target.value)}/>
                    <input type="password" className='primary-input' placeholder='Пароль' value={password} onChange={e => setPassword(e.target.value)}/>
                </div>
                <button className='primary-button auth-button'>Авторизоваться</button>
            </form>
            <div className="auth-error">
                {error}
            </div>
        </div>
    )
}

export default AuthPage;