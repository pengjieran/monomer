
package com.examplecn.filter;

import cn.hutool.core.collection.CollectionUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.regex.Pattern;

/**
 * @Description: 校验认证信息
 * @author: Aaron
 * @date: 2019/9/29 10:54
 */
@Component
public class AuthFilter implements WebFilter, Ordered {

    private static final Pattern UNAUTHPATTERN = Pattern.compile("/api/v1/unauth/*");

    private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    public int getOrder() {
        return -99;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {

        ServerHttpRequest request = serverWebExchange.getRequest();
        ServerHttpResponse response = serverWebExchange.getResponse();
        String uri = request.getPath().value();
        logger.info("访问链接：" + uri);

        //路由所有/unauth/路径下的请求，不经过授权
        if (UNAUTHPATTERN.matcher(uri).find()) {

            return webFilterChain.filter(serverWebExchange);
        }

        MultiValueMap<String, HttpCookie> cookies = request.getCookies();
        if (CollectionUtil.isNotEmpty(cookies)) {

            HttpCookie cookie = cookies.getFirst("E_TOKEN");
            if (null != cookie) {

                String value = cookie.getValue();
                if (StringUtils.isNotBlank(value)) {

                    //现在只是存在即可，没有做任何校验
                    return webFilterChain.filter(serverWebExchange);
                }
            }
        }
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }
}
