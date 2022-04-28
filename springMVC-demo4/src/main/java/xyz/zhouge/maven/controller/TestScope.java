package xyz.zhouge.maven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Description 测试springMVC 共享域对象
 * @Classname TestScope
 * @Date 4/3/2022 4:13 PM
 * @Created by zhouge
 */
@Controller
public class TestScope {

    @RequestMapping("/")
    public String index(){
        return "index";
    }


    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){
        request.setAttribute("username","zhouge");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){

        /**
         * ModelAndView有Model和View的功能
         * Model主要用于向请求域共享数据
         * View主要用于设置视图，实现页面跳转
         */
        ModelAndView mav = new ModelAndView();
        mav.addObject("mav","sendDataByModelAndView");
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("model","I'm is model .");
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("map","I'm is Map .");
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("modelMap", "hello,ModelMap");
        return "success";
    }

    @ResponseBody
    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("se","hello,Session");
        return "success";
    }

    @ResponseBody
    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("app","I'm application");
        return "success";
    }
}

