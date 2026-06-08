import {createContext, useContext, useState} from "react";

const AuthContext = createContext();

export function AuthProvider({children}) {
    const [token, setToken] = useState(localStorage.getItem("token"));

    const login = (jwt) => {
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

export const useAuth = () => useContext(AuthContext);