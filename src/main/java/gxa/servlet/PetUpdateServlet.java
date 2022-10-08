package gxa.servlet;


import com.alibaba.fastjson.JSON;
import gxa.entity.Car;
import gxa.entity.Pet;
import gxa.service.CarService;
import gxa.service.PetService;
import gxa.service.impl.CarServiceImpl;
import gxa.service.impl.PetServiceImpl;
import gxa.utils.Result;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/page/pet/update")
public class PetUpdateServlet extends HttpServlet {

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
        String photo = req.getParameter("photo");
        String memberName = req.getParameter("memberName");
        String petName = req.getParameter("petName");
        String petColor = req.getParameter("petColor");
        String note = req.getParameter("note");
        Date adoptionTime=java.sql.Date.valueOf(req.getParameter("adoptionTime"));

        Pet pet=new Pet(id,photo,memberName,petName,petColor,note,adoptionTime);

        PetService petService=new PetServiceImpl();
        petService.update(pet);

        Result result = new Result(0,"success",null);
        String jsonStr = JSON.toJSONString(result);
        out.print(jsonStr);


    }



}

