package xyz.zhouge.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xyz.zhouge.rest.bean.Employee;
import xyz.zhouge.rest.dao.EmployeeDao;
import java.util.Collection;

/**
 * @BelongsProject: SpringMVC
 * @BelongsPackage: xyz.zhouge.rest.controller
 * @CreateTime: 2022-04-09  17:35
 * @Description: TODO
 * @Version: 1.0
 * @Author：zhouge
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    /***
     *同一个请求  /employee  不同的请求方式 代表不同的操作
     *  ---@RequestMapping(value = "/employee" ,method = RequestMethod.GET)
     *          ---代表 query 操作
     *  ---@RequestMapping(value = "/employee/{id}" ,method = RequestMethod.DELETE)
     *          ---代表 delete 操作
     *  ---@RequestMapping(value = "/employee" ,method = RequestMethod.POST)
     *          ---代表 insert 操作
     *  ---@RequestMapping(value = "/employee" ,method = RequestMethod.PUT)
     *          ---代表 update 操作
     *
     *
     *  注意：前提条件  配置 HiddenHttpMethodFilter
     */

    @RequestMapping(value = "/employee" ,method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("employees",employees);
        return "employee_list";
    }

    @RequestMapping(value = "/employee" ,method = RequestMethod.PUT)
    public  String updateEmployee(Employee employee){

        //  /employee put  请求代表更新操作 从请求中获取employee对象 并进行保存更新
        employeeDao.save(employee);

        //重定向到 /employee列表页面
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){

        //执行添加操作
        employeeDao.save(employee);

        //重定向到员工列表
        return "redirect:/employee";

    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){

        /*
        *开放静态资源
        * <!--
       处理静态资源，例如html、js、css、jpg
        若只设置该标签，则只能访问静态资源，其他请求则无法访问
        此时必须设置<mvc:annotation-driven/>解决问题
        -->
        <mvc:default-servlet-handler/>
        *
        * */

        //获取页面传递的id字段
        employeeDao.delete(id);

        //删除操作 使用重定向，避免重复提交  重定向到 /employee 页面 ===》上面的getAllEmployee()方法
        return "redirect:/employee";
    }




    /**
     *跳转到更新页面 携带employee数据
     * @author zhouge
     */
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String toUpdateEmployeeView(@PathVariable("id") Integer id ,Model model){

        //从表单传递的id中 获取Employee对象
        Employee employee = employeeDao.get(id);

        //将employee对象传递给employee_update.html
        model.addAttribute("employee",employee);
        return "employee_update";
    }

    /**
     * 跳转到添加页面
     * @author zhouge
     */
    @RequestMapping(value = "/addEmployee",method = RequestMethod.GET)
    public String toAddEmployeeView(){
        return "employee_add";
    }

}
