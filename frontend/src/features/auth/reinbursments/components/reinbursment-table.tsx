import { Table,TableCaption, TableHeader, TableRow, TableHead, TableBody } from "@/components/ui/table";


export function ReinbursmentTable() {

return (
    <Table>
      <TableCaption>A list of your reimbursements.</TableCaption>
      <TableHeader>
        <TableRow>
          <TableHead className="w-[200px]">Reimbursement ID</TableHead>
          <TableHead>Status</TableHead>
          <TableHead>Description</TableHead>
          <TableHead>Update Description</TableHead>
          <TableHead>User</TableHead>
          <TableHead className="text-right">Amount</TableHead>
        </TableRow>
      </TableHeader>
      <TableBody></TableBody>

      </Table>
    );
}