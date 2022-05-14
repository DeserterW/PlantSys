package com.why.plant.service;

import com.why.plant.dao.model.PersonalPlantTable;
import com.baomidou.mybatisplus.extension.service.IService;
import com.why.plant.dao.model.PlantTable;

import java.util.List;

/**
* @author Administrator
* @description 针对表【PersonalPlantTable】的数据库操作Service
* @createDate 2022-05-02 21:10:10
*/
public interface PersonalPlantTableService extends IService<PersonalPlantTable> {

    List<PersonalPlantTable> selectPersonalPlantInfo(Long user_id);

    Boolean addPersonalPlant(PersonalPlantTable personalPlantTable);

    Boolean editPersonalPlant(PersonalPlantTable personalPlantTable);

    Boolean removePersonalPlant(PersonalPlantTable personalPlantTable);
}
