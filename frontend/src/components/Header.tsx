import {Button} from "@/components/ui/button.tsx";
import {Link} from "react-router-dom";

import Logo from "@/assets/Logo.png";

export default function Header() {
    return (
        <header className="sticky top-0 z-50 bg-background">
            <nav className="flex items-center">
                <div className="flex lg:flex-2"><Link to={"/"}><img alt="Booking system" src={Logo}/></Link></div>
                {/* mobile */}
                <div className="flex lg:hidden"></div>

                <div className="flex lg:flex-1 p-6 lg:px-8 justify-end">
                    <Button asChild className="cursor-pointer">
                        <Link to={"/login"}>Expert Login</Link>
                    </Button>
                </div>
            </nav>
        </header>
    )
}