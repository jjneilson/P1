import { axiosInstance } from "@/lib/axios-config";
import { useQuery } from "@tanstack/react-query";
import { reimbursementListSchema } from "../schemas/reinbursmentList-schema";

export function useReinbursmentTable() {
  return useQuery({
    queryKey: ["user-reimbursements"], 
    queryFn: async () => {
      const response = await axiosInstance.get("/reimbursements/me",{
        headers: {
          "Authorization": localStorage.getItem("token"),
        },
      });
      
      const data = reimbursementListSchema.parse(response.data);

      return data;
    },
  });
}