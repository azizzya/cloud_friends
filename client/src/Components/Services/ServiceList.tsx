import '../../global.scss';
import { LeaderBoardSVGComponent } from '../../Shared/SVGs/LeaderBoard.SVG.Component';
import { StoreSVGComponent } from '../../Shared/SVGs/Store.SVG.Component';
import { IServiceCardProps } from './interface';
import { ServiceCard } from './ServiceCard';
import './style.scss';

export const ServiceList: React.FC = () => {
	const services: IServiceCardProps[] = [
		{
			id: 1,
			text: 'Маркет',
			label: 'store',
			SVGComponent: StoreSVGComponent,
		},
		{
			id: 2,
			text: 'Лидерборд',
			label: 'leaderboard',
			SVGComponent: LeaderBoardSVGComponent,
		},
	];
	return (
		<div className='service-list-wrapper'>
			{services.map(service => (
				<ServiceCard key={service.id} {...service} />
			))}
		</div>
	);
};
