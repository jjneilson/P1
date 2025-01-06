import {Table,
    TableBody,
    TableCaption,
    TableHead,
    TableHeader,
    TableRow, } from "@/components/ui/table";

export function AllReinbursmentTable() {
    return (
        <Table>
        <TableCaption>A list of all reimbursements.</TableCaption>
      <TableHeader>
        <TableRow>
          <TableHead className="w-[200px]">Reimbursement ID</TableHead>
          <TableHead>Status</TableHead>
          <TableHead>Description</TableHead>
          <TableHead>User</TableHead>
          <TableHead>Amount</TableHead>
        </TableRow>
      </TableHeader>
      <TableBody>

        </TableBody>
        </Table>
    );
}