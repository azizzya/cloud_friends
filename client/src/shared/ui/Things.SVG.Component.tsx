import { ISVGComponentProps } from '../interfaces/SVGComponent.interfaces';

export const ThingsSVGComponent: React.FC<ISVGComponentProps> = ({
	fillColor,
}) => {
	return (
		<svg
			width='30'
			height='30'
			viewBox='0 0 30 30'
			fill='none'
			xmlns='http://www.w3.org/2000/svg'
		>
			<path
				fill-rule='evenodd'
				clip-rule='evenodd'
				d='M17.7293 11.2897C17.2207 10.7993 16.7847 10.3633 16.4578 9.96367C16.0836 9.55836 15.7935 9.08297 15.604 8.56494C15.3336 7.7388 15.3336 6.84794 15.604 6.0218C15.7857 5.47684 16.0945 5.04087 16.4396 4.62307C16.7847 4.22343 17.257 3.75114 17.7657 3.24251L18.2198 2.80654L18.6558 2.35241C19.1644 1.84378 19.6367 1.37148 20.0363 1.02634C20.4541 0.681199 20.8901 0.372389 21.4351 0.190736C22.2707 -0.0635786 23.1426 -0.0635786 23.9782 0.190736C24.5232 0.372389 24.9591 0.681199 25.3769 1.02634C25.7766 1.37148 26.2125 1.80745 26.7212 2.29791L27.1935 2.80654L27.6839 3.27884C28.1926 3.78747 28.6285 4.22343 28.9555 4.62307C29.3188 5.04087 29.6276 5.47684 29.8093 6.0218C30.0636 6.8574 30.0636 7.72934 29.8093 8.56494C29.6276 9.1099 29.3188 9.54587 28.9737 9.96367C28.6285 10.3633 28.1562 10.8356 27.6476 11.3442L27.1935 11.7802L26.7575 12.2343C26.2489 12.743 25.7766 13.2153 25.3769 13.5604C24.9591 13.9055 24.5232 14.2144 23.9782 14.396C23.1426 14.6503 22.2707 14.6503 21.4351 14.396C20.9185 14.212 20.4432 13.928 20.0363 13.5604C19.5723 13.1537 19.1239 12.7296 18.6921 12.2888L18.2198 11.7802L17.7293 11.3079V11.2897ZM25.7221 9.41871L25.2679 9.85468L24.832 10.3088C24.287 10.8538 23.9237 11.2171 23.6149 11.4714C23.4739 11.6109 23.3074 11.7219 23.1244 11.7984C22.8528 11.8859 22.5605 11.8859 22.2888 11.7984C22.1061 11.7215 21.9396 11.6105 21.7984 11.4714C21.5077 11.2171 21.1444 10.8719 20.5813 10.3088L20.1453 9.85468L19.6912 9.41871C19.1462 8.87375 18.7829 8.51044 18.5286 8.20163C18.3891 8.06066 18.2781 7.89414 18.2016 7.71117C18.1141 7.43951 18.1141 7.14723 18.2016 6.87557C18.2781 6.6926 18.3891 6.52608 18.5286 6.3851C18.7829 6.09446 19.1281 5.73115 19.6912 5.16803L20.1453 4.73206L20.5813 4.27793C21.1262 3.73297 21.4896 3.36966 21.7984 3.11535C21.9396 2.97622 22.1061 2.86526 22.2888 2.78837C22.5605 2.70085 22.8528 2.70085 23.1244 2.78837C23.1971 2.80654 23.3243 2.8792 23.6149 3.11535C23.9055 3.36966 24.2688 3.7148 24.832 4.27793L25.2679 4.73206L25.7221 5.16803C26.267 5.71299 26.6303 6.07629 26.8846 6.3851C27.1208 6.67575 27.1935 6.80291 27.2116 6.87557C27.3025 7.14805 27.3025 7.43869 27.2116 7.71117C27.1347 7.89393 27.0238 8.06038 26.8846 8.20163C26.6303 8.49228 26.2852 8.85559 25.7221 9.41871ZM16.3488 22.9519C16.3488 22.2253 16.3488 21.6076 16.3851 21.099C16.4396 20.554 16.5304 20.0272 16.8029 19.5186C17.1844 18.7557 17.8202 18.1199 18.5831 17.7384C19.0917 17.4659 19.6367 17.3751 20.1635 17.3206C20.6721 17.2843 21.3442 17.2843 22.0708 17.2843H23.3424C24.069 17.2843 24.7411 17.2843 25.2498 17.3206C25.7947 17.3751 26.3215 17.4659 26.8302 17.7384C27.5931 18.1199 28.2289 18.7557 28.6104 19.5186C28.8828 20.0272 28.9737 20.5722 29.0282 21.099C29.0645 21.6076 29.0645 22.2434 29.0645 22.9519V24.3324C29.0645 25.059 29.0645 25.6767 29.0282 26.1853C28.9868 26.8886 28.7644 27.5693 28.3825 28.1613C28.0005 28.7533 27.4721 29.2365 26.8483 29.564C26.3034 29.8183 25.7766 29.9273 25.2498 29.9637C24.7411 30 24.069 30 23.3424 30H22.0708C21.3442 30 20.6721 30 20.1635 29.9637C19.6185 29.9092 19.0917 29.8183 18.5831 29.5459C17.8172 29.1546 17.1942 28.5316 16.8029 27.7657C16.5609 27.2715 16.419 26.7345 16.3851 26.1853C16.3488 25.6767 16.3488 25.0409 16.3488 24.3324V23.6421V22.9519ZM23.3424 27.2752H22.0708C21.2897 27.2752 20.7811 27.2752 20.3996 27.2389C20.2007 27.2399 20.0034 27.2029 19.8183 27.1299C19.5599 26.9989 19.3499 26.7889 19.2189 26.5304C19.1459 26.3454 19.1089 26.1481 19.1099 25.9491C19.0736 25.5858 19.0736 25.059 19.0736 24.2779V23.0064C19.0736 22.2253 19.0736 21.7166 19.1099 21.3351C19.1281 20.9718 19.1826 20.8265 19.2189 20.7539C19.3499 20.4954 19.5599 20.2854 19.8183 20.1544C20.0033 20.081 20.2007 20.044 20.3996 20.0454C20.7629 20.0091 21.2897 20.0091 22.0708 20.0091H23.3424C24.1235 20.0091 24.6322 20.0091 25.0136 20.0454C25.3769 20.0636 25.5223 20.1181 25.5949 20.1544C25.8492 20.2816 26.0672 20.4995 26.1944 20.7539C26.2307 20.8265 26.2852 20.9537 26.3034 21.3351C26.3397 21.6985 26.3397 22.2253 26.3397 23.0064V24.2779C26.3397 25.059 26.3397 25.5677 26.3034 25.9491C26.3044 26.1481 26.2674 26.3454 26.1944 26.5304C26.0634 26.7889 25.8534 26.9989 25.5949 27.1299C25.4099 27.2029 25.2126 27.2399 25.0136 27.2389C24.6503 27.2752 24.1235 27.2752 23.3424 27.2752ZM0 6.60309V7.98365C0 8.71026 -3.38355e-08 9.32788 0.0363306 9.83651C0.0776667 10.5398 0.300093 11.2205 0.682028 11.8125C1.06396 12.4045 1.59244 12.8877 2.21617 13.2153C2.76113 13.4696 3.28792 13.5786 3.81471 13.6149C4.32334 13.6512 4.99546 13.6512 5.72207 13.6512H6.99364C7.72025 13.6512 8.39237 13.6512 8.901 13.6149C9.6043 13.5736 10.285 13.3511 10.877 12.9692C11.469 12.5873 11.9522 12.0588 12.2797 11.4351C12.5341 10.8901 12.6431 10.3633 12.6794 9.83651C12.7157 9.32788 12.7157 8.6921 12.7157 7.98365V6.60309C12.7157 5.87648 12.7157 5.25886 12.6794 4.75023C12.6455 4.20106 12.5036 3.66399 12.2616 3.16985C11.8703 2.40392 11.2473 1.78095 10.4814 1.38965C9.98724 1.14768 9.45016 1.00569 8.901 0.971844C8.39237 0.935513 7.72025 0.935513 6.99364 0.935513H5.72207C4.99546 0.935513 4.32334 0.935513 3.81471 0.971844C3.11142 1.01318 2.43074 1.23561 1.83875 1.61754C1.24675 1.99948 0.763525 2.52795 0.435967 3.15168C0.181653 3.69664 0.0726612 4.22343 0.0363306 4.75023C-3.38355e-08 5.25886 0 5.89464 0 6.60309ZM6.35786 10.9264H6.99364C7.77475 10.9264 8.28338 10.9264 8.66485 10.8901C9.02816 10.8719 9.17348 10.8174 9.24614 10.7811C9.50462 10.6501 9.71461 10.4401 9.8456 10.1817C9.91904 9.99672 9.95605 9.79934 9.95459 9.60036C9.99092 9.23706 9.99092 8.71026 9.99092 7.92915V6.65758C9.99092 5.87648 9.99092 5.36785 9.95459 4.98638C9.95605 4.7874 9.91904 4.59002 9.8456 4.40509C9.71461 4.1466 9.50462 3.93661 9.24614 3.80563C9.06108 3.73262 8.86379 3.69563 8.66485 3.69664C8.30154 3.66031 7.77475 3.66031 6.99364 3.66031H5.72207C4.94096 3.66031 4.43233 3.66031 4.05086 3.69664C3.85193 3.69563 3.65463 3.73262 3.46957 3.80563C3.21109 3.93661 3.0011 4.1466 2.87012 4.40509C2.79667 4.59002 2.75966 4.7874 2.76113 4.98638C2.7248 5.34968 2.7248 5.87648 2.7248 6.65758V7.92915C2.7248 8.71026 2.7248 9.21889 2.76113 9.60036C2.77929 9.96367 2.83379 10.109 2.87012 10.1817C2.99728 10.436 3.21526 10.654 3.46957 10.7811C3.54223 10.8174 3.66939 10.8719 4.05086 10.8901C4.41417 10.9264 4.94096 10.9264 5.72207 10.9264H6.35786ZM0 22.9519C0 22.2253 -3.38355e-08 21.6076 0.0363306 21.099C0.0908265 20.554 0.181653 20.0272 0.454133 19.5186C0.835604 18.7557 1.47139 18.1199 2.23433 17.7384C2.74296 17.4659 3.28792 17.3751 3.81471 17.3206C4.32334 17.2843 4.99546 17.2843 5.72207 17.2843H6.99364C7.72025 17.2843 8.39237 17.2843 8.901 17.3206C9.44596 17.3751 9.97275 17.4659 10.4814 17.7384C11.2443 18.1199 11.8801 18.7557 12.2616 19.5186C12.5341 20.0272 12.6249 20.5722 12.6794 21.099C12.7157 21.6076 12.7157 22.2434 12.7157 22.9519V24.3324C12.7157 25.059 12.7157 25.6767 12.6794 26.1853C12.638 26.8886 12.4156 27.5693 12.0337 28.1613C11.6518 28.7533 11.1233 29.2365 10.4995 29.564C9.95459 29.8183 9.42779 29.9273 8.901 29.9637C8.39237 30 7.72025 30 6.99364 30H5.72207C4.99546 30 4.32334 30 3.81471 29.9637C3.11142 29.9223 2.43074 29.6999 1.83875 29.318C1.24675 28.936 0.763525 28.4076 0.435967 27.7838C0.197961 27.2828 0.0621067 26.7394 0.0363306 26.1853C-3.38355e-08 25.6767 0 25.0409 0 24.3324V23.6421V22.9519ZM6.99364 27.2752H5.72207C4.94096 27.2752 4.43233 27.2752 4.05086 27.2389C3.85193 27.2399 3.65463 27.2029 3.46957 27.1299C3.21109 26.9989 3.0011 26.7889 2.87012 26.5304C2.79667 26.3455 2.75966 26.1481 2.76113 25.9491C2.7248 25.5858 2.7248 25.059 2.7248 24.2779V23.0064C2.7248 22.2253 2.7248 21.7166 2.76113 21.3351C2.77929 20.9718 2.83379 20.8265 2.87012 20.7539C3.0011 20.4954 3.21109 20.2854 3.46957 20.1544C3.6545 20.081 3.85189 20.044 4.05086 20.0454C4.41417 20.0091 4.94096 20.0091 5.72207 20.0091H6.99364C7.77475 20.0091 8.28338 20.0091 8.66485 20.0454C9.02816 20.0636 9.17348 20.1181 9.24614 20.1544C9.50045 20.2816 9.71844 20.4995 9.8456 20.7539C9.88193 20.8265 9.93642 20.9537 9.95459 21.3351C9.99092 21.6985 9.99092 22.2253 9.99092 23.0064V24.2779C9.99092 25.059 9.99092 25.5677 9.95459 25.9491C9.95605 26.1481 9.91904 26.3455 9.8456 26.5304C9.71461 26.7889 9.50462 26.9989 9.24614 27.1299C9.06108 27.2029 8.86379 27.2399 8.66485 27.2389C8.30154 27.2752 7.77475 27.2752 6.99364 27.2752Z'
				fill={fillColor}
			/>
		</svg>
	);
};
