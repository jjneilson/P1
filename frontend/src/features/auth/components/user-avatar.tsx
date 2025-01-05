import { Avatar, AvatarFallback } from "@/components/ui/avatar";
import { useAuth } from "../hooks/use-auth";

export function UserAvatar() {
  const { data: auth } = useAuth();

  if (!auth) return null;

  return (
    <Avatar>
      <AvatarFallback>
        {auth.firstname.charAt(0).toUpperCase() +
          auth.lastname.charAt(0).toUpperCase()}
      </AvatarFallback>
    </Avatar>
  );
}