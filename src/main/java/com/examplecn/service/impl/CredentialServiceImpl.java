package com.examplecn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.examplecn.entity.Credential;
import com.examplecn.mapper.CredentialMapper;
import com.examplecn.service.CredentialService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.credential.DefaultPasswordService;
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
public class CredentialServiceImpl extends ServiceImpl<CredentialMapper, Credential> implements CredentialService {

    @Autowired
    private DefaultPasswordService defaultPasswordService;

    @Override
    public Credential findByUsername(String username) {

        QueryWrapper<Credential> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Credential.USERNAME, username);
        return getOne(queryWrapper);
    }

    @Override
    public String login(String username, String password) {

        Credential credential = findByUsername(username);
        if (null == credential) return null;
        String credentialPassword = credential.getPassword();

        if (defaultPasswordService.passwordsMatch(password, credentialPassword)) {

            Long accountId = credential.getAccountId();
            return String.valueOf(accountId);
        }
        return null;
    }

    @Override
    public boolean add(String username, String password, Long accountId) {
        Credential credential = new Credential();
        credential.setUsername(username);
        credential.setActived(true);
        credential.setAccountId(accountId);
        credential.setPassword(defaultPasswordService.encryptPassword(password));
        return save(credential);
    }
}
