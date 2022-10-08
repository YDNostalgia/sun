package gxa.servlet;

import com.alibaba.fastjson.JSON;
import gxa.entity.House;
import gxa.service.HouseService;
import gxa.service.impl.HouseServiceImpl;
import gxa.utils.TableResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/page/house/list")
public class HouseListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String protagonist = req.getParameter("protagonist");

        Integer page = Integer.valueOf(req.getParameter("page"));

        Integer limit = Integer.valueOf(req.getParameter("limit"));


        HouseService houseService = new HouseServiceImpl();

        Integer count = houseService.count(protagonist);

        List<House> houses = houseService.queryHouse(page, limit, protagonist);
        TableResult tableResult = new TableResult(0, "suc", count, houses);
        System.out.println(tableResult);
        String communityJsonStr = JSON.toJSONString(tableResult);

        out.print(communityJsonStr);


    }
}
