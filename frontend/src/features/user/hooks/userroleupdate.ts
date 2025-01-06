import { useMutation, useQueryClient } from "@tanstack/react-query";
import { axiosInstance } from "@/lib/axios-config";
import { toast } from "sonner";

interface UpdateRoleProps {
    userid: number;
    newRole: string;
  }

export function userRoleUpdate() {
  const queryClient = useQueryClient();

  return useMutation({
    mutationFn: async ({ userid, newRole }: UpdateRoleProps) => {
        const resp = await axiosInstance.patch(`/users/${userid}/role`, {
            role: newRole,
          },
        {
            headers: {
                Authorization: localStorage.getItem("token"),
            },
        });
          return resp.data;
    },
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ["all-users"] });
      toast.success("User role updated successfully.");
    },
    onError: (e) => {
      console.error(e);
      toast.error("Failed to update user role.");
    },
  });
}