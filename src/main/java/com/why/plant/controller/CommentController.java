package com.why.plant.controller;
import com.why.plant.common.model.Result;
import com.why.plant.dao.model.CommentTotalTable;
import com.why.plant.dao.model.CommentsTable;
import com.why.plant.dao.model.SchemeTable;
import com.why.plant.service.CommentTotalTableService;
import com.why.plant.service.CommentsTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.Map;

@RequestMapping("/comment")
@RestController
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentsTableService commentsTableService;

    @Autowired
    private CommentTotalTableService commentTotalTableService;

    @PostMapping("/getAll")
    public Result getAll(@RequestBody Map<String,Long> params)
    {
//        List<CommentsTable> commentsTableList = commentsTableService.getAllComment(null);
        List<CommentTotalTable> commentTotalTables = commentTotalTableService.getAllComment(null);

        if(commentTotalTables != null)
            return Result.ok(commentTotalTables);

        return Result.error();
    }

    @PostMapping("/getOne")
    public Result getOne(@RequestBody CommentTotalTable commentTotalTable)
    {
        List<Long> commentIds = commentTotalTableService.getCommentList(commentTotalTable);

        List<CommentsTable> commentsTables = commentsTableService.getSeriesComment(commentIds);

        return Result.ok(commentsTables);

    }

    @PostMapping("/like")
    public Result putALikeOnComment(@RequestBody CommentsTable commentsTable)
    {

        if(commentsTableService.putALike(commentsTable))
        {
            return Result.ok();
        }else
            return Result.error();

    }

    @PostMapping("/back")
    public Result commentBack(@RequestBody Map<String,String> params)
    {

        Long mainId = Long.parseLong(params.get("id"));
        Long userId = Long.parseLong(params.get("userId"));
        String content = params.get("content");
        CommentsTable commentsTable = new CommentsTable();
        commentsTable.setUserId(userId);
        commentsTable.setContent(content);

        Long commentId = commentsTableService.commentBack(commentsTable);

        if(commentTotalTableService.addComment(commentId,mainId)){
            return Result.ok();
        }


        return Result.error();
    }

    @PostMapping("/addNewTitle")
    public Result addNewTitle(@RequestBody Map<String,String> params)
    {
        String title = params.get("title");
        String content = params.get("content");
        Long userId = Long.parseLong(params.get("userId"));

        CommentsTable commentsTable = new CommentsTable();
        commentsTable.setContent(content);
        commentsTable.setUserId(userId);

        Long commentId = commentsTableService.commentBack(commentsTable);
        CommentTotalTable commentTotalTable = new CommentTotalTable();
        commentTotalTable.setTitle(title);
        commentTotalTable.setUserId(userId);
        commentTotalTable.setCommentList(commentId.toString());
        if(commentTotalTableService.addNewTitle(commentTotalTable)){
            return Result.ok();
        }else
        {
            return Result.error();
        }

    }

    @GetMapping("/getAllNotPassed")
    public Result getAllCommentNotPassed()
    {
        List<CommentsTable> commentsTables = commentsTableService.getAllComment(null,false);

        if(commentsTables != null)
        {
            return Result.ok(commentsTables);
        }

        return Result.error();
    }


    @PostMapping("/checkComment")
    public Result checkComment(@RequestBody CommentsTable commentsTable)
    {
        Boolean passed = commentsTable.getPassed();

        if(passed)
        {
            if(commentsTableService.setPassed(commentsTable))
            {
                return Result.ok("passed");
            }
        }

        return Result.ok("Not Passed");
    }
}
