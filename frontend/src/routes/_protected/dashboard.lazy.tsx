import { Button } from '@/components/ui/button'
import { AllReimbursementTable } from '@/features/reinbursments/components/all-reinbursment-table'
import { CreateReimbursmentDialog } from '@/features/reinbursments/components/create-reimbursment-dialog'
import { ReinbursmentTable } from '@/features/reinbursments/components/reinbursment-table'
import { createLazyFileRoute } from '@tanstack/react-router'
import { Plus } from 'lucide-react'
import { useState } from 'react'

export const Route = createLazyFileRoute('/_protected/dashboard')({
  component: RouteComponent,
})

function RouteComponent() {
  return (
    <div>
      <DashboardHeader></DashboardHeader>
      <ReinbursmentTable></ReinbursmentTable>
      <AllReimbursementTable></AllReimbursementTable>
    </div>
  )
}

function DashboardHeader() {
  const [open, setOpen] = useState(false)

  return (
    <>
      <div className="flex flex-col gap-y-5">
        <h1 className="text-2xl font-bold">Employee Dashboard</h1>
        <Button className="w-fit" onClick={() => setOpen(true)}>
          <Plus />
          Create Reimbursment
        </Button>
      </div>

      <CreateReimbursmentDialog open={open} setOpen={setOpen} />
    </>
  )
}
