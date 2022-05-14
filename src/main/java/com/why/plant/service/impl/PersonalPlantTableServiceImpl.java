package com.why.plant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.why.plant.dao.mapper.EnvTableMapper;
import com.why.plant.dao.mapper.PersonalPlantTableMapper;
import com.why.plant.dao.model.PersonalPlantTable;
import com.why.plant.dao.model.PlantTable;
import com.why.plant.service.PersonalPlantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author Administrator
* @description 针对表【PersonalPlantTable】的数据库操作Service实现
* @createDate 2022-05-02 21:10:10
*/
@Service
public class PersonalPlantTableServiceImpl extends ServiceImpl<PersonalPlantTableMapper, PersonalPlantTable>
    implements PersonalPlantTableService {

    @Autowired
    private PersonalPlantTableMapper personalPlantTableMapper;
    @Override
    public List<PersonalPlantTable> selectPersonalPlantInfo(Long user_id) {

        List<PersonalPlantTable> personalPlantTables = personalPlantTableMapper.selectList(new LambdaQueryWrapper<PersonalPlantTable>()
                .eq(PersonalPlantTable::getUserId,user_id));

        if(personalPlantTables != null)
        {
            return personalPlantTables;
        }

        return null;
    }

    @Override
    public Boolean addPersonalPlant(PersonalPlantTable personalPlantTable) {

//        Integer res = personalPlantTableMapper.update(personalPlantTable,new LambdaUpdateWrapper<PersonalPlantTable>());
        personalPlantTable.setDate(new Date());
        Integer res = personalPlantTableMapper.insert(personalPlantTable);
        if(res == 1)
        {
            return true;
        }
        return false;
    }

    @Override
    public Boolean editPersonalPlant(PersonalPlantTable personalPlantTable) {

        if(personalPlantTableMapper.updateById(personalPlantTable) == 1)
        {
            return true;
        }
        return false;
    }

    @Override
    public Boolean removePersonalPlant(PersonalPlantTable personalPlantTable) {

        if(personalPlantTableMapper.deleteById(personalPlantTable) == 1)
            return true;

        return null;
    }
}




