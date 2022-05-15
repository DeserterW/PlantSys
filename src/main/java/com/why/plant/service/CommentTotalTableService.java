package com.why.plant.service;

import com.why.plant.dao.model.CommentTotalTable;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【CommentTotalTable】的数据库操作Service
* @createDate 2022-05-15 16:06:17
*/
public interface CommentTotalTableService extends IService<CommentTotalTable> {

    public List<Long> getCommentList(CommentTotalTable commentTotalTable);

    public List<CommentTotalTable> getAllComment(CommentTotalTable commentTotalTable);

    public Boolean addComment(Long commendId,Long mainId);

    public Boolean addNewTitle(CommentTotalTable commentTotalTable);
}
