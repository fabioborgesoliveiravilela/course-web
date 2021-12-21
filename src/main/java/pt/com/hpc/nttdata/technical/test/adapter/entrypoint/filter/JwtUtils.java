package pt.com.hpc.nttdata.technical.test.adapter.entrypoint.filter;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(String nif) {

        return Jwts.builder()
                .setSubject(nif)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getNifFromJwtToken(String token) throws Exception {
        return validateJwtToken(token).getBody().getSubject();
    }

    private Jws<Claims> validateJwtToken(String authToken) throws Exception {
        try {
            return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
        } catch (SignatureException e) {
            logger.error("Assinatura JWT invalida: {}", e.getMessage());
            throw e;
        } catch (MalformedJwtException e) {
            logger.error("Token JWT invalido: {}", e.getMessage());
            throw e;
        } catch (ExpiredJwtException e) {
            logger.error("Token JWT token expirado: {}", e.getMessage());
            throw e;
        } catch (UnsupportedJwtException e) {
            logger.error("Token JWT nao suportado: {}", e.getMessage());
            throw e;
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims vazio: {}", e.getMessage());
            throw e;
        }
    }
}
