package com.why.plant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.why.plant.dao.mapper.PlantTableMapper;
import com.why.plant.dao.model.PlantTable;
import com.why.plant.service.PlantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantTableServiceImpl extends ServiceImpl<PlantTableMapper, PlantTable> implements PlantTableService {

    @Autowired
    private PlantTableMapper plantTableMapper;

    @Override
    public Double selectPrice(Long plantId) {

        PlantTable plantTable = plantTableMapper.selectOne(new LambdaQueryWrapper<PlantTable>().select(PlantTable::getPrice)
                .eq(PlantTable::getId, plantId));

        if (plantTable != null) {
            Double price = plantTable.getPrice();
            return price;
        } else {
            return 0.0;
        }
    }

    @Override
    public String selectName(Long plantId) {

        PlantTable plantTable = plantTableMapper.selectOne(new LambdaQueryWrapper<PlantTable>().select(PlantTable::getName)
                .eq(PlantTable::getId,plantId));

        if(plantTable != null)
        {
            return plantTable.getName();
        }

        return null;
    }

    @Override
    public List<PlantTable> selectAllName( ) {

        List<PlantTable> plantTables = plantTableMapper.selectList(new LambdaQueryWrapper<PlantTable>());

        return plantTables;
    }
}
