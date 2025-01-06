
import { Navbar } from "@/components/shared/navbar";
import { createFileRoute, Outlet } from "@tanstack/react-router";

export const Route = createFileRoute("/_protected")({
    component: RouteComponent,
});

function RouteComponent() {
    return (
        <div>
            <Navbar />
                    <main className="max-w-screen-2xl mx-auto w-11/12 py-16">
                        <Outlet />
                    </main>
        </div>
    );
}
