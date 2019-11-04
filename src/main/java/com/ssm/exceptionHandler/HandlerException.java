package com.ssm.exceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//需为这个类配置一个bean
//@ControllerAdvice
public class HandlerException {
    /**
     * 1.在@ExceptionHandler 方法中的入参可以加入Exception类型的参数，该参数及对应发生的异常对象
     * 2.@ExceptionHandler 方法的入参中不能传入Map.若希望把异常信息传入页面上，需要使用ModelAndView
     * 3.ru如果在当前的控制器中找不到@ExceptionHandler方法来处理出现的异常，则去@ControllerAdvice标记的类中寻找
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView handleArithmeticException(Exception ex){
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception",ex);
        return mv;
    }
}
