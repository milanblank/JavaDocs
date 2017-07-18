package ro.teamnet.zth.web;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.Enumeration;
/**
 * Created by Milan.Stojiljkovic on 7/18/2017.
 */
public class ZeroToHeroServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        resp.getWriter().write(handleRequest(req));
    }

    private String handleRequest(HttpServletRequest req){

//        Enumeration<String> parameterNames = req.getParameterNames();
        String response = "Hello <b>" + req.getParameter("firstName") + " "
                + req.getParameter("lastName") + "</b>! Enjoy Zero To Hero!!!";
        return response;
    }
}
