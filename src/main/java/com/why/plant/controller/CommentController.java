package com.why.plant.controller;
import com.why.plant.common.model.Result;
import com.why.plant.dao.model.CommentsTable;
import com.why.plant.service.CommentsTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/comment")
@RestController
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentsTableService commentsTableService;

    @PostMapping("/getAll")
    public Result getAll(@RequestBody Map<String,Long> params)
    {
        List<CommentsTable> commentsTableList = commentsTableService.getAllComment(null);

        if(commentsTableList != null)
            return Result.ok(commentsTableList);

        return Result.error();
    }
}
