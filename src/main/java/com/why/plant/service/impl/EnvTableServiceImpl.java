package com.why.plant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.why.plant.dao.mapper.EnvTableMapper;
import com.why.plant.dao.model.EnvTable;
import com.why.plant.dao.model.UserTable;
import com.why.plant.service.EnvTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvTableServiceImpl extends ServiceImpl<EnvTableMapper, EnvTable> implements EnvTableService {


    @Autowired
    private EnvTableMapper envTableMapper;

    @Override
    public PageInfo selectAll(EnvTable envTable) {
        if(envTable.getPage()!=null && envTable.getSize()!=null){
            PageHelper.startPage(envTable.getPage(), envTable.getSize());
        }
        List<EnvTable> envTables = envTableMapper.selectList(new LambdaQueryWrapper<EnvTable>());
        PageInfo<EnvTable> pageInfo =new PageInfo<>(envTables);
        return pageInfo;
    }
}
