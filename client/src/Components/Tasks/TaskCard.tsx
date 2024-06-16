import React, { FC, useState } from 'react';
import { ITaskDetails } from '../../Shared/Interfaces/taskDetails.interface';
import './style.scss';

interface TaskCardProps {
    task: ITaskDetails,
    type: string
}

const TaskCard: FC<TaskCardProps> = ({ task, type }) => {
    function dateDiffInDays(date: string): number {
        const convertedDate = new Date(date)
        const now = Date.now();
        const diffTime = Math.abs(now - convertedDate.getTime());
        const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
        return diffDays;
    }

    const [isVibible, setIsVisible] = useState(false)
    function descriptionToggle() {
        isVibible ? setIsVisible(false) : setIsVisible(true);
    }
    return (
        <div className={`task-wrapper task-wrapper-${type} ${isVibible ? `task-wrapper-${type}-visible` : ''}`} onClick={() => descriptionToggle()}>
            <div className="task-wrapper-line">
                <div className="task-wrapper-line">
                    <div className="task-wrapper-name">
                        {task.task.title}
                    </div>
                    {
                        !task.is_done ? (
                            <div className="task-wrapper-deadline">
                                {dateDiffInDays(task.task_deadline) + ' дн.'}
                            </div>
                        ) : ''
                    }
                    <div className="task-wrapper-reward">
                        {task.coin_reward + '¢'}
                    </div>
                </div>
                <div className="task-wrapper-arrow">
                    {isVibible ? '▲' : '▼'}
                </div>
            </div>

            <div className="task-wrapper-description-block" style={isVibible ? {display: 'block'} : {display: 'none'}}>
                <hr />
                <div className="task-wrapper-description">
                    {task.task.description}
                </div>
                <div className="friendName">
                    {'Вместе с: ' + task.friend.firstname + ' ' + task.friend.lastname}
                </div>
            </div>
        </div>
    )
}

export default TaskCard;