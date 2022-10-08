package gxa.servlet;

import com.alibaba.fastjson.JSON;
import gxa.entity.Personnel;
import gxa.service.BuildingsService;
import gxa.service.PersonnelService;
import gxa.service.impl.BuildingsServiceImpl;
import gxa.service.impl.PersonnelServiceImpl;
import gxa.utils.Result;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet("/page/personnel/delete")
public class PersonnelDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter out = resp.getWriter();

        //接收参数
        String id = req.getParameter("id");
        List<String> ids= Arrays.asList(id.split(","));


        if (ids.size()==0){
            PersonnelService personnelService=new PersonnelServiceImpl();
            personnelService.delete(Integer.parseInt(id));
        } else if (ids.size()!=0){
            for(int i=0;i<ids.size();i++){
                PersonnelService personnelService=new PersonnelServiceImpl();
                personnelService.delete(Integer.parseInt(ids.get(i)));
            }
        }

        Result result = new Result(0,"success",null);
        String jsonStr = JSON.toJSONString(result);
        out.print(jsonStr);


    }
}
