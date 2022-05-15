package com.why.plant.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.why.plant.common.model.PageQuery;
import lombok.Data;

/**
 * 
 * @TableName ThirdSysTable
 */
@TableName(value ="ThirdSysTable")
@Data
public class ThirdSysTable extends PageQuery implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 第三方系统名称
     */
    private String systemName;

    /**
     * 访问地址
     */
    private String systemAddr;

    /**
     * 获取token地址
     */
    private String accessTokenadd;
}