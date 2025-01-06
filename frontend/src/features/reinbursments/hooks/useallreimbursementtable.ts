import { axiosInstance } from "@/lib/axios-config";
import { useQuery, UseQueryResult } from "@tanstack/react-query";

export function useAllReimbursementTable(): UseQueryResult<any[]> {
    return useQuery({
        queryKey: ["all-reimbursements"],
        queryFn: async () => {
            try {
                const resp = await axiosInstance.get('/reimbursements', { headers: { Authorization: localStorage.getItem('token') } });
                return resp.data;
            } catch (e) {
                console.error
            };
        }
    });
}