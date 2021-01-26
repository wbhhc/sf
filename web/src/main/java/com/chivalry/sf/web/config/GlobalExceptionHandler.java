package com.chivalry.sf.web.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

//暂时不启用异常拦截,会将responsebody的跳转
//@ControllerAdvice
public class GlobalExceptionHandler {
    Logger logger= Logger.getLogger(GlobalExceptionHandler.class.getName());

    @ExceptionHandler(value=Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView MethodArgumentNotValidHandler(Exception exception)
    {
        logger.info(exception.toString());
        ModelAndView m = new ModelAndView();
        m.addObject("exception", exception.getMessage());
        m.setViewName("error/500");
        return m;
    }
}