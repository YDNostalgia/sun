package gxa.servlet;




import gxa.entity.Personnel;
import gxa.service.PersonnelService;
import gxa.service.impl.PersonnelServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/page/personnel/jump")
public class PersonnelJumpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");

        String val= req.getParameter("id");
        int id= Integer.parseInt(val);


        PersonnelService personnelService=new PersonnelServiceImpl();
        Personnel personnel = personnelService.queryById(id);
        System.out.println(personnel);

        req.setAttribute("personnel",personnel);

        req.getRequestDispatcher("edit.jsp").forward(req,resp);
    }
}
