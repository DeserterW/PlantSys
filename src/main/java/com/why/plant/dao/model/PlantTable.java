package com.why.plant.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.why.plant.common.model.PageQuery;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("PlantTable")
public class PlantTable extends PageQuery implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 外貌
     */
    private String appearance;


    /**
     * 价格
     */
    private Double  price;

    /**
     * 品种
     */
    private String varity;

    /**
     * 名字
     */
    private String name;
}
