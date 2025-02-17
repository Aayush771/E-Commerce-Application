package quickcart.quickcart.JWTFilters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import quickcart.quickcart.Exception.ExpiredTokenException;
import quickcart.quickcart.Exception.InvalidTokenException;
import quickcart.quickcart.Exception.TokenMissingException;
import quickcart.quickcart.Service.JWTService;
import quickcart.quickcart.Service.UserDetail;

@Component
public class TokenValidationFilter extends OncePerRequestFilter {
    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserDetail userDetails;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            throw new TokenMissingException(
                    "JWT token is missing in the request header Or The token is not a Bearer token");
            // filterChain.doFilter(request, response);
            // return;
        }

        String token = header.substring(7);
        String username = jwtService.extractUsername(token);

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetails.loadUserByUsername(username);
            try {
                // Validate the JWT token
                if (jwtService.validateToken(token, username)) {
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            } catch (ExpiredJwtException eje) {
                throw new ExpiredTokenException("JWT token has expired");
            } catch (MalformedJwtException me) {
                throw new InvalidTokenException("JWT token is malformed");
            }
        }
        filterChain.doFilter(request, response);
    }

}
