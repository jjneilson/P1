import { axiosInstance } from "@/lib/axios-config";
import { useMutation } from "@tanstack/react-query";
import { toast } from "sonner";

export function useDeleteUser() {
    return useMutation({
        mutationFn: async (userid: number) => {
            const resp = await axiosInstance.delete(`/users/delete/${userid}`, { headers: { Authorization: localStorage.getItem('token') } });
            return resp.data;
        },
        onSuccess: () => {
            window.location.reload();
            toast.success('User deleted successfully');
        },
        onError: () => {
            toast.error('Failed to delete User');
        },
    });
}