package com.examplecn.utils;

import com.examplecn.constant.TokenConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

public class TokenUtils {

    private static final String ACCESS_SECRET = "examplecn.com";

    /**
     * 获取token后半部分内容
     * @param token
     * @return
     */
    public static String getTokenStr(String token) {

        String str = StringUtils.stripStart(token, TokenConstant.TOKEN_PREFIX);
        return StringUtils.trimToEmpty(str);
    }

    /**
     * 生成token
     * @param accountId
     * @param username
     * @return
     */
    public static String signToken(String accountId, String username) {

        return Jwts.builder()
                .setSubject(accountId)
                .setAudience(username)
                .signWith(SignatureAlgorithm.HS256, ACCESS_SECRET.getBytes())
                .compact();
    }

    public static AccessToken parseAccessTokenString(String token) {

        if (StringUtils.isNotBlank(token)) {

            Jws<Claims> claims = Jwts.parser().setSigningKey(ACCESS_SECRET.getBytes()).parseClaimsJws(token);
            if (null != claims) {

                String accountId = claims.getBody().getSubject();
                String username = claims.getBody().getAudience();
                AccessToken accessToken = new AccessToken();
                accessToken.setAccountId(accountId);
                accessToken.setUsername(username);
                return accessToken;
            }
        }

        return null;
    }

    @Data
    public static class AccessToken {

        private String accountId;

        private String username;
    }
}
