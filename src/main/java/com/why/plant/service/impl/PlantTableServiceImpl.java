package com.why.plant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.why.plant.dao.mapper.PlantTableMapper;
import com.why.plant.dao.model.PlantTable;
import com.why.plant.service.PlantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantTableServiceImpl extends ServiceImpl<PlantTableMapper, PlantTable> implements PlantTableService {


}
