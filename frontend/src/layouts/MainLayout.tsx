import Header from "@/components/Header.tsx";
import {Outlet} from "react-router-dom";

const MainLayout = () => {
    return (
        <div className="bg-background">
            <Header/>
            <main className="isolate">
                <Outlet/>
            </main>
        </div>
    )
}
export default MainLayout;