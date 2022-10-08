package gxa.servlet;


import com.alibaba.fastjson.JSON;
import gxa.entity.User;
import gxa.service.PetService;
import gxa.service.UserService;
import gxa.service.impl.PetServiceImpl;
import gxa.service.impl.UserServiceImpl;
import gxa.utils.Result;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/user/register")
public class UserAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        //接收参数
        String idNumber = req.getParameter("idNumber");
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");

        User user=new User(idNumber,username,pwd);

        UserService userService=new UserServiceImpl();
        userService.save(user);

        Result result = new Result(0,"success",null);
        String jsonStr = JSON.toJSONString(result);
        System.out.println(jsonStr);
        out.print(jsonStr);


    }


}

