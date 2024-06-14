import { IPersonality, IProfile } from "./profile.interface";

export interface ITaskDetails {
    task_details_id: number;
    created: string;
    task_deadline: string;
    is_done: boolean;
    coin_reward: number;
    friend: IProfile;
    task: ITask;
}

export interface ITask {
    task_id: number;
    title: string;
    coin_reward?: number;
    description: string;
    personality: IPersonality;
}