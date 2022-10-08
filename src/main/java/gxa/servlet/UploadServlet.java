package gxa.servlet;

import com.alibaba.fastjson.JSON;
import gxa.utils.Result;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

@WebServlet("/page/file/upload")
public class UploadServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("========================================");
        PrintWriter out = resp.getWriter();
        FileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);

        Result result = new Result(0,"suc",null);
        try {
            List<FileItem> fileItems= upload.parseRequest(req);

            for(FileItem item : fileItems){
                String fieldName= item.getFieldName();

                if("file".equals(fieldName)) {
                    //做文件上传处理
                    String picName = item.getName();


                    String extName = picName.substring(picName.lastIndexOf("."));//.jpg
                    String newName = UUID.randomUUID()+extName;

                    File dest = new File("D:/photos/" + newName);
                    item.write(dest);

                    result.setData("http://localhost:/photos/"+newName);
                }

            }

            System.out.println(fileItems);


        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(1);
            result.setMsg("保存失败!");
        }finally {
            String jsonString = JSON.toJSONString(result);
            out.print(jsonString);
        }
    }
}
