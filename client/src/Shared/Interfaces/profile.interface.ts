export interface IProfile {
    username: string;
    firstname: string;
    lastname: string;
    qr_code?: string;
    profile_image_name: string;
    personality: IPersonality;
}

interface IPersonality {
    personality_type_id: number;
    name: string;
}