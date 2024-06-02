package com.booking.security;

import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.lang.NonNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

public class TokenAuthenticationFilter extends OncePerRequestFilter {
    private final TokenUtils tokenUtils;

    private final UserDetailsService userDetailsService;

    public TokenAuthenticationFilter(TokenUtils tokenUtils, UserDetailsService userDetailsService) {
        this.tokenUtils = tokenUtils;
        this.userDetailsService = userDetailsService;
    }

    private void validateTokenAndSetAuthentication(HttpServletRequest request) {
        String authorizationToken = tokenUtils.getToken(request);
        if (authorizationToken == null || authorizationToken.isEmpty())
            return;

        String username = tokenUtils.getUsernameFromToken(authorizationToken);
        if (username == null)
            return;

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (!tokenUtils.validateToken(authorizationToken, userDetails))
            return;

        TokenAuthentication tokenBasedAuthentication = new TokenAuthentication(userDetails);
        tokenBasedAuthentication.setToken(authorizationToken);
        SecurityContextHolder.getContext().setAuthentication(tokenBasedAuthentication);
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        try {
            validateTokenAndSetAuthentication(request);
        } catch (ExpiredJwtException ex) {
            System.out.println("TOKEN EXPIRED");
        }

        filterChain.doFilter(request, response);
    }
}