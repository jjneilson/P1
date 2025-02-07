import { z } from "zod";

export const registerFormSchema = z.object({
  username: z
    .string({
      message: "Please enter a valid username.",
    })
    .min(1, "Please enter a valid username.")
    .max(50),
  firstname: z
    .string({
      message: "Please enter your first name.",
    })
    .min(1, "Please enter your first name.")
    .max(50),
  lastname: z
    .string({
      message: "Please enter your last name.",
    })
    .min(1, "Please enter your last name.")
    .max(50),
  password: z
    .string({
      message: "Please enter a valid password.",
    })
    .min(8, "Password must be at least 8 characters long.")
    .max(50),
  confirmPassword: z
    .string({
      message: "Please confirm your password.",
    })
    .min(1, "Please confirm your password."),
});

export type RegisterSchema = z.infer<typeof registerFormSchema>;