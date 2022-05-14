package com.why.plant.controller;
import com.why.plant.common.model.Result;
import com.why.plant.dao.mapper.PlantTableMapper;
import com.why.plant.dao.model.PlantTable;
import com.why.plant.service.PlantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/plant")
@RestController
public class PlantTableController {

    @Autowired
    private PlantTableService plantTableService;

    @PostMapping("/price")
    @CrossOrigin
    public Result selectPrice(@RequestBody Map<String, Long> params)
    {
        Long plantId = params.get("plantId");

        Double price = plantTableService.selectPrice(plantId);
        if(price != 0)
        {
            return Result.ok(price);
        }else
        {
            return Result.error("failed");
        }
    }

    @PostMapping("/name")
    @CrossOrigin
    public Result selectName(@RequestBody Map<String, Long> params)
    {
        Long plantId = params.get("plantId");

        String name = plantTableService.selectName(plantId);

        if(name != null)
        {
            return Result.ok(name);
        }else
        {
            return Result.error("failed");
        }
    }

    @GetMapping("/allName")
    @CrossOrigin
    public Result selectAllName()
    {
        List<PlantTable> plantTables = plantTableService.selectAllName();

        return Result.ok(plantTables);
    }

}
