import React, { FC } from 'react';
import { ITaskDetails } from '../../Shared/Interfaces/taskDetails.interface';
import TaskCard from './TaskCard';
import './style.scss';

interface TaskListProps {
    activeTasks: ITaskDetails[];
    completedTasks: ITaskDetails[];
}

const TaskList: FC<TaskListProps> = ({
    activeTasks,
    completedTasks
}) => {
    return (
        <div className='tasks'>
            <div className="active-tasks-block tasks-block">
                <h2 className='heading2'>Активные задания</h2>
                {
                    activeTasks.map(task => (
                        <TaskCard key={task.task_details_id} task={task} type='active'/>
                    ))
                }
            </div>
            <div className="completed-tasks-block tasks-block">
                <h2 className='heading2'>Выполненные задания</h2>
                {
                    completedTasks.map(task => (
                        <TaskCard key={task.task_details_id} task={task} type='completed'/>
                    ))
                }
            </div>
        </div>
    )
}

export default TaskList;