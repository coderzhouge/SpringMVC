package xyz.zhouge.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import xyz.zhouge.demo.interceptor.ConfigInterceptor;

import java.util.List;
import java.util.Properties;

/**
 * @BelongsProject: SpringMVC
 * @BelongsPackage: xyz.zhouge.demo.config
 * @CreateTime: 2022-04-18  21:50
 * @Description: 代替springMVC.xml
 * @Version: 1.0
 * @Author：zhouge
 */

/*
* springMVC常用配置项
* 1、开启扫描
* 2、视图解析器
* 3、view-controller
* 4、default-servlet-handler
* 5、mvc注解驱动
* 6、文件上传解析器
* 7、异常处理器
* 8、拦截器
*
* */
@Configuration
@ComponentScan("xyz.zhouge.demo.controller")
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    /* springMVC常用配置项
     * 1、开启扫描 √
     * 2、视图解析器 √
     *      ---配置视图模板解析器
     *      ---配置模板引擎
     *      ---设置视图解析器
     * 3、view-controller √
     * 4、default-servlet-handler √
     * 5、mvc注解驱动 √
     * 6、文件上传解析器 √
     * 7、异常处理器 √
     * 8、拦截器 √
     *
     * */


    //配置生成模板解析器
    @Bean
    public ITemplateResolver templateResolver() {
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        // ServletContextTemplateResolver需要一个ServletContext作为构造参数，可通过WebApplicationContext 的方法获得
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(
                webApplicationContext.getServletContext());
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }

    //生成模板引擎并为模板引擎注入模板解析器
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    //生成视图解析器并为解析器注入模板引擎
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }


    //view-controller
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hello").setViewName("hello");
    }


    //default-servlet-handler
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

        configurer.enable();
    }

    //interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ConfigInterceptor configInterceptor = new ConfigInterceptor();
        registry.addInterceptor(configInterceptor).addPathPatterns("/**");// /** 代表所有的请求
    }


    //文件上传解析器
    @Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        return commonsMultipartResolver;
    }

    //异常处理器
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        properties.setProperty("java.lang.ArithmeticException","error");//设置具体的异常类  key是具体的异常  value是异常后返回的页面
        simpleMappingExceptionResolver.setExceptionMappings(properties);
        simpleMappingExceptionResolver.setExceptionAttribute("ex");//设置出现异常类后 通过request域对象传值的key

        //将exception放入到解析器中
        resolvers.add(simpleMappingExceptionResolver);
    }
}
