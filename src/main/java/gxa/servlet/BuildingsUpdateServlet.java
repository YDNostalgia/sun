package gxa.servlet;


import com.alibaba.fastjson.JSON;
import gxa.entity.Buildings;
import gxa.service.impl.BuildingsServiceImpl;
import gxa.utils.Result;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/page/buildings/update")
public class BuildingsUpdateServlet extends HttpServlet {

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
        String communityNumber = req.getParameter("communityNumber");
        String buildingName = req.getParameter("buildingName");
        String households = req.getParameter("households");
        String depict = req.getParameter("depict");
        

        Buildings buildings = new Buildings(id,communityName,communityNumber,buildingName,households,depict);

        BuildingsServiceImpl buildingsService=new BuildingsServiceImpl();
        buildingsService.update(buildings);

        Result result = new Result(0,"success",null);
        String jsonStr = JSON.toJSONString(result);
        out.print(jsonStr);


    }



}

