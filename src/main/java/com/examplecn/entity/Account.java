package com.examplecn.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

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
@TableName("t_account")
public class Account implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("nick_name")
    private String nickName;

    @TableField("gender")
    private String gender;

    @TableField("birthday")
    private Date birthday;


    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String NICK_NAME = "nick_name";

    public static final String GENDER = "gender";

    public static final String BIRTHDAY = "birthday";

}
