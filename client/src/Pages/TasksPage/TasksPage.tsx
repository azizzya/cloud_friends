import React, { FC, useEffect, useState } from 'react'
import './style.scss'
import instance from '../../Shared/Api/Axios.api';
import { ITaskDetails } from '../../Shared/Interfaces/taskDetails.interface';
import TaskList from '../../Components/Tasks/TaskList';

const TasksPage: FC = () => {    
    const [tasks, setTasks] = useState<ITaskDetails[]>([]);
    const [isLoading, setIsLoading] = useState(true);
    const [isError, setIsError] = useState(false);
    const [activeTasks, setActiveTasks] = useState<ITaskDetails[]>([]);
    const [completedTasks, setCompletedTasks] = useState<ITaskDetails[]>([]);

    useEffect(() => {
        const fetchTasks = async () => {
            try {
                const response = await instance.get('tasks/details')
                setTasks(response.data)
            } catch (error) {
                console.error('Failed to fetch tasks data', error)
                setIsError(true)
            } finally {
                setIsLoading(false)
            }
        }
        fetchTasks()
    }, [])

    useEffect(() => {
        filterTasks()
    }, [tasks])

    const filterTasks = () => {
        const filteredActiveTasks = tasks.filter(task => !task.is_done)
        setActiveTasks(filteredActiveTasks);

        const filteredCompletedTasks = tasks.filter(task => task.is_done)
        setCompletedTasks(filteredCompletedTasks);
    }

    if (isLoading) {
        return <div className='loading'>Загрузка...</div>
    }

    if (isError) {
        return <div className='loading'>Ошибка загрузки</div>
    }

    return (
        <div className='page-wrapper'>
            <header className='page-header'>
                <h1 className='heading1'>Задания</h1>
            </header>
            <TaskList activeTasks={activeTasks} completedTasks={completedTasks} />
        </div>
    )
}

export default TasksPage;
