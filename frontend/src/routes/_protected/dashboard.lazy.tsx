import { ReinbursmentTable } from '@/features/auth/reinbursments/components/all-reinbursment-table'
import { createLazyFileRoute } from '@tanstack/react-router'

export const Route = createLazyFileRoute('/_protected/dashboard')({
  component: RouteComponent,
})

function RouteComponent() {
  return (
    <div>
      <ReinbursmentTable></ReinbursmentTable>
    </div>
    );
}
