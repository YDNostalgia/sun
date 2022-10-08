package gxa.servlet;


import com.alibaba.fastjson.JSON;
import gxa.entity.House;
import gxa.entity.Personnel;
import gxa.service.PersonnelService;
import gxa.service.impl.HouseServiceImpl;
import gxa.service.impl.PersonnelServiceImpl;
import gxa.utils.Result;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/page/personnel/update")
public class PersonnelUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        //接收参数

        int id= Integer.parseInt(req.getParameter("id"));

        String communityName = req.getParameter("communityName");
        System.out.println(communityName);
        String realState = req.getParameter("realState");
        String memberName = req.getParameter("memberName");
        String photo = req.getParameter("photo");
        String idCard = req.getParameter("idCard");
        String contact=req.getParameter("contact");
        String work= req.getParameter("work");
        Date birthdate= java.sql.Date.valueOf(req.getParameter("birthdate"));
        String sex = req.getParameter("sex");
        String memberType = req.getParameter("memberType");
        String note = req.getParameter("note");


        Personnel personnel=new Personnel(id,communityName,realState,memberName,photo,idCard,contact,work,birthdate,sex,memberType,note);

        PersonnelService personnelService=new PersonnelServiceImpl();
        personnelService.update(personnel);

        Result result = new Result(0,"success",null);
        String jsonStr = JSON.toJSONString(result);
        out.print(jsonStr);


    }



}

