package xyz.zhouge.maven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname RequestMappingController
 * @Description TODO
 * @Date 4/2/2022 9:17 PM
 * @Created by zhouge
 */
@Controller
@RequestMapping("/hello")//设置该类请求的初始信息
public class RequestMappingController {

    //此时 请求的路径为  /test/requestMapping
    @RequestMapping(
            value = {"/testRequestMapping","test"}//RequestMapping 底层是字符串数组 请求时，满足其中一个即可
            ,method = {RequestMethod.GET,RequestMethod.POST}//RequestMethod 底层是枚举类型数组；不设置时默认都可以允许，可以同时满足多个
    )
    public String success(){
        return "success";
    }

    /*
    *
    * 1、对于处理指定请求方式的控制器方法，SpringMVC中提供了@RequestMapping的派生注解

        处理get请求的映射-->@GetMapping

        处理post请求的映射-->@PostMapping

        处理put请求的映射-->@PutMapping

        处理delete请求的映射-->@DeleteMapping
    * */

    @GetMapping("/testGetMapping")
    public String testGetMapping(){
        return  "success";
    }

    @PutMapping("/testPutMapping")
    public String testPut(){
        return "success";
    }

    /**
     * "param"：要求请求映射所匹配的请求必须携带param请求参数
     *
     * "!param"：要求请求映射所匹配的请求必须不能携带param请求参数
     *
     * "param=value"：要求请求映射所匹配的请求必须携带param请求参数且param=value
     *
     * "param!=value"：要求请求映射所匹配的请求必须携带param请求参数但是param!=value
     */
    @RequestMapping(
            value = {"/testParamsWithUsername"}
            ,method = {RequestMethod.GET,RequestMethod.POST}
            ,params = {"username"}//表明请求携带的数据中 必须携带username
    )
    public String testParamsWithUsername(){
        return "success";
    }

    @RequestMapping(
            value = {"/testParamsCannotWithUsername"}
            ,method = {RequestMethod.GET,RequestMethod.POST}
            ,params = {"!username"}//表明请求携带的数据中 一定不能携带username
    )
    public String testParamsCannotWithUsername(){
        return "success";
    }

    @RequestMapping(
            value = {"/testParams"}
            ,method = {RequestMethod.GET,RequestMethod.POST}
            ,params = {"username","password!=123456"}//表明请求携带的数据中 必须携带username 且 必须携带password,password的值不能为123456
    )
    public String testParams(){
        return "success";
    }

    @RequestMapping(
            value = {"/testHeaders"}
            ,method = {RequestMethod.GET,RequestMethod.POST}
            ,params = {"username","password=123456"}//表明请求携带的数据中 必须携带username 且 必须携带password,password的值不能为123456
            ,headers = {"Host=localhost:8080"}//表明携带的请求请求头中 host必须是localhost：8080
    )
    public String testHeaders(){
        return "success";
    }

    /**SpringMVC支持ant风格的路径
     * ？：表示任意的单个字符
     *
     * *：表示任意的0个或多个字符
     *
     * \**：表示任意的一层或多层目录
     *
     * 注意：在使用\**时，只能使用/**xxx的方式
     **/

    //@RequestMapping("/test?success")
    @RequestMapping("/test*success")
    public String testAnt(){
        return "success";
    }

    /**
     * ### SpringMVC支持路径中的占位符（重点）
     *
     * 原始方式：/deleteUser?id=1
     *
     * rest方式：/deleteUser/1
     */

    @RequestMapping(
            value = {"/testPath"}
            ,params = {"username=admin","password=123456"}
    )
    public String testPath(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: "+username + "   password: "+password);
        return "success";
    }

    @RequestMapping("testPath2/{username}/{password}/{id}") //使用 {} 作为占位符 里面字符串代表形参
    public String testPath2(@PathVariable("username") String name,@PathVariable("password") String pwd,@PathVariable("id") Integer id){

        //使用@pathvariable 注解来获取参数  这是唯一的方式
        System.out.println("username: "+name + "   pwd: "+pwd + "   id: "+id);
        return "success";
    }



}
