package com.why.plant.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.why.plant.dao.model.CommentsTable;

import java.util.List;

/**
* @author Administrator
* @description 针对表【CommentsTable】的数据库操作Service
* @createDate 2022-05-02 20:59:59
*/
public interface CommentsTableService extends IService<CommentsTable> {

    public List<CommentsTable> getAllComment(CommentsTable commentsTable, Boolean isPassed);

    public List<CommentsTable> getSeriesComment(List<Long> commentIds);

    public Boolean putALike(CommentsTable commentsTable);

    public Long commentBack(CommentsTable commentsTable);

    public Boolean setPassed(CommentsTable commentsTable);
}
