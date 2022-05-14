package com.why.plant.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.why.plant.common.model.PageQuery;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("SchemeTable")
public class SchemeTable extends PageQuery  implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 植物编号
     */
    private Long plantId;

    /**
     * 温度
     */
    private Double  temperature;

    /**
     * 光照时间
     */
    private Integer lightTime;

    /**
     * 湿度
     */
    private Integer moisture;

    /**
     * 肥料
     */
    private String fertilizer;

    /**
     * 生长期
     */
    private Integer growPeriod;

    /**
     * 赞数目
     */
    private Integer likesNums;

    /**
     * 方案名称
     */
    private String schemeName;

    /**
     * 是否上传
     */
    private Boolean isUpload;

    /**
     * 是否通过
     */
    private Boolean passed;

    /**
     * userId
     */
    private Long userId;
}
