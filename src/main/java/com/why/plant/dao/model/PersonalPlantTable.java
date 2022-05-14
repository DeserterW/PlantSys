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
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * user_id
     */
    private Long userId;

    /**
     * plant_id
     */
    private Long plantId;

    /**
     * 
     */
    private Date date;

    /**
     * 
     */
    private Integer plantNums;

    /**
     * 生长期
     */
    private Integer growPeriod;

    /**
     * 健康状态
     */
    private Integer growStatus;
}