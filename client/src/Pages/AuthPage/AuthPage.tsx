import React, { FC, useState } from 'react'
import './style.scss'
import axios from 'axios'
import { authService } from '../../Shared/Api/Auth.service'
import { error } from 'console'

interface AuthPageProps {
    
}

const AuthPage: FC<AuthPageProps> = () => {
    const [login, setLogin] = useState('')
    const [password, setPassword] = useState('')

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        // authService.auth({username: login, password: password});
        axios.post('http://31.128.36.245:8080/auth', {
            username: login,
            password: password
        }).then(response => console.log(response)).catch(error => console.error(error))
    }

    return (
        <div className='page-wrapper'>
            <h1 className='heading1'>Авторизация</h1>
            <form className='auth-form' method='post' onSubmit={handleSubmit}>
                <div className="auth-form-inputs">
                    <input type="text" className='primary-input' placeholder='Логин' value={login} onChange={e => setLogin(e.target.value)}/>
                    <input type="password" className='primary-input' placeholder='Пароль' value={password} onChange={e => setPassword(e.target.value)}/>
                </div>
                <button className='primary-button'>Авторизоваться</button>
            </form>
        </div>
    )
}

export default AuthPage;