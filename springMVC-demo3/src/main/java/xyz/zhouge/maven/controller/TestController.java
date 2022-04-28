package xyz.zhouge.maven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.zhouge.maven.bean.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @Classname TestController
 * @Description TODO
 * @Date 4/3/2022 12:05 AM
 * @Created by zhouge
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public String testIndex(){
        return "index";
    }

    /**
     * 方式一：通过url获取参数--RESTful风格
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/testUrl/{username}/{password}")
    public String testUrl(@PathVariable("username") String username ,@PathVariable("password") String password){
        System.out.println("username=>" + username + "  password=>"+password);
        return  "success";
    }

    /**
     * 方式二：通过ServletAPI获取请求参数
     * @param request
     * @return
     */
    @RequestMapping("/testRequest")
    public String testRequest(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username=>" + username + "  password=>"+password);
        return "success";
    }

    /**
     * 方式三：通过传递参数和形参同名法获取请求参数
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/testParams")
    public String testParams(String username , String password){
        System.out.println("username=>" + username + "  password=>"+password);
        return "success";
    }

    /**
     * 方式四：通过@RequestParam注解获取请求参数
     *  作用：是将 请求参数 和 控制器形参 之间建立映射关系
     * @param username
     * @param password
     * @param usergender
     * @param hobbies
     * @return
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(
            @RequestParam(value = "user_name",required = false,defaultValue = "testUser") String username
            ,String password
            ,String usergender
            ,String[] hobbies
    ){
        System.out.println("username=>"+username+"  password=>"+password + "   sex=>"+usergender+"   hobbies=>"+ Arrays.toString(hobbies));
        return  "success";
    }

    /**
     * 方式五：通过@RequestHeader获取请求头信息
     * @param host
     * @param haha
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testHeader(
            @RequestHeader("Host")String host
            ,@RequestHeader(value = "sayHello" ,required = true ,defaultValue = "hello") String haha
    ){
        System.out.println("Host=>"+host+",sayHello=>"+haha);
        return "success";
    }

    /**
     * 方式六：通过@CookieValue获取cookie数据
     *      第一次从浏览器想服务器发起请求时，cookie会再请求头中的响应头部分创建
     *      第二次开始，再次发起请求时，cookie会保存在请求头中
     * @param request
     * @param JSESSIONID
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(
            HttpServletRequest request
            ,@CookieValue("JSESSIONID")String JSESSIONID
    ){

        /**
         * @CookieValue 从浏览器中获取Cookie数据
         *
         * 第一次请求时，浏览器会创建cookie 并将此保存在响应报文中
         *      Set-Cookie: JSESSIONID=E93CCAFE2AF7303EB44AA772B0885420; Path=/demo3; HttpOnly
         * 后面再次请求时,浏览器会再请求报文中获取
         *      Cookie: JSESSIONID=E93CCAFE2AF7303EB44AA772B0885420
         */
        HttpSession session = request.getSession();
        System.out.println("JSESSIONID=>"+JSESSIONID);
        return  "success";
    }

    /**
     * 式七：通过实体类获取请求参数
     * @param user
     * @return
     */
    @RequestMapping("/testBean")
    public String testBean(User user){
        /**
         * 当需要传递的参数过多时，可以使用实体类类传递。但是要求 传递的参数名跟实体类中的属性名一致
         */
        System.out.println(user);
        return "success";
    }


}
