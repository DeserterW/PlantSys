package com.why.plant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.why.plant.dao.mapper.EnvironmentalchangeTableMapper;
import com.why.plant.dao.model.EnvironmentalchangeTable;
import com.why.plant.dao.model.UserTable;
import com.why.plant.service.EnvironmentalchangeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* @author Administrator
* @description 针对表【EnvironmentalChangeTable】的数据库操作Service实现
* @createDate 2022-05-04 23:03:27
*/
@Service
public class EnvironmentalchangeTableServiceImpl extends ServiceImpl<EnvironmentalchangeTableMapper, EnvironmentalchangeTable>
    implements EnvironmentalchangeTableService {

    @Autowired
    private EnvironmentalchangeTableMapper environmentalchangeTableMapper;

    @Override
    public List<EnvironmentalchangeTable> showRecentTemperature(List<Long> envs_id) {

        List<EnvironmentalchangeTable> result =  environmentalchangeTableMapper.selectList(new LambdaQueryWrapper<EnvironmentalchangeTable>()
                .in(EnvironmentalchangeTable::getEnvId,envs_id));

        return result;
    }
}




