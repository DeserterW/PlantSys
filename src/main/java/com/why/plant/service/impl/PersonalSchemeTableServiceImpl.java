package com.why.plant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.why.plant.dao.mapper.PersonalSchemeTableMapper;
import com.why.plant.dao.model.PersonalPlantTable;
import com.why.plant.dao.model.PersonalSchemeTable;
import com.why.plant.service.PersonalSchemeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author Administrator
* @description 针对表【PersonalSchemeTable】的数据库操作Service实现
* @createDate 2022-05-02 21:12:16
*/
@Service
public class PersonalSchemeTableServiceImpl extends ServiceImpl<PersonalSchemeTableMapper, PersonalSchemeTable>
    implements PersonalSchemeTableService {

    @Autowired
    private PersonalSchemeTableMapper personalSchemeTableMapper;

    @Override
    public List<PersonalSchemeTable> selectAllPersonalTable(Long userId) {

        List<PersonalSchemeTable> personalSchemeTables = personalSchemeTableMapper.selectList(new LambdaQueryWrapper<PersonalSchemeTable>()
                .eq(PersonalSchemeTable::getUserId,userId));

        return personalSchemeTables;
    }

    @Override
    public Long selectSchemeId(Long personalSchemeId) {
        PersonalSchemeTable personalSchemeTable = personalSchemeTableMapper.selectOne(new LambdaQueryWrapper<PersonalSchemeTable>()
                .eq(PersonalSchemeTable::getId,personalSchemeId));
        if(personalSchemeTable != null)
        {
            return personalSchemeTable.getSchemeId();
        }

        return null;
    }

    @Override
    public boolean addPersonalScheme(Long userId, Long schemeId) {

        PersonalSchemeTable personalSchemeTable = new PersonalSchemeTable();

        personalSchemeTable.setSchemeId(schemeId);
        personalSchemeTable.setUserId(userId);
        personalSchemeTable.setDate(new Date());

        Integer ret = personalSchemeTableMapper.insert(personalSchemeTable);
        if(ret == 1)
        {
            return true;
        }

        return false;
    }

}




