package com.examplecn.service.impl;

import com.examplecn.entity.Account;
import com.examplecn.entity.Credential;
import com.examplecn.mapper.AccountMapper;
import com.examplecn.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.examplecn.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Aaron
 * @since 2019-07-26
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Autowired
    private CredentialService credentialService;

    @Override
    public Account register(String username, String password) {

        Credential credential = credentialService.findByUsername(username);
        if (null != credential) return null;
        Account account = new Account();
        account.setName(username);
        save(account);
        credentialService.add(username, password, account.getId());
        return account;
    }
}
