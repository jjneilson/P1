import { Home, LucideIcon, Shield } from "lucide-react";

interface SidebarItem {
  label: string;
  href: string;
  icon: LucideIcon;
}

interface SidebarGroup {
  label: string;
  items: SidebarItem[];
}

export const sidebarItems: SidebarGroup[] = [
  {
    label: "Applications",
    items: [
      {
        label: "Employee Dashboard",
        href: "/Dashboard",
        icon: Home,
      },
    ],
  },
  {
    label: "Manager Dashboard",
    items: [
      {
        label: "Profile",
        href: "/profile",
        icon: Shield,
      },
    ],
  },
];