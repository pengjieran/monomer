package com.examplecn.service;

import com.examplecn.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Aaron
 * @since 2019-07-26
 */
public interface AccountService extends IService<Account> {

    public Account register(String username, String password);
}
