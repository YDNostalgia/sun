package gxa.servlet;


import com.alibaba.fastjson.JSON;
import gxa.entity.Car;
import gxa.service.CarService;
import gxa.service.impl.CarServiceImpl;
import gxa.utils.Result;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/page/car/update")
public class CarUpdateServlet extends HttpServlet {

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
        String carColor = req.getParameter("carColor");
        String carNumber = req.getParameter("carNumber");
        String note = req.getParameter("note");


        Car car=new Car(id,photo,memberName,carColor,carNumber,note);

        CarService carService=new CarServiceImpl();
        carService.update(car);

        Result result = new Result(0,"success",null);
        String jsonStr = JSON.toJSONString(result);
        out.print(jsonStr);


    }



}

