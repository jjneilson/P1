import { axiosInstance } from "@/lib/axios-config";
import { UseQueryResult, useQuery } from "@tanstack/react-query";

export function useUserTable(): UseQueryResult<any[]> {
    return useQuery({
        queryKey: ["all-users"],
        queryFn: async () => {
            try {
                const resp = await axiosInstance.get('/users', { headers: { Authorization: localStorage.getItem('token') } });
                return resp.data;
            } catch (e) {
                console.error(e);
                return null;
            };
        }
    });
}