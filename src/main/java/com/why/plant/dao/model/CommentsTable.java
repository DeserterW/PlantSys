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
 * @TableName CommentsTable
 */
@TableName(value ="CommentsTable")
@Data
public class CommentsTable extends PageQuery implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private String content;

    /**
     * 
     */
    private Date date;

    /**
     * 
     */
    private Integer likesNums;

}