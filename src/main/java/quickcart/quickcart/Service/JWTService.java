package quickcart.quickcart.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

    private SecretKey secretKey;
    private static final String SECRET_KEY =  Base64.getEncoder().encodeToString("your-256-bit-secret-your-256-bit-secret".getBytes());

    public JWTService() {
       
        this.secretKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(SECRET_KEY));
      
        
    }

    public String generateToken(String username) {

        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .claims().add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .and()
                .signWith(secretKey)
                .compact();

    }

    public SecretKey getSecretKey(String secretKey) {
        byte[] decodedKey = Base64.getDecoder().decode(secretKey);
        return Keys.hmacShaKeyFor(decodedKey);
    }
   
    public boolean validateToken(String token, String username) {

        return username.equals(extractUsername(token)) && !isTokenExpired(token);

    }

    public boolean isTokenExpired(String token) {
        return extractClaims(token, Claims::getExpiration).before(new Date());
    }

    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAllClaims(String token) { 
         try {
            return Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(token)
            .getPayload();
        } catch (ExpiredJwtException eje) {
            throw new ExpiredJwtException(null, null, "Token has expired", eje.getCause());
        } catch (JwtException je) {
            throw new JwtException("Invalid JWT token", je);
        }
    }

    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }
}
