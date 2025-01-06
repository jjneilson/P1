import { useMutation, useQueryClient } from "@tanstack/react-query";
import { axiosInstance } from "@/lib/axios-config";
import { toast } from "sonner";

interface UpdateDescriptionProps {  
    reimbursmentid: number;  
    newDescription: string;
    }

export function useDescriptionDialog(){
    const queryClient = useQueryClient();

    return useMutation({
        mutationFn: async ({ reimbursmentid, newDescription }: UpdateDescriptionProps) => {
            const resp = await axiosInstance.patch(`/reimbursements/update/${reimbursmentid}`, {
              description: newDescription,
              },{
                headers: {
                    "Authorization": localStorage.getItem("token"),
                    },
              });
              console.log(reimbursmentid, newDescription);
              return resp.data;
        },
        onSuccess: () => {
          queryClient.invalidateQueries({ queryKey: ["auth"] });
          toast.success("Reimbursement description updated successfully.");
        },
        onError: (error) => {
          console.error(error);
          toast.error("Failed to update description.");
        },
      });
}