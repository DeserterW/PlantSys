package com.why.plant.service;

import com.github.pagehelper.PageInfo;
import com.why.plant.dao.model.EnvironmentalchangeTable;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author Administrator
* @description 针对表【EnvironmentalChangeTable】的数据库操作Service
* @createDate 2022-05-04 23:03:27
*/
public interface EnvironmentalchangeTableService extends IService<EnvironmentalchangeTable> {

    public List<EnvironmentalchangeTable> showRecentTemperature(List<Long> envs_id);
}
