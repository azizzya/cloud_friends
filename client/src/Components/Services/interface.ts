import { ISVGComponentProps } from "../../Shared/SVGs/interface/interface";

export interface IServiceCardProps {
	id: number;
	text: string;
	label: string;
	SVGComponent: React.FC<ISVGComponentProps>;
}