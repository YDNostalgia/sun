package gxa.servlet;


import com.alibaba.fastjson.JSON;
import gxa.entity.Community;
import gxa.entity.House;
import gxa.service.CommunityService;
import gxa.service.HouseService;
import gxa.service.impl.CommunityServiceImpl;
import gxa.service.impl.HouseServiceImpl;
import gxa.utils.Result;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/page/house/add")
public class HouseAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        //接收参数
        String community = req.getParameter("community");
        String building=req.getParameter("building");
        String estateCodes=req.getParameter("estateCodes");
        String estateName=req.getParameter("estateName");
        String protagonist=req.getParameter("protagonist");
        String contact=req.getParameter("contact");
        String rooms=req.getParameter("rooms");
        String element=req.getParameter("element");
        String floor=req.getParameter("floor");
        String describe=req.getParameter("describe");

        //直接新建一个TImestamp用于接受返回值
        Timestamp date = getTimeNow();

        House house =new House(community,building,estateCodes,estateName,protagonist,contact,rooms,element,floor,describe,date);
        System.out.println(house);
        HouseService houseService=new HouseServiceImpl();
        houseService.save(house);

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

