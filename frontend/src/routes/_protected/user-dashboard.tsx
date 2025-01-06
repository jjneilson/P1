import { UserTable } from '@/features/user/components/user-table'
import { createFileRoute } from '@tanstack/react-router'

export const Route = createFileRoute('/_protected/user-dashboard')({
  component: RouteComponent,
})

function RouteComponent() {
  return <div>
    <h1 className="text-2xl font-bold">User Dashboard</h1>
    <UserTable />
  </div>
}
