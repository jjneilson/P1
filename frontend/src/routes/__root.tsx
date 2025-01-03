import { Toaster } from "@/components/ui/sonner";
import QueryProvider from "@/providers/query-provider.tsx";
import { createRootRoute, Outlet } from "@tanstack/react-router";

export const Route = createRootRoute({
  component: () => (
    <QueryProvider>
      <div>
        <Outlet />
        <Toaster />
      </div>
    </QueryProvider>
  ),
});