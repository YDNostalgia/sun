package gxa.servlet;

import gxa.entity.Parking;
import gxa.entity.Pet;
import gxa.service.ParkingService;
import gxa.service.PetService;
import gxa.service.impl.ParkingServiceImpl;
import gxa.service.impl.PetServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/page/parking/jump")
public class ParkingJumpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");

        String val= req.getParameter("id");
        int id= Integer.parseInt(val);


        ParkingService parkingService=new ParkingServiceImpl();
        Parking parking = parkingService.queryById(id);

        req.setAttribute("parking",parking);

        req.getRequestDispatcher("edit.jsp").forward(req,resp);
    }
}
