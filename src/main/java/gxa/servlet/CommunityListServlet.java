package gxa.servlet;

import com.alibaba.fastjson.JSON;
import gxa.entity.Community;
import gxa.service.CommunityService;
import gxa.service.impl.CommunityServiceImpl;
import gxa.utils.TableResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/page/community/list")
public class CommunityListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String number = req.getParameter("number");
        System.out.println(number);
        Integer page = Integer.valueOf(req.getParameter("page"));
        System.out.println(page);
        Integer limit = Integer.valueOf(req.getParameter("limit"));
        System.out.println(limit);

        CommunityService communityService=new CommunityServiceImpl();

        Integer count = communityService.count(number);

        List<Community> communities = communityService.queryCommunities(page,limit,number);
        TableResult tableResult = new TableResult(0,"suc",count,communities);
        System.out.println(tableResult);
        String communityJsonStr = JSON.toJSONString(tableResult);

        out.print(communityJsonStr);


    }
}
