package xyz.zhouge.view.type;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description TODO
 * @Classname TestThymeleafView
 * @Date 4/4/2022 10:33 AM
 * @Created by zhouge
 */
@Controller
public class TestThymeleafView {

    @RequestMapping("/testThymeleafView")
    public ModelAndView testThymeleafView(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg","I'm resolved by ThymeleafViewResolver .");
        mav.setViewName("success");
        return mav;
    }
}
