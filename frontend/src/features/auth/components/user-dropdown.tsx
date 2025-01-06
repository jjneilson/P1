import {
    DropdownMenu,
    DropdownMenuContent,
    DropdownMenuItem,
    DropdownMenuLabel,
    DropdownMenuSeparator,
    DropdownMenuTrigger,
  } from "@/components/ui/dropdown-menu";
  import { useLogout } from "../hooks/use-logout.ts";
  import { UserAvatar } from "./user-avatar.tsx";
import { useRouter } from "@tanstack/react-router";
import { useAuth } from "../hooks/use-auth.ts";



  

  

  export function UserDropdown() {
    const { mutate: logout } = useLogout()
    const { data } = useAuth();
    const router = useRouter();

    function dashboardNavigate() {
      router.navigate({ to: "/dashboard" });
    }

    function reimbursmentNavigate() {
      router.navigate({ to: "/reimbursment-dashboard" });
    }
  
    function userNavigate() { 
      router.navigate({ to: "/user-dashboard" });
    }

    return (
      <DropdownMenu>
        <DropdownMenuTrigger>
          <UserAvatar />
        </DropdownMenuTrigger>
        <DropdownMenuContent>
          <DropdownMenuLabel>My Account</DropdownMenuLabel>
          <DropdownMenuSeparator />
          <DropdownMenuItem onClick={() => dashboardNavigate()}>Employee Dashboard</DropdownMenuItem>
          {data?.role === 'manager' && (
            <><DropdownMenuItem onClick={() => userNavigate()}>User Dashboard</DropdownMenuItem><DropdownMenuItem onClick={() => reimbursmentNavigate()}>All Reimbursements Dashboard</DropdownMenuItem></>
          )}
          <DropdownMenuSeparator />
          <DropdownMenuItem onClick={() => logout()}>Log out</DropdownMenuItem>
        </DropdownMenuContent>
      </DropdownMenu>
    );
  }