import React, { FC, useEffect, useState } from 'react'
import './style.scss'
import instance from '../../Shared/Api/Axios.api'
import { IProfile } from '../../Shared/Interfaces/profile.interface';
import { ExitSVGComponent } from '../../Shared/SVGs/Exit.SVG.Component';
import { removeUserDataFromLocalStorage } from '../../Shared/Helpers/LocalStorage.helpers';

const ProfilePage: FC = () => {
    const [profile, setProfile] = useState<IProfile>();
    const [isLoading, setIsLoading] = useState(true);
    const [isError, setIsError] = useState(false);

    useEffect(() => {
        const fetchProfile = async () => {
            try {
                const response = await instance.get<IProfile>('users/profile')
                setProfile(response.data)
            } catch (error) {
                console.error("Failed to fetch profile data", error);
                setIsError(true)
            } finally {
                setIsLoading(false)
            }
        }
        fetchProfile();
    }, [])

    const [image, setImage] = useState<any>();
	useEffect(() => {
		const getImage = async (profile_image_name: string) => {
			try {
				const response = await instance.get(`users/images/${profile_image_name}`, { responseType: 'blob' });
				const imageBlob = response.data;
				const imageUrl = URL.createObjectURL(imageBlob);
				setImage(imageUrl);
			} catch (e) {
				console.error('Error loading image:', e);
			}
		};
		if (profile?.profile_image_name) {
			getImage(profile.profile_image_name);
		}
	}, [profile?.profile_image_name]);
    
    const handleExit = () => {
        removeUserDataFromLocalStorage();
        window.location.reload();
    }

    if (isLoading) {
        return <div className='loading'>Загрузка...</div>
    }

    if (isError) {
        return <div className='loading'>Ошибка загрузки</div>
    }

    return (
        <div className="page-wrapper">
            <button className='exit-button' onClick={() => handleExit()}>
                <ExitSVGComponent width='26px' height='26px'/>
            </button>
            <div className='profile-info'>
                <div className='profile-info-img'>
                    <img src={image} alt='Profile'/>
                </div>
                <div className='profile-info-name'>
                    {`${profile?.firstname} ${profile?.lastname}`}
                </div>
                {profile?.personality !== null ?
                    <div className={`profile-info-personality-${profile?.personality && profile?.personality.personality_type_id}`}>
                        {`${profile?.personality && profile?.personality.name}`}
                    </div>
                    :
                    ''
                }
                <div className='profile-info-text-login'>{`@${profile?.username}`}</div>
                {profile?.qr_code !== "" ?
                    <img className='profile-qr' src={`data:image/png;base64,${profile?.qr_code}`} alt='QR Code' />
                    :
                    ''
                }
            </div>
        </div>
    )
}

export default ProfilePage;