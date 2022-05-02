package com.why.plant.handler;

import com.why.plant.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 统一异常处理
 */
@Slf4j
public class GlobalExceptionAdvice {
    /**
     * 全局处理异常
     *
     * @param e 异常类
     * @return
     */
    @ExceptionHandler({Exception.class,RuntimeException.class})
    public Result globalExceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        return Result.error(e.getMessage());
    }
}
