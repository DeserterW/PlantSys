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

import java.util.ArrayList;
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

    @Override
    public List<Long> selectEnv(Long user_id) {
        List<EnvTable> list_env = envTableMapper.selectList(new LambdaQueryWrapper<EnvTable>().select(EnvTable::getId).eq(EnvTable::getUserId,user_id));

        List<Long> result = new ArrayList<>();
        for(int i =0 ;i < list_env.size() ;i++)
        {
            result.add(list_env.get(i).getId());
        }

        return result;
    }

    @Override
    public List<EnvTable> selectEnvDetail(Long userId) {

        List<EnvTable> envTables = envTableMapper.selectList(new LambdaQueryWrapper<EnvTable>().eq(EnvTable::getUserId,userId));

        if(envTables != null)
        {
            return envTables;
        }

        return null;
    }

    @Override
    public Boolean inserEnv(EnvTable envTable) {

        Integer res = envTableMapper.insert(envTable);

        return res == 1 ? true : false;

    }

    @Override
    public Boolean removeEnv(EnvTable envTable) {


        Integer res = envTableMapper.deleteById(envTable.getId());

        return res == 1 ? true : false;
    }

    @Override
    public EnvTable selectEnvById(Long envId) {

        EnvTable envTable = envTableMapper.selectById(envId);

        return envTable;
    }

    @Override
    public Boolean setAlert(Long envId, Double threshold, Integer type) {
        EnvTable envTable = new EnvTable();
        if(type == 0)
        {

            envTable.setId(envId);
            envTable.setTempAlert(threshold);
        }else
        {
            envTable.setId(envId);
            envTable.setHumidityAlert(threshold);;
        }
        int res = envTableMapper.updateById(envTable);

        if(res == 1)
            return true;
        else
            return false;
    }
}
