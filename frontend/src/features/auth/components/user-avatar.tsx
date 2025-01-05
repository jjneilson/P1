import { Avatar, AvatarFallback } from "@/components/ui/avatar";
import { useAuth } from "../hooks/use-auth";

export function UserAvatar() {
  const { data: auth } = useAuth();

  console.log(auth);

  if (!auth) return null;

  return (
    <Avatar>
      <AvatarFallback>
        {auth.email.charAt(0).toUpperCase() +
          auth.email.charAt(1).toUpperCase()}
      </AvatarFallback>
    </Avatar>
  );
}