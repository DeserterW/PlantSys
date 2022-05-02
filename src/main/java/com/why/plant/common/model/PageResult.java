package com.why.plant.common.model;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 统一分页结果
 * @author why
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    /**
     * 总数
     */
    private Long total;

    /**
     * 数据行
     */
    private List<T> rows;

    /**
     * 封装pageInfo的分页结果
     *
     * @param pageInfo
     */
    public PageResult(PageInfo<T> pageInfo) {
        this.total = pageInfo.getTotal();
        this.rows = pageInfo.getList();
    }

    /**
     * 封装list的分页结果
     *
     * @param list
     */
    public PageResult(List<T> list) {
        this.rows = list;
        this.total = CollectionUtils.isEmpty(list) ? 0L : list.size();
    }
}
