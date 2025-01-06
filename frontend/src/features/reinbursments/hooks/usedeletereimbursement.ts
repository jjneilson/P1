import { axiosInstance } from "@/lib/axios-config";
import { useMutation } from "@tanstack/react-query";
import { toast } from "sonner";

export function useDeleteReimbursement() {
    return useMutation({
        mutationFn: async (reimbId: number) => {
            const resp = await axiosInstance.delete(`/reimbursements/delete/${reimbId}`, { headers: { Authorization: localStorage.getItem('token') } });
            return resp.data;
        },
        onSuccess: () => {
            window.location.reload();
            toast.success('Reimbursement deleted successfully');
        },
        onError: () => {
            toast.error('Failed to delete reimbursement');
        },
    });
}