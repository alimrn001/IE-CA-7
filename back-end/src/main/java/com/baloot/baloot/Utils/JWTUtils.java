package com.baloot.baloot.Utils;

import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

public class JWTUtils {

    public static String signKey = "baloot2023";

    public static String createJWTToken(String userEmail) {
//        String signKey = "baloot2023";
        SecretKey signatureType = new SecretKeySpec(signKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        String jwtToken = Jwts.builder().
                claim("userEmail", userEmail).
                setId(UUID.randomUUID().toString()).
                setIssuer("BalootService").
                setIssuedAt(Date.from(Instant.now().plus(24, ChronoUnit.HOURS))).
                signWith(signatureType).
                compact();
        return jwtToken;
    }

}
