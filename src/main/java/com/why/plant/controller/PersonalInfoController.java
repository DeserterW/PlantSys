package com.why.plant.controller;
import com.why.plant.common.model.Result;
import com.why.plant.dao.model.EnvTable;
import com.why.plant.dao.model.PersonalPlantTable;
import com.why.plant.dao.model.PersonalSchemeTable;
import com.why.plant.dao.model.SchemeTable;
import com.why.plant.service.EnvTableService;
import com.why.plant.service.PersonalPlantTableService;
import com.why.plant.service.PersonalSchemeTableService;
import com.why.plant.service.SchemeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/personal")
@RestController
@CrossOrigin
public class PersonalInfoController {

    @Autowired
    private PersonalPlantTableService personalPlantTableService;

    @Autowired
    private PersonalSchemeTableService personalSchemeTableService;

    @Autowired
    private SchemeTableService schemeTableService;

    @Autowired
    private EnvTableService envTableService;

    @PostMapping("/plant")
    public Result selectAllPersonalPlantInfo(@RequestBody Map<String, Long> params)
    {
        Long user_id = params.get("userId");

        List<PersonalPlantTable> personalPlantTables =personalPlantTableService.selectPersonalPlantInfo(user_id);

        if(personalPlantTables != null)
        {
            return Result.ok(personalPlantTables);
        }

        return Result.error("failed");
    }


    @PostMapping("/addPlant")
    public Result addPlant(@RequestBody PersonalPlantTable personalPlantTable)
    {

        if(personalPlantTableService.addPersonalPlant(personalPlantTable))
        {
            return Result.ok();
        }else
        {
            return Result.error("failed");
        }
    }

    @PostMapping("/editInfo")
    public Result editInfo(@RequestBody PersonalPlantTable personalPlantTable)
    {

        if(personalPlantTableService.editPersonalPlant(personalPlantTable))
        {
            return Result.ok();
        }else {
            return Result.error("failed");
        }
    }

    @PostMapping("/removePlant")
    public Result removePlant(@RequestBody PersonalPlantTable personalPlantTable)
    {
        if(personalPlantTableService.removePersonalPlant(personalPlantTable))
        {
            return Result.ok();
        }else
        {
            return Result.error("failed");
        }
    }

    @PostMapping("/removeEnv")
    public Result removeEnv(@RequestBody EnvTable envTable)
    {
        if(envTableService.removeEnv(envTable))
        {
            return Result.ok();
        }else
        {
            return Result.error("failed");
        }
    }
    @PostMapping("/scheme")
    public Result selectAllPersonalScheme(@RequestBody PersonalSchemeTable personalSchemeTable)
    {
        Long id = personalSchemeTable.getUserId();

        List<PersonalSchemeTable>personalSchemeTables = personalSchemeTableService.selectAllPersonalTable(id);
        List<SchemeTable> schemeTables = null;
        if(personalSchemeTables != null)
        {
            schemeTables =  schemeTableService.selectScheme(personalSchemeTables);
        }

        List<Map<String,Object>> res = new ArrayList<>();

        Map<Long,List<Object>> schemeMap = new HashMap<>();
        if(schemeTables != null)
        {
            for (SchemeTable schemeTable : schemeTables) {
                List<Object> temp =  new ArrayList<>();
                /**
                 * 0 = 方案名
                 * 1 = 生长期
                 * 2 = 点赞数
                 */
                temp.add(schemeTable.getSchemeName());
                temp.add(schemeTable.getGrowPeriod());
                temp.add(schemeTable.getLikesNums());
                schemeMap.put(schemeTable.getId(),temp);
            }

            for (PersonalSchemeTable table : personalSchemeTables) {
                Map<String,Object> resJson = new HashMap<>();
                Long schemeId = table.getSchemeId();
                resJson.put("id",table.getId());
                resJson.put("name",schemeMap.get(schemeId).get(0));
                resJson.put("date",table.getDate());
                resJson.put("exceuteTime",table.getExceuteTime());
                resJson.put("envrionment",table.getEnvId());
                resJson.put("growPeriod",schemeMap.get(schemeId).get(1));
                resJson.put("likeNums",schemeMap.get(schemeId).get(2));
                res.add(resJson);
            }
        }

        if(res != null)
        {
            return Result.ok(res);
        }

        return  Result.error();
    }

