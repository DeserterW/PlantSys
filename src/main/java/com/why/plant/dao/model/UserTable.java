package com.why.plant.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.why.plant.common.model.PageQuery;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("UserTable")
public class UserTable extends PageQuery  implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private String name;


    /**
     * 性别
     */
    private Integer gender;

    /**
     * 账户
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 从业年龄
     */
    private Integer employYears;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 角色
     */
    private String identity;

    /**
     * 审核通过
     */
    private Boolean passed;
}
