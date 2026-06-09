import {createContext, type ReactNode, useContext, useState} from "react";

interface AuthContextType {
    token: string | null;
    login: (jwt: string) => void;
    logout: () => void;
    isAuth: boolean;
}

const AuthContext = createContext<AuthContextType | null>(null);

export function AuthProvider({children}: { children: ReactNode }) {
    const [token, setToken] = useState(localStorage.getItem("token"));

    const login = (jwt: string) => {
        localStorage.setItem("token", jwt);
        setToken(jwt);
    };

    const logout = () => {
        localStorage.removeItem("token");
        setToken(null);
    };
    return (
        <AuthContext.Provider value={{token, login, logout, isAuth: !!token}}>
            {children}
        </AuthContext.Provider>
    );
}

export const useAuth = () => {
    const ctx = useContext(AuthContext);
    if (!ctx) throw new Error("useAuth must be used within AuthProvider");
    return ctx;
};