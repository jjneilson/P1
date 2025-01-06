import {
    Dialog,
    DialogContent,
    DialogHeader,
    DialogFooter,
    DialogTitle,
    DialogTrigger,
  } from "@/components/ui/dialog";
  import { Input } from "@/components/ui/input";
  import { Button } from "@/components/ui/button";
  import { useState } from "react";
  import { useDescriptionDialog } from "../hooks/usedescriptiondialog.ts";
  
  interface EditDescriptionDialogProps {
    reimbursementId: number;
    currentDescription: string;
  }
  
  export function DescriptionDialog({
    reimbursementId,
    currentDescription = "",
  }: EditDescriptionDialogProps) {
    const [description, setDescription] = useState(currentDescription || "");
    const [, setIsDialogOpen] = useState(false);
    const updateDescription = useDescriptionDialog();
  
    const handleSave = () => {
      updateDescription.mutate(
        {
        reimbursmentid: reimbursementId,
        newDescription: description,
        },
        {
          onSuccess: () => {
            setIsDialogOpen(false);
            window.location.reload();
          },
          onError: (error) => {
            console.error("Failed to update reimbursement description:", error);
          }
        });
    };
  
    return (
      <Dialog>
        <DialogTrigger asChild>
          <Button className="bg-black text-white hover:bg-slate">
            Edit Description
          </Button>
        </DialogTrigger>
        <DialogContent>
          <DialogHeader>
            <DialogTitle>Edit Description</DialogTitle>
          </DialogHeader>
          <div className="space-y-4">
            <Input
              value={description}
              onChange={(e) => setDescription(e.target.value)}
              placeholder="Enter new description"
              className="w-full"
            />
          </div>
          <DialogFooter>
            <Button
              onClick={handleSave}
              disabled={updateDescription.status === 'pending'}
              className="bg-green-500 text-white hover:bg-green-600"
            >
              {updateDescription.status === 'pending' ? "Saving..." : "Save"}
            </Button>
          </DialogFooter>
        </DialogContent>
      </Dialog>
    );
  }
  