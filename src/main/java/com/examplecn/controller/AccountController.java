package com.examplecn.controller;


import com.examplecn.entity.Account;
import com.examplecn.model.Result;
import com.examplecn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Aaron
 * @since 2019-07-26
 */
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public Mono<Result> query() {

        List<Account> accounts = accountService.list(accountService.query());
        Result result = new Result("200", "操作成功");
        result.setResult(accounts);
        return Mono.just(result);
    }
}

