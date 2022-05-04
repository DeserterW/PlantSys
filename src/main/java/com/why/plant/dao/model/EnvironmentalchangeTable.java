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
 * @TableName EnvironmentalChangeTable
 */
@TableName(value ="EnvironmentalChangeTable")
@Data
public class EnvironmentalchangeTable extends PageQuery implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Double temperature;

    /**
     * 
     */
    private Double humidity;

    /**
     * 
     */
    private Date recordTime;

    /**
     * 
     */
    private Long envId;
}