import { Card, CardDescription, CardHeader } from "@/components/ui/card";

interface ReinbursmentProps {
    description: string;
    amount: number;
    status: string;
}


export function Reinbursment({ description, amount, status }: ReinbursmentProps) {
    return (
        <Card className="w-full">
            <CardHeader className="flex flex-row">
                <CardDescription className="p-2 justify-start">
                    {description}
                </CardDescription>
                <CardDescription className="p-2">
                    ${amount}
                </CardDescription>
                <CardDescription className="p-2">
                    {status}
                </CardDescription>

            </CardHeader>
        </Card>
    );
}