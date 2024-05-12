import { ISVGComponentProps } from '../../interfaces/SVGComponent.interfaces';

export const LeaderBoardSVGComponent: React.FC<ISVGComponentProps> = ({
	fillColor = 'black',
	height = '100%',
	width = '100%',
}) => {
	return (
		<svg
			fill={fillColor}
			width={width}
			height={height}
			viewBox='0 0 42 30'
			xmlns='http://www.w3.org/2000/svg'
		>
			<path
				fillRule='evenodd'
				clipRule='evenodd'
				d='M12.1154 0C10.2793 0 8.51836 0.729394 7.22003 2.02772C5.9217 3.32605 5.19231 5.08696 5.19231 6.92308C5.19231 8.75919 5.9217 10.5201 7.22003 11.8184C8.51836 13.1168 10.2793 13.8462 12.1154 13.8462C13.9515 13.8462 15.7124 13.1168 17.0107 11.8184C18.3091 10.5201 19.0385 8.75919 19.0385 6.92308C19.0385 5.08696 18.3091 3.32605 17.0107 2.02772C15.7124 0.729394 13.9515 0 12.1154 0ZM8.65385 6.92308C8.65385 7.37765 8.74338 7.82778 8.91734 8.24775C9.0913 8.66772 9.34627 9.04932 9.66771 9.37075C9.98914 9.69219 10.3707 9.94716 10.7907 10.1211C11.2107 10.2951 11.6608 10.3846 12.1154 10.3846C12.57 10.3846 13.0201 10.2951 13.4401 10.1211C13.86 9.94716 14.2416 9.69219 14.5631 9.37075C14.8845 9.04932 15.1395 8.66772 15.3134 8.24775C15.4874 7.82778 15.5769 7.37765 15.5769 6.92308C15.5769 6.00502 15.2122 5.12456 14.5631 4.4754C13.9139 3.82623 13.0334 3.46154 12.1154 3.46154C11.1973 3.46154 10.3169 3.82623 9.66771 4.4754C9.01854 5.12456 8.65385 6.00502 8.65385 6.92308ZM3.9 18.6231C6.11538 17.3538 9.02308 16.7308 12.1154 16.7308C15.2077 16.7308 18.1154 17.3538 20.3308 18.6231C22.5923 19.9154 24.2308 22.0154 24.2308 24.8077C24.2308 26.4231 23.5846 27.8077 22.4308 28.7538C21.3231 29.6538 19.8923 30 18.4615 30H5.76923C4.36154 30 2.90769 29.6538 1.8 28.7538C0.646154 27.8308 0 26.4462 0 24.8077C0 22.0154 1.63846 19.9154 3.9 18.6231ZM5.63077 21.6231C4.13077 22.4769 3.46154 23.5615 3.46154 24.8077C3.46154 25.5 3.69231 25.8231 3.96923 26.0538C4.29231 26.3077 4.89231 26.5385 5.76923 26.5385H18.4615C19.3615 26.5385 19.9385 26.3077 20.2615 26.0538C20.5385 25.8231 20.7692 25.4769 20.7692 24.8077C20.7692 23.5615 20.1 22.5 18.6 21.6231C17.0769 20.7231 14.7923 20.1923 12.1154 20.1923C9.43846 20.1923 7.15385 20.7231 5.63077 21.6231ZM29.4231 0C27.587 0 25.826 0.729394 24.5277 2.02772C23.2294 3.32605 22.5 5.08696 22.5 6.92308C22.5 8.75919 23.2294 10.5201 24.5277 11.8184C25.826 13.1168 27.587 13.8462 29.4231 13.8462C31.2592 13.8462 33.0201 13.1168 34.3184 11.8184C35.6168 10.5201 36.3462 8.75919 36.3462 6.92308C36.3462 5.08696 35.6168 3.32605 34.3184 2.02772C33.0201 0.729394 31.2592 0 29.4231 0ZM25.9615 6.92308C25.9615 7.84113 26.3262 8.72159 26.9754 9.37075C27.6246 10.0199 28.505 10.3846 29.4231 10.3846C30.3411 10.3846 31.2216 10.0199 31.8708 9.37075C32.5199 8.72159 32.8846 7.84113 32.8846 6.92308C32.8846 6.00502 32.5199 5.12456 31.8708 4.4754C31.2216 3.82623 30.3411 3.46154 29.4231 3.46154C28.505 3.46154 27.6246 3.82623 26.9754 4.4754C26.3262 5.12456 25.9615 6.00502 25.9615 6.92308Z'
			/>
			<path d='M29.423 20.1923C28.8923 20.1923 28.3846 20.2154 27.8538 20.2615C27.6197 20.2996 27.3803 20.2892 27.1505 20.231C26.9206 20.1727 26.7051 20.0678 26.5175 19.9228C26.3298 19.7778 26.1739 19.5958 26.0595 19.3881C25.9452 19.1803 25.8747 18.9513 25.8525 18.7152C25.8303 18.4791 25.8569 18.2409 25.9306 18.0155C26.0043 17.7901 26.1235 17.5822 26.2809 17.4048C26.4382 17.2274 26.6304 17.0842 26.8454 16.9841C27.0604 16.884 27.2937 16.8292 27.5307 16.8231C28.1538 16.7538 28.7769 16.7308 29.423 16.7308C32.5154 16.7308 35.423 17.3538 37.6384 18.6231C39.9 19.9154 41.5384 22.0154 41.5384 24.8077C41.5384 26.4231 40.8923 27.8077 39.7384 28.7538C38.6307 29.6538 37.2 30 35.7692 30H28.8461C28.3871 30 27.9469 29.8177 27.6223 29.4931C27.2977 29.1685 27.1153 28.7283 27.1153 28.2692C27.1153 27.8102 27.2977 27.37 27.6223 27.0454C27.9469 26.7208 28.3871 26.5385 28.8461 26.5385H35.7692C36.6692 26.5385 37.2461 26.3077 37.5692 26.0538C37.8461 25.8231 38.0769 25.4769 38.0769 24.8077C38.0769 23.5615 37.4077 22.5 35.9077 21.6231C33.9016 20.6062 31.6707 20.1139 29.423 20.1923Z' />
		</svg>
	);
};
