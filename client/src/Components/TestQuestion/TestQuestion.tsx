import React, { useState } from 'react';
import './style.scss'
import instance from '../../Shared/Api/Axios.api';
import { setUserTestData } from '../../Shared/Helpers/LocalStorage.helpers';
import { useNavigate } from 'react-router';

type Question = {
    id: number;
    text: string;
    options: { text: string; value: number }[];
};

type Answer = {
    questionId: number;
    value: number;
};

const questions: Question[] = [
    {
        id: 1,
        text: 'Вы предпочитаете проводить время:',
        options: [
            { text: 'В компании людей', value: 1 },
            { text: 'Наедине или в узком кругу друзей', value: 0 },
        ],
    },
    {
        id: 2,
        text: 'Когда вы на вечеринке:',
        options: [
            { text: 'Вам нравится быть в центре внимания', value: 1 },
            { text: 'Вы чувствуете себя комфортнее на периферии', value: 0 },
        ],
    },
    {
        id: 3,
        text: 'Вы чувствуете себя лучше после:',
        options: [
            { text: 'Встречи с друзьями или коллегами', value: 1 },
            { text: 'Время, проведенное наедине', value: 0 },
        ],
    },
    {
        id: 4,
        text: 'Вы предпочитаете работать:',
        options: [
            { text: 'В команде', value: 1 },
            { text: 'Самостоятельно', value: 0 },
        ],
    },
    {
        id: 5,
        text: 'Как вы обычно решаете проблемы:',
        options: [
            { text: 'Обсуждаете их с другими', value: 1 },
            { text: 'Анализируете их самостоятельно', value: 0 },
        ],
    },
    {
        id: 6,
        text: 'Вам больше нравится:',
        options: [
            { text: 'Посещать мероприятия и встречи', value: 1 },
            { text: 'Проводить вечер дома, читая или занимаясь хобби', value: 0 },
        ],
    },
    {
        id: 7,
        text: 'Вы чувствуете, что получаете энергию от:',
        options: [
            { text: 'Взаимодействия с людьми', value: 1 },
            { text: 'Личного времени', value: 0 },
        ],
    },
    {
        id: 8,
        text: 'В новых ситуациях:',
        options: [
            { text: 'Вы быстро находите общий язык с людьми', value: 1 },
            { text: 'Вам нужно время, чтобы адаптироваться', value: 0 },
        ],
    },
    {
        id: 9,
        text: 'Вам нравится:',
        options: [
            { text: 'Заниматься спортом или хобби в группе', value: 1 },
            { text: 'Выполнять индивидуальные виды спорта или занятия', value: 0 },
        ],
    },
];

const PersonalityTest: React.FC = () => {
    const [answers, setAnswers] = useState<Answer[]>([]);
    const [completed, setCompleted] = useState(false);
    const [testResult, setTestResult] = useState(0);
    const navigate = useNavigate();

    const handleAnswerChange = (questionId: number, value: number) => {
        setAnswers((prevAnswers) =>
            prevAnswers.some((answer) => answer.questionId === questionId) ?
            prevAnswers.map((answer) =>
                answer.questionId === questionId
                ? { ...answer, value }
                : answer
            )
            : [...prevAnswers, { questionId, value }]
        );
    };

    const calculateResult = () => {
        return answers.reduce((acc, answer) => acc + answer.value, 0);
    };

    const sendResult = async () => {
        const result = calculateResult();
        setTestResult(result);

        await instance.post('users/personality', [
            {
                "personality_id": 1,
                "score_percent": 1 - result/9
            },
            {
                "personality_id": 2,
                "score_percent": result/9
            }
        ]).then(respone => {
            if (respone.status === 200) {
                setUserTestData(true)
                setCompleted(true)
                setTimeout(() => {
                    navigate('/')
                }, 5000)
            }
        })
    }

    if (completed) {
        return(
            <div className="test-results loading">
                Судя по результатам тестирования, вы, скорее всего, {testResult/9 >= 0.5 ? 'экстраверт' : 'интроверт'}.
                <br />
                <br />
                Через 5 секунд вы будете перенаправлены на главную страницу...
            </div>
        )
    }


    return (
        <div className='test' >
            <h1 className='heading2'>Тест на Интровертность-Экстравертность</h1>
            {questions.map((question) => (
                <div key={question.id} className='question'>
                    <p className='question-name'>{question.text}</p>

                    {question.options.map((option) => (
                        <label className='question-answer' key={option.value}>
                            <input
                                type="radio"
                                name={`question-${question.id}`}
                                value={option.value}
                                onChange={() => handleAnswerChange(question.id, option.value)}
                                checked={answers.some(
                                (answer) =>
                                    answer.questionId === question.id &&
                                    answer.value === option.value
                                )}
                                className='question-radio'
                            />
                            {option.text}
                        </label>
                    ))}

                </div>
            ))}

            <button className='primary-button test-send-button' onClick={sendResult} disabled={answers.length !== questions.length}>
                Отправить
            </button>
        </div>
    );
};

// понимаю, что компонент перегружен, но уже мало времени

export default PersonalityTest;
