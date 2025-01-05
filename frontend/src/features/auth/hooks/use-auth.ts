import { axiosInstance } from "@/lib/axios-config";
import { useQuery, UseQueryResult } from "@tanstack/react-query";
import { useRouter } from "@tanstack/react-router";

export function useAuth(): UseQueryResult<{ userid:number, username:string, password:string, firstname:string, lastname:string, role:string } | null> {
  const router = useRouter();

  return useQuery({
    queryKey: ["auth"],
    queryFn: async () => {
      try {
        const resp = await axiosInstance.get("/auth/me", {
          headers: {
            Authorization: localStorage.getItem("token")
          }
        });
        return resp.data;
      } catch (e) {
        console.error(e);
        router.navigate({ to: "/auth/login" });
        return null;
      }
    },
    staleTime: 1000 * 60 * 5, // 5 mins
    gcTime: 1000 * 60 * 10, // 10 mins
    refetchOnWindowFocus: false,
    refetchOnReconnect: false,
  });
}