package gxa.servlet;


import com.alibaba.fastjson.JSON;
import gxa.entity.Parking;
import gxa.service.ParkingService;
import gxa.service.impl.ParkingServiceImpl;
import gxa.utils.Result;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/page/parking/update")
public class ParkingUpdateServlet extends HttpServlet {

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
        String parkingNumber = req.getParameter("parkingNumber");
        String parkingName = req.getParameter("parkingName");


        Parking parking=new Parking(id,communityName,parkingNumber,parkingName);

        ParkingService parkingService=new ParkingServiceImpl();
        parkingService.update(parking);

        Result result = new Result(0,"success",null);
        String jsonStr = JSON.toJSONString(result);
        out.print(jsonStr);


    }



}

