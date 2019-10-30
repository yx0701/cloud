package com.yx.demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice   //@ResponseBody + @ControllerAdvice  该类中注解会作用在所有@RequestMapping上  如 @InitBinder 等
public class MyExceptionHandler {

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ArithmeticException.class)
    public Object exceptionHandler(){
        System.out.println("-------------捕获Throwable异常");
        HashMap map = new HashMap();
        map.put("code","10001");
        map.put("msg","算数异常");
        return map;
    }

    @ExceptionHandler(MyException.class)
    public Object exceptionHandler2(){
        System.out.println("-------------捕获MyException异常");
        HashMap map = new HashMap();
        map.put("code","10002");
        map.put("msg","myException");
        return map;
    }
}
