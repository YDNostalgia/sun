package gxa.servlet;


import com.alibaba.fastjson.JSON;
import gxa.entity.Community;
import gxa.entity.House;
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

@WebServlet("/page/house/update")
public class HouseUpdateServlet extends HttpServlet {

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
        System.out.println("++++++++++++"+id);
        String community = req.getParameter("community");
        String building = req.getParameter("building");
        String estateCodes = req.getParameter("estateCodes");
        String estateName = req.getParameter("estateName");
        String protagonist = req.getParameter("protagonist");
        String contact=req.getParameter("contact");
        String rooms= req.getParameter("rooms");
        String element=req.getParameter("element");
        String floor = req.getParameter("floor");
        String depict = req.getParameter("depict");
        

        House house = new House(id,community,building,estateCodes,estateName,protagonist,contact,rooms,element,floor,depict);

        HouseServiceImpl houseService=new HouseServiceImpl();
        houseService.update(house);

        Result result = new Result(0,"success",null);
        String jsonStr = JSON.toJSONString(result);
        out.print(jsonStr);


    }



}

