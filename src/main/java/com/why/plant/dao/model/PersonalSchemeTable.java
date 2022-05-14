package com.why.plant.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.why.plant.common.model.PageQuery;
import lombok.Data;

/**
 * 
 * @TableName PersonalSchemeTable
 */
@TableName(value ="PersonalSchemeTable")
@Data
public class PersonalSchemeTable extends PageQuery implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * user_id
     */
    private Long userId;

    /**
     * scheme_id
     */
    private Long schemeId;

    /**
     * 日期
     */
    private Date date;

    /**
     * 执行时间
     */
    private Date exceuteTime;

    /**
     * 环境Id
     */
    private Long envId;

}