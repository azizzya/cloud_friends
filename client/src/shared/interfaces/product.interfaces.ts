// export interface IProduct {
// 	id: number;
// 	name: string;
// 	description: string;
// 	price: number;
// 	category: string;
// }

export interface IProduct {
	id: number;
	image: string;
	title: string;
	price: number;
	description: string;
	category: string;
}

export interface IProductResponse {
	data: IProduct[];
}