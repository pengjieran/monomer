package com.examplecn.filter;

import cn.hutool.core.collection.CollectionUtil;
import com.examplecn.constant.TokenConstant;
import com.examplecn.utils.TokenUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Component
public class TokenFilter implements WebFilter, Ordered {

    private static final Pattern UNAUTHPATTERN = Pattern.compile("/api/v1/unauth/*");

    private static final Logger logger = LoggerFactory.getLogger(TokenFilter.class);

    @Override public int getOrder() {
        return -100;
    }

    @Override public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        ServerHttpResponse response = exchange.getResponse();
        ServerHttpRequest serverHttpRequest = exchange.getRequest();
        String uri = serverHttpRequest.getPath().value();
        logger.info("访问链接：" + uri);

        //路由所有/unauth/路径下的请求，不经过token验证
        if (UNAUTHPATTERN.matcher(uri).find()) {

            return chain.filter(exchange);
        }

        List<String> tokenHeaders = serverHttpRequest.getHeaders().get(TokenConstant.TOKEN_HEADER);
        if (CollectionUtil.isNotEmpty(tokenHeaders)) {

            String token = tokenHeaders.get(0);
            if (StringUtils.isNotBlank(token)) {

                token = TokenUtils.getTokenStr(token);
                if (StringUtils.isNotBlank(token)) {

                    TokenUtils.AccessToken accessToken = TokenUtils.parseAccessTokenString(token);
                    if (null != accessToken) {

                        ServerHttpRequest newServerHttpRequest = serverHttpRequest.mutate().header(TokenConstant.PAYLOAD_ACCOUNT_ID, accessToken.getAccountId()).header(TokenConstant.PAYLOAD_CREDENTIAL_ID, accessToken.getUsername()).build();
                        return chain.filter(exchange.mutate().request(newServerHttpRequest).response(response).build());
                    }
                }
            }
        }

        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }
}
