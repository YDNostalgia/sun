package gxa.servlet;


import com.alibaba.fastjson.JSON;
import gxa.entity.House;
import gxa.entity.Personnel;
import gxa.service.HouseService;
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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/page/personnel/add")
public class PersonnelAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        //接收参数
        String communityName = req.getParameter("communityName");
        String realState = req.getParameter("realState");
        String memberName = req.getParameter("memberName");
        String photo = req.getParameter("photo");
        String idCard = req.getParameter("idCard");
        String contact=req.getParameter("contact");
        String work= req.getParameter("work");
        Date birthdate= java.sql.Date.valueOf(req.getParameter("birthdate"));
        System.out.println(birthdate);
        String sex = req.getParameter("sex");
        String memberType = req.getParameter("memberType");
        String note = req.getParameter("note");

        //直接新建一个TImestamp用于接受返回值
        Timestamp date = getTimeNow();

        Personnel personnel=new Personnel(communityName,realState,memberName,photo,idCard,contact,work,birthdate,sex,memberType,note,date);

        PersonnelService personnelService=new PersonnelServiceImpl();
        personnelService.save(personnel);

        Result result = new Result(0,"success",null);
        String jsonStr = JSON.toJSONString(result);
        System.out.println(jsonStr);
        out.print(jsonStr);


    }

    public Timestamp getTimeNow(){
        Date d = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNow = simpleDateFormat.format(d);
        return Timestamp.valueOf(dateNow);
    }

}

