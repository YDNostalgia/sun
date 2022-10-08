package gxa.servlet;

import gxa.entity.Pet;
import gxa.service.PetService;
import gxa.service.impl.PetServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/page/pet/jump")
public class PetJumpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");

        String val= req.getParameter("id");
        int id= Integer.parseInt(val);


        PetService petService=new PetServiceImpl();
        Pet pet = petService.queryById(id);

        req.setAttribute("pet",pet);

        req.getRequestDispatcher("edit.jsp").forward(req,resp);
    }
}
