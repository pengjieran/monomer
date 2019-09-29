package com.examplecn.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Description: 登录实体
 * @author: Aaron
 * @date: 2019/9/29 11:12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LoginBody implements Serializable {

    private String username;

    private String password;
}
