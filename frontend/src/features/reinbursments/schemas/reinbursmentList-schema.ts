import { z } from "zod";

export const reimbursementListSchema = z.array(
  z.object({
    reimbursmentid: z.number(), 
    description: z.string().nullable(),
    amount: z.number(),
    status: z.string(), 
    userid: z.number(),
  })
);

export type ReimbursementListSchema = z.infer<typeof reimbursementListSchema>;