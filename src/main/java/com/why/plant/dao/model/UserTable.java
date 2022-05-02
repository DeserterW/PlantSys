package com.why.plant.dao.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.why.plant.common.model.PageQuery;
import lombok.Data;

@Data
@TableName("AdminTable")
public class UserTable extends PageQuery {
    /**
     * id
     */
    @TableId()
    private Long id;

    /**
     * 名称
     */
    private String name;


    /**
     * 性别
     */
    private Integer  gender;

    /**
     * 账户
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     *
     */
    private Integer employYears;

    /**
     * 邮箱
     */
    private String email;
}
