package com.why.plant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.why.plant.dao.mapper.SchemeTableMapper;
import com.why.plant.dao.model.EnvTable;
import com.why.plant.dao.model.PersonalSchemeTable;
import com.why.plant.dao.model.SchemeTable;
import com.why.plant.service.SchemeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author Administrator
* @description 针对表【SchemeTable】的数据库操作Service实现
* @createDate 2022-05-02 21:08:23
*/
@Service
public class SchemeTableServiceImpl extends ServiceImpl<SchemeTableMapper, SchemeTable>
    implements SchemeTableService {

    @Autowired
    private SchemeTableMapper schemeTableMapper;

    @Override
    public List<SchemeTable> selectScheme(List<PersonalSchemeTable>  personalSchemeTables) {

        List<Long> schemeIds = personalSchemeTables.stream().map(personalSchemeTable -> personalSchemeTable.getSchemeId()).collect(Collectors.toList());

        List<SchemeTable> schemeTables = schemeTableMapper.selectList(new LambdaQueryWrapper<SchemeTable>()
                .in(SchemeTable::getId,schemeIds));

        if(schemeTables != null)
        {
            return schemeTables;
        }

        return null;
    }

    @Override
    public SchemeTable selectSchemeDetail(Long schemeId) {

        SchemeTable schemeTable = schemeTableMapper.selectOne(new LambdaQueryWrapper<SchemeTable>().eq(SchemeTable::getId,schemeId));

        return schemeTable;
    }

    @Override
    public Long addScheme(SchemeTable schemeTable ,boolean isAdmin) {

        schemeTable.setIsUpload(false);
        if(isAdmin)
        {
            schemeTable.setPassed(true);
        }else
        {
            schemeTable.setPassed(false);
        }
        schemeTable.setLikesNums(0);
        Integer res = schemeTableMapper.insert(schemeTable);
        if(res != 1)
        {
            return new Long(0);
        }

        return schemeTable.getId();
    }

    @Override
    public List<SchemeTable> selectScheme(Boolean passed) {
        // passed 表示返回的是审核的还是未审核的
        List<SchemeTable>schemeTables;

        schemeTables = schemeTableMapper.selectList(new LambdaQueryWrapper<SchemeTable>().eq(SchemeTable::getPassed,passed));


        return schemeTables;
    }

    @Override
    public List<SchemeTable> selectAllScheme(Long plantId) {

        List<SchemeTable>  schemeTables = schemeTableMapper.selectList(new LambdaQueryWrapper<SchemeTable>()
                .eq(SchemeTable::getPlantId,plantId));

        return schemeTables;
    }

    @Override
    public List<SchemeTable> recommdation(EnvTable envTable, List<SchemeTable> schemeTables) {
        // 推荐算法
        List<Double> similiarKs = new ArrayList<>();
        List<SchemeTable> recommdationTables = new ArrayList<>();

        for(int i = 0 ; i < schemeTables.size() ;i++)
        {
            double similiarK = 0.0;
            double maxTemperature = envTable.getTemperature() > schemeTables.get(i).getTemperature() ?
                    envTable.getTemperature() : schemeTables.get(i).getTemperature();
            double maxMoisture = envTable.getHumidity() > schemeTables.get(i).getMoisture() ?
                    envTable.getHumidity() : schemeTables.get(i).getMoisture();

            similiarK += (envTable.getTemperature() - schemeTables.get(i).getTemperature())/maxTemperature;

            similiarK += (envTable.getHumidity()-schemeTables.get(i).getMoisture())/maxMoisture;

            similiarK *= schemeTables.get(i).getLikesNums();

            similiarKs.add(1/similiarK);
            if(schemeTables.get(i).getLikesNums() > 1000)
            {
                recommdationTables.add(schemeTables.get(i));
            }
        }
        double MaxSimiliar = 0.0;
        int index = 0;
        for(int i = 0 ; i < similiarKs.size();i++)
        {
            if(MaxSimiliar < similiarKs.get(i)){
                MaxSimiliar = similiarKs.get(i);
                index = i;
            }else
            {
                continue;
            }
        }
        recommdationTables.add(schemeTables.get(index));


        return recommdationTables;
    }

    @Override
    public Boolean putALike(SchemeTable schemeTableUpdate) {

        schemeTableUpdate = schemeTableMapper.selectById(schemeTableUpdate.getId());
        schemeTableUpdate.setLikesNums(schemeTableUpdate.getLikesNums() + 1);

        int res = schemeTableMapper.updateById(schemeTableUpdate);
        if(res == 1) return true;

        return false;
    }

    @Override
    public Boolean passScheme(Long schemeId) {

        SchemeTable schemeTable  = new SchemeTable();
        schemeTable.setId(schemeId);;
        schemeTable.setPassed(true);

        int res = schemeTableMapper.updateById(schemeTable);

        if( res == 1)
        {
            return true;
        }

        return false;
    }

    @Override
    public Boolean deleteScheme(SchemeTable schemeTable) {

        int res = schemeTableMapper.deleteById(schemeTable);

        if(res == 1)
        {
            return true;
        }else
            return false;

    }
}




