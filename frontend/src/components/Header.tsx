import {Button} from "@/components/ui/button.tsx";
import {Link} from "react-router-dom";

export default function Header() {
    return (
        <header className="sticky top-0 z-50 bg-background">
            <nav className="flex items-center p-6 lg:px-8">
                <div className="flex lg:flex-2"><Link to={"/"}> LOGO</Link></div>
                {/* mobile */}
                <div className="flex lg:hidden"></div>

                <div className="flex lg:flex-1 justify-end">
                    <Button asChild className="cursor-pointer">
                        <Link to={"/login"}>Expert Login</Link>
                    </Button>
                </div>
            </nav>
        </header>
    )
}