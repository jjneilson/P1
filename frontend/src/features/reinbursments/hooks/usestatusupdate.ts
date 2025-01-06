import { useMutation, useQueryClient } from "@tanstack/react-query";
import { axiosInstance } from "@/lib/axios-config";
import { toast } from "sonner";

interface UpdateStatusProps {
    reimbursmentid: number;
    newStatus: string;
  }

export function useStatusUpdate() {
  const queryClient = useQueryClient();

  return useMutation({
    mutationFn: async ({ reimbursmentid, newStatus }: UpdateStatusProps) => {
        const resp = await axiosInstance.patch(`/reimbursements/resolve/${reimbursmentid}`, {
            status: newStatus,
          },
        {
            headers: {
                Authorization: localStorage.getItem("token"),
            },
        });
          return resp.data;
    },
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ["all-reimbursements"] });
      toast.success("Reimbursement status updated successfully.");
    },
    onError: (e) => {
      console.error(e);
      toast.error("Failed to update reimbursement status.");
    },
  });
}