import { z } from "zod";

export const registerFormSchema = z.object({
  username: z
    .string({
      message: "Please enter a valid email address.",
    })
    .min(1, "Please enter a valid email address.")
    .max(50),
  firstName: z
    .string({
      message: "Please enter your first name.",
    })
    .min(1, "Please enter your first name.")
    .max(50),
  lastName: z
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