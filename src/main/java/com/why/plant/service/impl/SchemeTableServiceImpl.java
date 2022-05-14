package com.why.plant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.why.plant.dao.mapper.SchemeTableMapper;
import com.why.plant.dao.model.PersonalSchemeTable;
import com.why.plant.dao.model.SchemeTable;
import com.why.plant.service.SchemeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        return schemeTable != null ? schemeTable : null;
    }

    @Override
    public Long addScheme(SchemeTable schemeTable) {

        schemeTable.setIsUpload(false);
        schemeTable.setPassed(false);
        schemeTable.setLikesNums(0);
        Integer res = schemeTableMapper.insert(schemeTable);
        if(res != 1)
        {
            return new Long(0);
        }

        return schemeTable.getId();
    }
}




