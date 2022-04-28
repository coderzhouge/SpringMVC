package xyz.zhouge.exception.exception;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @BelongsProject: SpringMVC
 * @BelongsPackage: xyz.zhouge.exception.exception
 * @CreateTime: 2022-04-18  21:12
 * @Description: TODO
 * @Version: 1.0
 * @Author：zhouge
 */
@ControllerAdvice
public class mArithmeticException {

    /**
     *基于注解的方式实现异常类配置
     */

    @ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class})
    public String textArithmeticException2(Exception ex , Model model){
        model.addAttribute("ex",ex);
        return "error";
    }
}
