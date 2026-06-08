import * as React from "react";
import {Card, CardHeader, CardTitle, CardDescription, CardAction, CardContent, CardFooter} from "@/components/ui/card";
import {Button} from "@/components/ui/button";
import {Link} from "react-router-dom";
import {useState} from "react";
import {Input} from "@/components/ui/input";
import {useMutation} from "@tanstack/react-query";
import {useAuth} from "@/context/AuthContext.tsx";

interface LoginProps {

}

const Login: React.FC<LoginProps> = () => {
    const {isAuth} = useAuth();
    const [email, setEmail] = useState<string>("");
    const [password, setPassword] = useState<string>("");
    const {mutate, isPending, isError, error} = useMutation({
        mutationFn: async () => {

        }
    })
    const handleSubmit = async (): Promise<void> => {

    }
    return (
        <section className="container mt-16 mx-auto flex justify-center">
            <Card className="w-full max-w-md">
                <CardHeader>
                    <CardTitle>Expert login</CardTitle>
                    <CardDescription>Manage client bookings and set availability.</CardDescription>
                    <CardAction>
                        <Button className="cursor-not-allowed dark:text-white"
                                title="feature not available yet"
                                asChild
                                variant="link">
                            <Link to={"#"}>Sign Up </Link>
                        </Button>
                    </CardAction>
                </CardHeader>
                <CardContent>
                    <div className="flex flex-col gap-6">
                        <div className="grid gap-1">
                            <label htmlFor="email">Email</label>
                            <Input type="email" aria-label="email" name="email" placeholder="email@example.com" required
                            />
                        </div>
                        <div className="grid gap-1">
                            <label htmlFor="password">Password</label>
                            <Input type="password" placeholder="********" aria-label="password" name="password" required
                            />
                        </div>
                    </div>
                </CardContent>
                <CardFooter>
                    <Button disabled={isPending} className="w-full" onClick={handleSubmit}>Login</Button>
                </CardFooter>
            </Card>
        </section>
    )
}

export default Login;