package gxa.servlet;

import com.alibaba.fastjson.JSON;
import gxa.dao.PetDao;
import gxa.dao.impl.PetDaoImpl;
import gxa.entity.Car;
import gxa.entity.Pet;
import gxa.service.CarService;
import gxa.service.impl.CarServiceImpl;
import gxa.utils.TableResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/page/pet/list")
public class PetListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String memberName = req.getParameter("memberName");

        Integer page = Integer.valueOf(req.getParameter("page"));

        Integer limit = Integer.valueOf(req.getParameter("limit"));


        PetDao petDao=new PetDaoImpl();

        Integer count = petDao.count(memberName);

        List<Pet> pet = petDao.queryPet(page, limit, memberName);
        TableResult tableResult = new TableResult(0, "suc", count, pet);

        String communityJsonStr = JSON.toJSONString(tableResult);

        out.print(communityJsonStr);


    }
}
