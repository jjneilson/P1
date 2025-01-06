import {
    Dialog,
    DialogContent,
    DialogDescription,
    DialogHeader,
    DialogTitle,
} from "@/components/ui/dialog";
import { z } from "zod";
import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";
import {
    Form,
    FormControl,
    FormDescription,
    FormField,
    FormItem,
    FormLabel,
    FormMessage,
} from "@/components/ui/form";
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";
import { useCreateReimbursement } from "../hooks/usecreateReimbursment";

export const formSchema = z.object({
    description: z
        .string({
            message: "Name is required",
        })
        .min(1, "Name is required"),
    amount: z.coerce.number().gte(1, "Amount must be greater than 0"),
});

interface CreateStudySetDialogProps {
    open: boolean;
    setOpen: (value: boolean) => void;
}

export function CreateReimbursmentDialog({
    open,
    setOpen,
}: CreateStudySetDialogProps) {
    const { mutate } = useCreateReimbursement();

    const form = useForm<z.infer<typeof formSchema>>({
        resolver: zodResolver(formSchema),
        defaultValues: {
            description: "",
            amount: 0,
        },
    });

    function onSubmit(values: z.infer<typeof formSchema>) {
        mutate(values, {
            onSuccess: () => {
                form.reset();
                setOpen(false);
            },
        });
    }

    return (
        <Dialog
            open={open}
            onOpenChange={() => {
                form.reset();
                setOpen(false);
            }}
        >
            <DialogContent>
                <DialogHeader>
                    <DialogTitle>Create a new reimbursment</DialogTitle>
                </DialogHeader>

                <Form {...form}>
                    <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-8">
                        <FormField
                            control={form.control}
                            name="description"
                            render={({ field }) => (
                                <FormItem>
                                    <FormLabel>Description</FormLabel>
                                    <FormControl>
                                        <Input placeholder="Description" {...field} />
                                    </FormControl>
                                    <FormMessage />
                                </FormItem>
                            )}
                        />
                        <FormField
                            control={form.control}
                            name="amount"
                            render={({ field }) => (
                                <FormItem>
                                    <FormLabel>Description</FormLabel>
                                    <FormControl>
                                        <Input placeholder="0" {...field} />
                                    </FormControl>
                                    <FormMessage />
                                </FormItem>
                            )}
                        />
                        <Button type="submit" className="bg-green-500 hover:bg-green-600">Submit</Button>
                    </form>
                </Form>
            </DialogContent>
        </Dialog>
    );
}