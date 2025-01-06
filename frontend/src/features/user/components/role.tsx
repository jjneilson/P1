import {
    Select,
    SelectContent,
    SelectItem,
    SelectTrigger,
    SelectValue,
  } from "@/components/ui/select";

  interface RoleSelectProps {
    initialRole: string; 
    onChange?: (value: string) => void; 
  }
  
  export function RoleSelect({ initialRole, onChange }: RoleSelectProps) {
    return (
      <Select
        defaultValue={initialRole}
        onValueChange={(value: string) => {
          if (onChange) onChange(value);
        }}
      >
        <SelectTrigger className="w-full bg-black text-gray-100 rounded-lg border border-gray-600">
          <SelectValue placeholder="Select status" />
        </SelectTrigger>
        <SelectContent className="bg-black text-gray-100">
          <SelectItem value="manager">Manager</SelectItem>
          <SelectItem value="employee">Employee</SelectItem>
        </SelectContent>
      </Select>
    );
  }
  