package gxa.servlet;


import com.alibaba.fastjson.JSON;
import gxa.entity.Community;
import gxa.service.CommunityService;
import gxa.service.impl.CommunityServiceImpl;
import gxa.utils.Result;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/page/community/add")
public class CommunityAddServlet extends HttpServlet {

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
        String number = req.getParameter("number");
        String name=req.getParameter("name");
        String address=req.getParameter("address");
        String buildings=req.getParameter("buildings");
        String householders=req.getParameter("householders");
        System.out.println(householders);
        String thumbnail=req.getParameter("thumbnail");
        String property=req.getParameter("property");

        //直接新建一个TImestamp用于接受返回值
        Timestamp time = getTimeNow();
        System.out.println(time);
        Community community =new Community(number,name,address,buildings,householders,thumbnail,property,time);
        System.out.println(community);

        CommunityService communityService=new CommunityServiceImpl();
        communityService.save(community);

        Result result = new Result(0,"success",null);
        String jsonStr = JSON.toJSONString(result);
        out.print(jsonStr);


    }

    public Timestamp getTimeNow(){
        Date d = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNow = simpleDateFormat.format(d);
        return Timestamp.valueOf(dateNow);
    }

}

