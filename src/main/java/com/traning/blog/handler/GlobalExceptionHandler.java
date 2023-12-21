//package com.traning.blog.handler;
//
//import com.traning.blog.pojo.Result;
//import jakarta.servlet.http.HttpServletRequest;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.annotation.AnnotationUtils;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.servlet.ModelAndView;
//
//@ControllerAdvice
//@Slf4j
//public class GlobalExceptionHandler {
//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleException(HttpServletRequest request,Exception e) throws Exception {
//        log.error("Request url:{},Exception: {}",request.getRequestURI(),e);
//
//        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){
//            throw e;
//        }
//
//        //返回error页面
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("url",request.getRequestURI());
//        modelAndView.addObject("Exception",e);
//        modelAndView.setViewName("error/error");
//
//        return modelAndView;
//    }
//}
