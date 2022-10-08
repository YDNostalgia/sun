package gxa.servlet;




import gxa.entity.Community;
import gxa.entity.House;
import gxa.service.CommunityService;
import gxa.service.HouseService;
import gxa.service.impl.CommunityServiceImpl;
import gxa.service.impl.HouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/page/house/jump")
public class HouseJumpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");
        HttpSession session= req.getSession();

        String val= req.getParameter("id");
        int id= Integer.parseInt(val);


        HouseService houseService=new HouseServiceImpl();
        House house = houseService.queryById(id);
        System.out.println(house);

        req.setAttribute("house",house);

        req.getRequestDispatcher("edit.jsp").forward(req,resp);
    }
}
