package gxa.servlet;


import com.alibaba.fastjson.JSON;
import gxa.entity.User;
import gxa.service.UserService;
import gxa.service.impl.UserServiceImpl;
import gxa.utils.Result;



import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        //接收参数
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");

//        String scode = (String) session.getAttribute("scode");

            UserService userService = new UserServiceImpl();
            User user = userService.login(username, pwd);
            if(user != null){//登录成功
                session.setAttribute("user",user);
                Result result = new Result(0,"success",null);

                String jsonStr = JSON.toJSONString(result);
                out.print(jsonStr);

            }else{
                Result result = new Result(1,"用户名或者密码不正确!",null);

                String jsonStr = JSON.toJSONString(result);
            }

    }
}
