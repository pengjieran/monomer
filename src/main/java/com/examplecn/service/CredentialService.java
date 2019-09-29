package com.examplecn.service;

import com.examplecn.entity.Credential;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Aaron
 * @since 2019-07-26
 */
public interface CredentialService extends IService<Credential> {

    Credential findByUsername(String username);

    String login(String username, String password);

    boolean add(String username, String password, Long accountId);
}
