package com.why.plant.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.why.plant.common.model.PageQuery;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("EnvTable")
public class EnvTable  extends PageQuery implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 温度
     */
    private Double temperature;


    /**
     * 湿度
     */
    private Double  humidity;

    /**
     * 光照强度
     */
    private Integer lightLevel;

    /**
     * 肥力
     */
    private Integer fertilizer;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 环境名字
     */
    private String envName;
}
