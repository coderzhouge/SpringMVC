package xyz.zhouge.converter.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @BelongsProject: SpringMVC
 * @BelongsPackage: xyz.zhouge.converter.controller
 * @CreateTime: 2022-04-10  13:48
 * @Description: TODO
 * @Version: 1.0
 * @Author：zhouge
 */
@Controller
public class FileUpAndDown {

    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {

        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();

        //获取服务器中文件的真实路径  getRealPath() 项目的部署路径
        String realPath = servletContext.getRealPath("/static/img/1.jpg");

        //创建输入流
        InputStream is = new FileInputStream(realPath);

        //创建字节数组  is.available() 获取当前is 的总长度
        byte[] bytes = new byte[is.available()];

        //将流读到字节数组中
        is.read(bytes);

        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();

        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");

        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;

        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);

        //关闭输入流
        is.close();

        return responseEntity;
    }

    @RequestMapping("/testUp")
    public String testUp(@RequestParam(value = "pic",required = false) MultipartFile photo, HttpSession session){
        /**
         * 传递的参数名字是pic 给的形参名是photo 为空   需要设置参数映射
         * @RequestParam(value = "" ,required = false ,default = "")
         *      value : 客户端传递的参数
         *      required： 传递的参数是否是必须的
         *      default：默认值
          */
        try {

            //获取客户端上传的文件名
            String fileName = photo.getOriginalFilename();

            //获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));

            //解决文件重名问题
            UUID uuid = UUID.randomUUID();
            fileName = uuid + suffixName;

            //通过session获取服务端上下文
            ServletContext servletContext = session.getServletContext();

            //获取文件为photo的路径
            String photoPath = servletContext.getRealPath("photo");

            //创建文件对象
            File file = new File(photoPath);

            //判空
            if(!file.exists()){
                //如果文件不存在则创建
                file.mkdir();
            }

            //设置文件保存路径
            String finalPath = photoPath + file.separator + fileName;

            //文件上传
            photo.transferTo(new File(finalPath));


        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }
}
