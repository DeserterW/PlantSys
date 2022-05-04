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
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * user_id
     */
    private Long userId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 日期
     */
    private Date date;

    /**
     * 赞数
     */
    private Integer likesNums;

}