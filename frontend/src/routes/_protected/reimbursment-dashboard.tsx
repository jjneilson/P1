import { AllReimbursementTable } from '@/features/reinbursments/components/all-reinbursment-table'
import { createFileRoute } from '@tanstack/react-router'

export const Route = createFileRoute('/_protected/reimbursment-dashboard')({
  component: RouteComponent,
})

function RouteComponent() {
  return <div><AllReimbursementTable /></div>
}
