
package com.examplecn.controller;

import com.examplecn.entity.Account;
import com.examplecn.model.LoginBody;
import com.examplecn.model.Result;
import com.examplecn.service.AccountService;
import com.examplecn.service.CredentialService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description: 认证相关接口,不需要认证数据就可访问
 * @author: Aaron
 * @date: 2019/9/29 11:01
 */
@RestController
@RequestMapping(value = "/api/v1/unauth", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AuthController {

    @Autowired
    private CredentialService credentialService;

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/register")
    public Mono<Result> register(@RequestBody LoginBody body) {

        Account account = accountService.register(body.getUsername(), body.getPassword());
        if (null != account) return Mono.just(new Result("200", "注册成功").add(account));
        return Mono.just(new Result("300", "注册失败！"));
    }

    @PostMapping(value = "/login")
    public Mono<Result> login(@RequestBody LoginBody loginBody, ServerWebExchange exchange) {

        String accountId = credentialService.login(loginBody.getUsername(), loginBody.getPassword());
        if (StringUtils.isNotBlank(accountId)) {

            MultiValueMap<String, ResponseCookie> cookies = exchange.getResponse().getCookies();
            ResponseCookie basicCookie = ResponseCookie.from("E_TOKEN", accountId).path("/").domain("localhost:8080").build();
            cookies.add("E_TOKEN", basicCookie);
            return Mono.just(Result.succeed(accountId));
        }

        return Mono.just(Result.error("401", "登录失败"));
    }
}
