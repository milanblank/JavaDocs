package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Milan.Stojiljkovic on 7/19/2017.
 */
public class HttpSessionLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Cookie[] cookies = req.getCookies();

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();

        if(username.equals("admin") && password.equals("admin")){
            out.write("Welcome back " + username);
            for (Cookie cookie: cookies) {
                out.write("<br/>" + cookie.getName() + " : " + cookie.getValue());
            }
        } else {
            session.setAttribute("username", username );
            session.setAttribute("session", session );
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/loginFail.jsp");

            requestDispatcher.include(req, resp);

        }




//        resp.getWriter().write("username is: " + "<b>"
//        + username + "</b>\n"
//        + "password is: " + "<b>"
//        + password + "</b>");
    }
}
