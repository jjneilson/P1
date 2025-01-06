import { Table, TableCaption, TableHeader, TableRow, TableHead, TableBody, TableCell } from "@/components/ui/table";
import { useUserTable } from "../hooks/useusertable";
import { userRoleUpdate } from "../hooks/userroleupdate";
import { RoleSelect } from "./role";




export function UserTable() {
    const { data, error } = useUserTable();
    const updateRole = userRoleUpdate();

    if (!data || data.length === 0) {
        return <div>No users found.</div>;
    }
    if (error) return <div>Error loading users</div>;

    return (<Table>
        <TableCaption>A list of all users.</TableCaption>
        <TableHeader>
            <TableRow>
                <TableHead className="w-[200px]">User ID</TableHead>
                <TableHead>Username</TableHead>
                <TableHead>First Name</TableHead>
                <TableHead>Last Name</TableHead>
                <TableHead>Role</TableHead>
            </TableRow>
        </TableHeader>
        <TableBody>
            {data.map((user) => (
                <TableRow key={user.userid}>
                    <TableCell>
                        {user.userid}
                    </TableCell>
                    <TableCell>
                        {user.username}
                    </TableCell>
                    <TableCell>
                        {user.firstname}
                    </TableCell>
                    <TableCell>
                        {user.lastname}
                    </TableCell>
                    <TableCell>
                        <RoleSelect initialRole={user.role} onChange={(newRole: any) =>
                  updateRole.mutate({
                    userid: user.userid, 
                    newRole,
                  })}/>
                    </TableCell>

                </TableRow>
            ))}
        </TableBody>

    </Table>);
}