package seapps.abstraction.auth.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    @Value("${token.actiontime}")
    private int actionTime;

    @Value("${token.secretkey}")
    private String secretKey;

    public String createToken(String username){
        Date now = new Date();
        Date expiration = new Date(now.getTime() + this.actionTime);

        return Jwts.builder()
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, this.secretKey)
                .compact();
    }
}