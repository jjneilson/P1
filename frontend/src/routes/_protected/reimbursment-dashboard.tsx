import { createFileRoute } from '@tanstack/react-router'

export const Route = createFileRoute('/_protected/reimbursment-dashboard')({
  component: RouteComponent,
})

function RouteComponent() {
  return <div>Hello "/_protected/reimbursment-dashboard"!</div>
}
