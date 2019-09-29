package com.examplecn.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Aaron
 * @since 2019-07-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_credential")
public class Credential implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @TableField("account_id")
    private Long accountId;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("actived")
    private Boolean actived;

    public static final String ID = "id";

    public static final String ACCOUNT_ID = "account_id";

    public static final String USERNAME = "username";

    public static final String PASSWORD = "password";

    public static final String ACTIVED = "actived";

}
