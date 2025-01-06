import { sidebarItems } from "@/components/constants/sidebar-items";
import { Navbar } from "@/components/shared/navbar";
import { SidebarWrapper, SidebarContent, SidebarGroup, SidebarLabel, SidebarItem, SidebarChildren, SidebarTrigger } from "@/components/shared/sidebar";
import { createFileRoute, Outlet } from "@tanstack/react-router";
import { Sidebar } from "lucide-react";

export const Route = createFileRoute("/_protected")({
    component: RouteComponent,
});

function RouteComponent() {
    return (
        <div>
            <Navbar />
            <SidebarWrapper>
                <Sidebar>
                    <SidebarContent>
                        {sidebarItems.map((group) => (
                            <SidebarGroup key={group.label}>
                                <SidebarLabel>{group.label}</SidebarLabel>
                                {group.items.map((item) => (
                                    <SidebarItem
                                        key={item.label}
                                        label={item.label}
                                        href={item.href}
                                        icon={item.icon}
                                    />
                                ))}
                            </SidebarGroup>
                        ))}
                    </SidebarContent>
                </Sidebar>

                <SidebarChildren>
                    <SidebarTrigger />
                    <main className="max-w-screen-2xl mx-auto w-11/12 py-16">
                        <Outlet />
                    </main>
                </SidebarChildren>
            </SidebarWrapper>
        </div>
    );
}
