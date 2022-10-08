package gxa.servlet;

import com.alibaba.fastjson.JSON;
import gxa.dao.ParkingDao;
import gxa.dao.impl.ParkingDaoImpl;
import gxa.entity.Parking;
import gxa.utils.TableResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/page/parking/list")
public class ParkingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String communityName = req.getParameter("communityName");

        Integer page = Integer.valueOf(req.getParameter("page"));

        Integer limit = Integer.valueOf(req.getParameter("limit"));


        ParkingDao parkingDao=new ParkingDaoImpl();

        Integer count = parkingDao.count(communityName);

        List<Parking> parking = parkingDao.queryParking(page, limit, communityName);
        TableResult tableResult = new TableResult(0, "suc", count, parking);

        String communityJsonStr = JSON.toJSONString(tableResult);

        out.print(communityJsonStr);


    }
}