    @PostMapping("/addScheme")
    public Result addScheme(@RequestBody Map<String,Object> params)
    {
        Long envId = new Long((Integer) params.get("envId"));
        Long userId = new Long((Integer) params.get("userId"));
        Long plantId = new Long((Integer) params.get("plantId"));
        String schemeName = (String)params.get("schemeName");
        Double temperature = new Double((String)params.get("temperature"));
        Integer moisture = new Integer((String)params.get("moisture")) ;
        Integer lightTime = new Integer((String)params.get("lightTime"));
        String fertilizer = (String) params.get("fertilizer");
        Integer growPeriod = (Integer) params.get("growPeriod");

        SchemeTable schemeTable = new SchemeTable();
        schemeTable.setSchemeName(schemeName);
        schemeTable.setPassed(false);
        schemeTable.setUserId(userId);
        schemeTable.setPlantId(plantId);
        schemeTable.setTemperature(temperature);
        schemeTable.setMoisture(moisture);
        schemeTable.setLikesNums(0);
        schemeTable.setIsUpload(false);
        schemeTable.setLightTime(lightTime);
        schemeTable.setFertilizer(fertilizer);
        schemeTable.setGrowPeriod(growPeriod);


        Long schemeId = schemeTableService.addScheme(schemeTable,false);

        if(personalSchemeTableService.addPersonalScheme(schemeTable.getUserId(),schemeId,envId))
        {
            return Result.ok();
        }

        return Result.error();
    }

    @PostMapping("/addSchemeAdmin")
    public Result addSchemeAdmin(@RequestBody Map<String,Object> params)
    {
        Long userId = new Long((Integer) params.get("userId"));
        Long plantId = new Long((Integer) params.get("plantId"));
        String schemeName = (String)params.get("schemeName");
        Double temperature = new Double((String)params.get("temperature"));
        Integer moisture = new Integer((String)params.get("moisture")) ;
        Integer lightTime = new Integer((String)params.get("lightTime"));
        String fertilizer = (String) params.get("fertilizer");
        Integer growPeriod = (Integer) params.get("growPeriod");

        SchemeTable schemeTable = new SchemeTable();
        schemeTable.setSchemeName(schemeName);
        schemeTable.setPassed(false);
        schemeTable.setUserId(userId);
        schemeTable.setPlantId(plantId);
        schemeTable.setTemperature(temperature);
        schemeTable.setMoisture(moisture);
        schemeTable.setLikesNums(0);
        schemeTable.setIsUpload(false);
        schemeTable.setLightTime(lightTime);
        schemeTable.setFertilizer(fertilizer);
        schemeTable.setGrowPeriod(growPeriod);


        Long schemeId = schemeTableService.addScheme(schemeTable,true);
        if(schemeId != null)
            return Result.ok();

        return Result.error();
    }

    @PostMapping("/env")
    public Result addPersonalEnv(@RequestBody EnvTable envTable)
    {
        if(envTableService.inserEnv(envTable))
        {
            return Result.ok();
        }

        return Result.error();
    }

    @PostMapping("/addSchemeToPersonal")
    public Result addSchemeToPersonal(@RequestBody Map<String,Long>params)
    {
        Long envId = params.get("envId");
        Long schemeId = params.get("schemeId");
        Long userId = params.get("userId");

        Boolean res = personalSchemeTableService.addPersonalScheme(userId,schemeId,envId);
        if(res == true)
        {
            return Result.ok();
        }
        return Result.error();
    }

    @PostMapping("/removePersonalScheme")
    public Result removePersonalScheme(@RequestBody Map<String,Long>params)
    {
        Long schemePerId = params.get("id");

        if(personalSchemeTableService.removePersonalScheme(schemePerId))
        {
            return Result.ok();
        }

        return Result.error();
    }
}
