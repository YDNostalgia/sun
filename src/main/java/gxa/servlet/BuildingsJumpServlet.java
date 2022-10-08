package gxa.servlet;




import gxa.entity.Buildings;
import gxa.entity.House;
import gxa.service.BuildingsService;
import gxa.service.HouseService;
import gxa.service.impl.BuildingsServiceImpl;
import gxa.service.impl.HouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/page/buildings/jump")
public class BuildingsJumpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");

        String val= req.getParameter("id");
        int id= Integer.parseInt(val);


        BuildingsService buildingsService=new BuildingsServiceImpl();
        Buildings buildings = buildingsService.queryById(id);
        System.out.println(buildings);

        req.setAttribute("buildings",buildings);

        req.getRequestDispatcher("edit.jsp").forward(req,resp);
    }
}
