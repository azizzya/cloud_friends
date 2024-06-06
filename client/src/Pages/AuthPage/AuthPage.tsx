import React, { FC, useState } from 'react'
import './style.scss'
import axios from 'axios'
import { setUserDataToLocalStorage } from '../../Shared/Helpers/LocalStorage.helpers'
import { useNavigate } from 'react-router-dom'

const AuthPage: FC = () => {
    const navigate = useNavigate()
    const [login, setLogin] = useState('')
    const [password, setPassword] = useState('')
    const [error, setError] = useState('')

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        axios.post('http://31.128.36.245:8080/auth', {username: login, password: password}).then(response => {
			if (response.data === '') {
				setUserDataToLocalStorage(password, login);
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
                <button className='primary-button'>Авторизоваться</button>
            </form>
            <div className="auth-error">
                {error}
            </div>
        </div>
    )
}

export default AuthPage;