package com.why.plant.common.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * 分页参数
 */
@Data
public class PageQuery implements Serializable {
    /**
     * 页码
     */
    @TableField(exist = false)
    private Integer page;

    /**
     * 每页数量
     */
    @TableField(exist = false)
    private Integer size;
}
