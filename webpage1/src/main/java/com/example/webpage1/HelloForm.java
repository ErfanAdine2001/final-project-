package com.example.webpage1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name ="HelloForm",
        urlPatterns={"/HelloForm"}
)
public class HelloForm extends HelloServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>\n" +
                "    <ul>\n" +
                "          <li>\n"+request.getParameter("first_name")+"</li>\n" +
                "          <li>\n"+request.getParameter("last_name")+"</li>\n" +
                "      </ul>\n" +
                "</html>");
    }
}
