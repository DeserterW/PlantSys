package com.why.plant.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.why.plant.dao.mapper.EnvTableMapper;
import com.why.plant.dao.mapper.UserTableMapper;
import com.why.plant.dao.model.EnvTable;
import com.why.plant.dao.model.UserTable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface EnvTableService extends IService<EnvTable> {


    PageInfo selectAll(EnvTable EnvTable);

    List<Long> selectEnv(Long userId);

    List<EnvTable> selectEnvDetail(Long userId);

    Boolean inserEnv(EnvTable envTable);

    Boolean removeEnv(EnvTable envTable);

    EnvTable selectEnvById(Long envId);

    Boolean setAlert(Long envId, Double threshold, Integer type);
}
