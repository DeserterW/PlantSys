package com.why.plant.service;

import com.why.plant.dao.model.PersonalSchemeTable;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【PersonalSchemeTable】的数据库操作Service
* @createDate 2022-05-02 21:12:16
*/
public interface PersonalSchemeTableService extends IService<PersonalSchemeTable> {

    List<PersonalSchemeTable> selectAllPersonalTable(Long userId);

    Long selectSchemeId(Long personalSchemeId);

    boolean addPersonalScheme(Long userId, Long schemeId, Long envId);

    boolean removePersonalScheme(Long schemePerId);
}
