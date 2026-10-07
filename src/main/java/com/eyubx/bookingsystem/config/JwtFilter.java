package com.eyubx.bookingsystem.config;

import com.eyubx.bookingsystem.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private JwtUtil jwtUtil;
    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
//        String authHeader = request.getHeader("Authorization");
//        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//            String token = authHeader.substring(7);
//            if (jwtUtil.validateToken(token, user)) {
//                String username = jwtUtil.extractUsername(token);
//                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null);
//                authentication.setDetails(new WebAuthenticationDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }
        filterChain.doFilter(request, response);

    }
}
