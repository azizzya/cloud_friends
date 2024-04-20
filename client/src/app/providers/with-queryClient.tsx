import { QueryClient, QueryClientProvider } from '@tanstack/react-query';

const queryClient = new QueryClient({
	defaultOptions: {
		queries: {
			refetchOnWindowFocus: false,
		},
	},
});

export const withQueryClient = (component: () => React.ReactNode) => () =>
	<QueryClientProvider client={queryClient}>{component()}</QueryClientProvider>;
