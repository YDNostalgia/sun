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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/page/parking/add")
public class ParkingAddServlet extends HttpServlet {

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
        String parkingNumber = req.getParameter("parkingNumber");
        String parkingName = req.getParameter("parkingName");

        //直接新建一个TImestamp用于接受返回值
        Timestamp date = getTimeNow();

        Parking parking=new Parking(communityName,parkingNumber,parkingName,date);

        ParkingService parkingService=new ParkingServiceImpl();
        parkingService.save(parking);

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

