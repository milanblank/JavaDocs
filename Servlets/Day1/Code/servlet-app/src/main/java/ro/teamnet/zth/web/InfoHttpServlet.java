package ro.teamnet.zth.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Enumeration;

/**
 * Created by Milan.Stojiljkovic on 7/18/2017.
 */
public class InfoHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        resp.getWriter().write(tableFromHeaders(req));
    }

    private String tableFromHeaders(HttpServletRequest req){
        StringBuilder sb = new StringBuilder();

        sb.append("<HTML><HEAD>");

        sb.append("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");

        sb.append("</HEAD><BODY>");

        sb.append("<B>Request Method: </B>" +
                req.getMethod() + "<BR>\n" +
                "<B>Request URI: </B>" +
                req.getRequestURI() + "<BR>\n" +
                "<B>Request Protocol: </B>" +
                req.getProtocol() + "<BR><BR>\n");

        sb.append("<Table class=\"table table-bordered\">");


        sb.append("<TR><TH>Header Name</TH><TH>Header Value</TH></TR>");

        Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            sb.append("<TR><TD>" + headerName + "</TD>");
            sb.append("<TD>" + req.getHeader(headerName) + "</TD></TR>");
        }
        sb.append("</TR>");
        sb.append("<TR><TD> Query String </TD><TD>"  + req.getQueryString() + "</TD></TR>");

        sb.append("</TABLE></BODY></HTML>");


        return sb.toString();

    }
}
