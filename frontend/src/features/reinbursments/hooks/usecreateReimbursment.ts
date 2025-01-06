import { useMutation, useQueryClient } from "@tanstack/react-query";
import { formSchema } from "../components/create-reimbursment-dialog";
import { z } from "zod";
import { axiosInstance } from "@/lib/axios-config";
import { toast } from "sonner";

export function useCreateReimbursement() {
    const queryClient = useQueryClient();

    return useMutation({
        mutationFn: async (values: z.infer<typeof formSchema>) => {
            console.log(values);
            const resp = await axiosInstance.post("/reimbursements/create", {
                amount: values.amount,
                description: values.description,
            }, {
                headers: {
                    "Authorization": localStorage.getItem("token"),
                },
            });
            return resp.data;
        },
        onSuccess: () => {
            queryClient.invalidateQueries();
        },
        onError: () => {
            toast.error("Failed to create reimbursement");
        },
    });
}