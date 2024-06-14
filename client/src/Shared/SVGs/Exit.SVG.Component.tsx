import { ISVGComponentProps } from './interface/interface';

export const ExitSVGComponent: React.FC<ISVGComponentProps> = ({
	fillColor,
	height,
	width,
	className
}) => {
	return (
		<svg
			fill="none" 
            height={height}
            width={width}
            viewBox="0 0 28 28" 
            xmlns="http://www.w3.org/2000/svg"
			className={className}
		>
			<path clip-rule="evenodd" d="M15 2a1 1 0 1 0-2 0v11a1 1 0 1 0 2 0zM9.83 4.9A1 1 0 1 0 9 3.1a12 12 0 1 0 10 0 1 1 0 0 0-.83 1.8 10 10 0 1 1-8.34 0z" fill='#6C33FF' fill-rule="evenodd"></path>
		</svg>
	);
};
