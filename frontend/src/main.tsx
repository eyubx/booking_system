import {StrictMode} from "react"
import {createRoot} from "react-dom/client"
import "./index.css"
import {ThemeProvider} from "@/components/theme-provider.tsx"
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Index from "@/pages/Index";
import MainLayout from "@/layouts/MainLayout.tsx";
import SearchList from "@/pages/SearchList.tsx";
import {QueryClient, QueryClientProvider} from "@tanstack/react-query";
import Booking from "@/pages/Booking.tsx";
import Login from "@/pages/Login.tsx";
import BookAppointment from "@/pages/BookAppointment";
import {AuthProvider} from "@/context/AuthContext.tsx";
import PrivateRoute from "@/components/PrivateRoute.tsx";

const queryClient = new QueryClient();
createRoot(document.getElementById("root")!).render(
    <StrictMode>
        <ThemeProvider>
            <AuthProvider>
                <QueryClientProvider client={queryClient}>
                    <BrowserRouter>
                        <Routes>
                            <Route element={<MainLayout/>}>
                                <Route path="/dashboard" element={<PrivateRoute>
                                    <div>Hello</div>
                                </PrivateRoute>}/>
                                <Route path="/book/:expertId" element={<BookAppointment/>}/>
                                <Route path="/booking/:id" element={<Booking/>}/>
                                <Route path="/search" element={<SearchList/>}/>
                                <Route path="/login" element={<Login/>}/>
                                <Route index path="/" element={<Index/>}/>
                            </Route>
                        </Routes>
                    </BrowserRouter>
                </QueryClientProvider>
            </AuthProvider>
        </ThemeProvider>
    </StrictMode>
)
