package com.why.plant.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.why.plant.dao.model.PersonalSchemeTable;
import com.why.plant.dao.model.SchemeTable;

import java.util.List;

/**
* @author Administrator
* @description 针对表【SchemeTable】的数据库操作Service
* @createDate 2022-05-02 21:08:23
*/
public interface SchemeTableService extends IService<SchemeTable> {

    List<SchemeTable> selectScheme(List<PersonalSchemeTable> personalSchemeTables);

    SchemeTable selectSchemeDetail(Long schemeId);

    Long addScheme(SchemeTable schemeTable);
}
