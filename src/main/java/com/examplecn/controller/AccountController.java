package com.examplecn.controller;


import com.examplecn.entity.Account;
import com.examplecn.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Aaron
 * @since 2019-07-26
 */
@RestController
@RequestMapping(value = "/api/v1/accounts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(tags = "账号相关接口")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    @ApiOperation(value = "新增账号")
    public Account put(@RequestBody  Account account) {

        accountService.saveOrUpdate(account);
        return account;
    }
}

