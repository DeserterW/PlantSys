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
 * @TableName PersonalPlantTable
 */
@TableName(value ="PersonalPlantTable")
@Data
public class PersonalPlantTable extends PageQuery implements Serializable {
    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private Long plantId;

    /**
     * 
     */
    private Date date;

    /**
     * 
     */
    private String plantNums;

    /**
     * 
     */
    private Integer growPeriod;
}