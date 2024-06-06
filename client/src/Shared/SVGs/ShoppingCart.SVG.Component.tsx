import { ISVGComponentProps } from './interface';

export const ShoppingCartSVGComponent: React.FC<ISVGComponentProps> = ({
	fillColor,
	height,
	width,
	className
}) => {
	return (
		<svg
			fill={fillColor}
			width={width}
			height={height}
			viewBox='0 0 33 30'
			xmlns='http://www.w3.org/2000/svg'
			className={className}
		>
			<path
				fillRule='evenodd'
				clipRule='evenodd'
				d='M1.76727 2.72727C2.43818 2.72727 2.86636 2.72727 3.195 2.75318C3.50591 2.77636 3.62864 2.81591 3.69409 2.84455C3.92732 2.94841 4.1267 3.11567 4.26955 3.32727C4.31045 3.38727 4.37045 3.50045 4.44682 3.80318C4.52864 4.12227 4.605 4.54364 4.72091 5.20364L6.83455 17.1355C6.94091 17.7368 7.03364 18.2605 7.14409 18.69C7.26136 19.1495 7.41955 19.5955 7.70318 20.0168C8.13209 20.6518 8.73073 21.1536 9.43091 21.465C9.89455 21.6709 10.3623 21.75 10.8341 21.7855C11.2773 21.8182 11.8091 21.8182 12.4186 21.8182H19.7086C22.2041 21.8182 23.8309 21.8195 25.2573 21.2686C26.5138 20.783 27.6309 19.9947 28.5095 18.9736C29.5077 17.8145 30.0532 16.2805 30.8877 13.9309L31.8014 11.3673C32.115 10.4809 32.3823 9.73364 32.5432 9.11182C32.7095 8.46818 32.8091 7.79864 32.6577 7.11C32.4375 6.10768 31.8485 5.22477 31.0077 4.63636C30.4309 4.23136 29.775 4.065 29.1177 3.97091C28.4823 3.88091 27.6873 3.83864 26.7505 3.78818L6.97773 2.73545C6.87339 2.40457 6.72281 2.0901 6.53045 1.80136C6.10135 1.16685 5.50273 0.665557 4.80273 0.354545C4.35761 0.16564 3.88254 0.0571427 3.39955 0.034091C2.95636 1.29539e-07 2.42455 0 1.815 0H1.36364C1.00198 0 0.655131 0.143668 0.3994 0.3994C0.143668 0.655131 0 1.00198 0 1.36364C0 1.7253 0.143668 2.07214 0.3994 2.32787C0.655131 2.5836 1.00198 2.72727 1.36364 2.72727H1.76727ZM9.51273 16.6145L7.54227 5.49545L26.5432 6.50727C27.5577 6.56182 28.2286 6.59864 28.7291 6.67091C29.2214 6.73909 29.3809 6.825 29.4423 6.86864C29.7225 7.06496 29.9186 7.35944 29.9918 7.69364C30.0082 7.76727 30.0259 7.94591 29.9005 8.42727C29.775 8.91818 29.55 9.55091 29.2091 10.5082L28.4141 12.7445C27.4459 15.4636 27.0641 16.4686 26.4409 17.1927C25.8551 17.8734 25.1104 18.399 24.2727 18.7227C23.3809 19.0677 22.3064 19.0895 19.4209 19.0895H12.465C11.7941 19.0895 11.3659 19.0895 11.0373 19.0636C10.7264 19.0405 10.6036 19.0009 10.5382 18.9723C10.305 18.8684 10.1056 18.7012 9.96273 18.4895C9.92182 18.4295 9.86182 18.3164 9.78545 18.0136C9.67839 17.5499 9.58652 17.0829 9.51 16.6132L9.51273 16.6145ZM7.5 27.2727C7.5 26.5494 7.78734 25.8557 8.2988 25.3443C8.81026 24.8328 9.50395 24.5455 10.2273 24.5455C10.9506 24.5455 11.6443 24.8328 12.1557 25.3443C12.6672 25.8557 12.9545 26.5494 12.9545 27.2727C12.9545 27.996 12.6672 28.6897 12.1557 29.2012C11.6443 29.7127 10.9506 30 10.2273 30C9.50395 30 8.81026 29.7127 8.2988 29.2012C7.78734 28.6897 7.5 27.996 7.5 27.2727ZM21.1364 27.2727C21.1364 26.5494 21.4237 25.8557 21.9352 25.3443C22.4466 24.8328 23.1403 24.5455 23.8636 24.5455C24.587 24.5455 25.2806 24.8328 25.7921 25.3443C26.3036 25.8557 26.5909 26.5494 26.5909 27.2727C26.5909 27.996 26.3036 28.6897 25.7921 29.2012C25.2806 29.7127 24.587 30 23.8636 30C23.1403 30 22.4466 29.7127 21.9352 29.2012C21.4237 28.6897 21.1364 27.996 21.1364 27.2727Z'
				fill='#6C33FF'
			/>
		</svg>
	);
};
