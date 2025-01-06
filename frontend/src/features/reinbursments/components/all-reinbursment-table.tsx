import {
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";
import { useAllReimbursementTable } from "../hooks/useallreimbursementtable.ts";
import { useStatusUpdate } from "../hooks/usestatusupdate.ts";
import StatusSelect from "./status";
import { useDeleteReimbursement } from "../hooks/usedeletereimbursement.ts";

export function AllReimbursementTable() {
  const { data, error, isLoading } = useAllReimbursementTable();
  const updateStatusMutation = useStatusUpdate();
  const deleteReimbursementMutation = useDeleteReimbursement();

  if (isLoading) return <div>Loading...</div>;
  if (error) return <div>Error loading reimbursements</div>;
  if (!data || data.length === 0) {
    return <div>No reimbursements found.</div>;
  }

  const handleDelete = (reimbId: number) => {
    if (window.confirm("Are you sure you want to delete this reimbursement?")) {
      deleteReimbursementMutation.mutate(reimbId);
    }
  };

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
        {data.map((reimbursement) => (
          <TableRow key={reimbursement.reimbId}>
            <TableCell className="font-medium">
              {reimbursement.reimbId}
            </TableCell>
            <TableCell>
              <StatusSelect
                initialStatus={reimbursement.status}
                onChange={(newStatus) =>
                  updateStatusMutation.mutate({
                    reimbId: reimbursement.reimbId, 
                    newStatus,
                  })
                }
              />
            </TableCell>
            <TableCell>{reimbursement.description}</TableCell>
            <TableCell>{reimbursement.user.username}</TableCell>
            <TableCell>${reimbursement.amount}</TableCell>
            <TableCell className="text-right">
              <button
                onClick={() => handleDelete(reimbursement.reimbId)}
                className="px-3 py-1 bg-red-500 text-white rounded hover:bg-red-600"
                disabled={isLoading}
              >
                {isLoading ? "Deleting..." : "Delete"}
              </button>
            </TableCell>
          </TableRow>
        ))}
      </TableBody>
    </Table>
  );
}

