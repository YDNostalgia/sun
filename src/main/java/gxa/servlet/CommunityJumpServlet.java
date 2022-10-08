package gxa.servlet;




import gxa.entity.Community;
import gxa.service.CommunityService;
import gxa.service.impl.CommunityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/page/community/jump")
public class CommunityJumpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");
        HttpSession session= req.getSession();

        String val= req.getParameter("id");
        int id= Integer.parseInt(val);


        CommunityService communityService=new CommunityServiceImpl();
        Community community = communityService.queryById(id);

        session.setAttribute("id",community.getId());
        session.setAttribute("number",community.getNumber());
        session.setAttribute("name",community.getName());
        session.setAttribute("address",community.getAddress());
        session.setAttribute("buildings",community.getBuildings());
        session.setAttribute("householders",community.getHouseholders());
        session.setAttribute("thumbnail",community.getThumbnail());
        session.setAttribute("property",community.getProperty());

        req.getRequestDispatcher("edit.jsp").forward(req,resp);
    }
}
