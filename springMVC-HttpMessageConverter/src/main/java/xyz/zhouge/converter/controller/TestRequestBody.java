package xyz.zhouge.converter.controller;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.zhouge.converter.bean.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @BelongsProject: SpringMVC
 * @BelongsPackage: xyz.zhouge.converter.controller
 * @CreateTime: 2022-04-09  23:51
 * @Description: TODO
 * @Version: 1.0
 * @Author：zhouge
 */
@Controller
public class TestRequestBody {

    /**
     *
     * 请求报文：请求头 请求空行 请求体
     *
     *  -----get  的请求的结果在地址栏中会展示出来
     *  -----post 的请求结果不会再地址栏中展示出来，放置在请求报文中的 请求体中
     */

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String user){
        System.out.println(user);//打印请求体内容
        return "success";
    }

    @RequestMapping("/testRequestEnity")
    public String testRequestEnity(RequestEntity<String> requestEntity){
        System.out.println("请求头： "+requestEntity.getHeaders());
        System.out.println("请求体： "+requestEntity.getBody());
        return "success";
    }


    @RequestMapping(value = "/testHttpServletResponse")
    public void testHttpServletResponse(HttpServletResponse response){

        try {
            //设置服务器端编码
            response.setCharacterEncoding("utf-8");

            //设置客户端浏览器编码
            response.setHeader("Content-type", "text/html; charset=utf-8");

            response.getWriter().println("你好");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody(){

        //添加ResponseBody注解后  表明该方法 是一个响应体方法，return 结果以数据的方式进行响应，而不会以页面进行响应
        return "success";
    }


    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser(){

        /**
         * jsckson执行步骤
         *      1、导入jackson依赖
         *      2、在springMVC.xml 配置文件中配置mvc的注解驱动
         *                  即  <mvc:annotation-driven />
         *      3、在处理器方法上使用@ResponseBody 注解进行标识
         *      4、将java对象直接作为控制器方法的返回值返回，就会自动转换为json格式的字符串
         */

        //不导入jackson包 会出错
        //HttpMessageNotWritableException: No converter found for return value of type: class xyz.zhouge.converter.bean.User

        return new User(1001,"zhouge","sfasdfasdfas",22,"男");
    }


    @RequestMapping("/testAjax")
    @ResponseBody
    public String testAjax(String username , String password){
        System.out.println(username + ","+password);
        return "hello,Ajax";
    }


    @RequestMapping("/testFile")
    public String testFile(){
        return "file";
    }


}
