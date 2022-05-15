package com.why.plant.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.why.plant.dao.model.PlantTable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface PlantTableService extends IService<PlantTable> {

    Double selectPrice(Long plantId);

    String selectName(Long plantId);

    List<PlantTable> selectAllName( );

    Boolean addPlant(PlantTable plantTable);

    Boolean removePlant(PlantTable plantTable);
}
