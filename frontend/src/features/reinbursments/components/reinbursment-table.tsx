import { Table,TableCaption, TableHeader, TableRow, TableHead, TableBody, TableCell } from "@/components/ui/table";

import { useReinbursmentTable } from "../hooks/useReinbursmentTable";
import { DescriptionDialog } from "./description-dialog.tsx";


export function ReinbursmentTable() {

  const {data, error} = useReinbursmentTable();

  console.log(error);
  if (error) return <div>Error loading reimbursements</div>;

  if (!data || data.length === 0) {
    return <div>No reimbursements found.</div>;
  }

return (
    <Table>
      <TableCaption>A list of your reimbursements.</TableCaption>
      <TableHeader>
        <TableRow>
          <TableHead className="w-[200px]">Reimbursement ID</TableHead>
          <TableHead>Status</TableHead>
          <TableHead>Description</TableHead>
          <TableHead>Update Description</TableHead>
          <TableHead>User ID</TableHead>
          <TableHead className="text-right">Amount</TableHead>
        </TableRow>
      </TableHeader>
      <TableBody>
        {data.map((reimbursement) => (
          <TableRow key={reimbursement.reimbursmentid}>
            <TableCell className="font-medium">
              {reimbursement.reimbursmentid}
            </TableCell>
            <TableCell>{reimbursement.status}</TableCell>
            <TableCell>{reimbursement.description}</TableCell>
            <TableCell>
              <DescriptionDialog
                reimbursementId={reimbursement.reimbursmentid}
                currentDescription={reimbursement.description ?? ""}
              />
            </TableCell>
            <TableCell>{reimbursement.userid}</TableCell>
            <TableCell className="text-right">
              ${reimbursement.amount}
            </TableCell>
          </TableRow>
        ))}
      </TableBody>

      </Table>
    );
}