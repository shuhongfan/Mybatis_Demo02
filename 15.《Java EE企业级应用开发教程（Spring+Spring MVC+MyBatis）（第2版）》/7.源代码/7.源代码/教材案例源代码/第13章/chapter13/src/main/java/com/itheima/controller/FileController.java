package com.itheima.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.pojo.Resource;
import com.itheima.utils.JSONFileUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FileController {
    /**
     * 文件上传
     */
    @RequestMapping("fileload")
    public String fileLoad(MultipartFile[] files,
                             HttpServletRequest request) throws Exception {
        //设置上传的文件所存放的路径
        String path = request.getServletContext().getRealPath("/") + "files/";
        ObjectMapper mapper = new ObjectMapper();
        if (files != null && files.length > 0) {
            //循环获取上传的文件
            for (MultipartFile file : files) {
                //获取上传文件的名称
                String filename = file.getOriginalFilename();
                ArrayList<Resource> list = new ArrayList<>();
                //读取files.json文件中的文件名称
                String json = JSONFileUtils.readFile(path + "/files.json");
                if (json.length() != 0) {
                    //将files.json的内容转为集合
                    list = mapper.readValue(json,
                            new TypeReference<List<Resource>>() {
                            });
                    for (Resource resource : list) {
                        //如果上传的文件在files.json文件中有同名文件，将当前上传的文件重命名，以避免重名
                        if (filename.equals(resource.getName())) {
                            String[] split = filename.split("\\.");
                            filename = split[0] + "(1)." + split[1];
                        }
                    }
                }
                // 文件保存的全路径
                String filePath = path + filename;
                // 保存上传的文件
                file.transferTo(new File(filePath));
                list.add(new Resource(filename));
                json = mapper.writeValueAsString(list); //将集合中转换成json
                //将上传文件的名称保存在files.json文件中
                JSONFileUtils.writeFile(json, path + "/files.json");
            }
            request.setAttribute("msg", "(上传成功)");
            return "forward:fileload.jsp";
        }
        request.setAttribute("msg", "(上传失败)");
        return "forward:fileload.jsp";
    }

    @ResponseBody
    @RequestMapping(value = "/getFilesName",
            produces = "text/html;charset=utf-8")
    public String getFilesName(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        String path = request.getServletContext().
                getRealPath("/") + "files/files.json";
        String json = JSONFileUtils.readFile(path);
        return json;
    }

    /**
     * 根据浏览器的不同进行编码设置，返回编码后的文件名
     */
    public String getFileName(HttpServletRequest request,
                              String filename) throws Exception {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String agent = request.getHeader("User-Agent");
        if (agent.contains("Firefox")) {
            // 火狐浏览器
            filename = "=?UTF-8?B?" + new String
                    (base64Encoder.encode(filename.getBytes("UTF-8"))) + "?=";
        } else {
            // IE及其他浏览器
            filename = URLEncoder.encode(filename, "UTF-8");
        }
        return filename;
    }

    /**
     * 文件下载
     */
    @RequestMapping("/download")
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request,
                                               String filename) throws Exception {
        // 指定要下载的文件所在路径
        String path = request.getServletContext().getRealPath("/files/");
        filename = new String(filename.getBytes("ISO-8859-1"), "UTF-8");
        // 创建该文件对象
        File file = new File(path + File.separator + filename);
        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        filename = this.getFileName(request, filename);
        // 通知浏览器以下载的方式打开文件
        headers.setContentDispositionFormData("attachment", filename);
        // 定义以流的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 使用Sring MVC框架的ResponseEntity对象封装返回下载数据
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.OK);
    }


}

