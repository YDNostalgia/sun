package gxa.servlet;




import gxa.entity.Car;
import gxa.entity.Personnel;
import gxa.service.CarService;
import gxa.service.PersonnelService;
import gxa.service.impl.CarServiceImpl;
import gxa.service.impl.PersonnelServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/page/car/jump")
public class CarJumpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");

        String val= req.getParameter("id");
        int id= Integer.parseInt(val);


        CarService carService=new CarServiceImpl();
        Car car = carService.queryById(id);

        req.setAttribute("car",car);

        req.getRequestDispatcher("edit.jsp").forward(req,resp);
    }
}
