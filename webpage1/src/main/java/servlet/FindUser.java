//package servlet;
//
//import entity.User;
//import service.UserService;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//
//@WebServlet(
//        name = "FindUser",
//        urlPatterns = {"/FindUser"}
//)
//public class FindUser extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        UserService userService = new UserService();
//        response.setContentType("text/html");
//        String id = request.getParameter("Id");
//        User byId = userService.findById(Integer.parseInt(id));
////        Integer i = ;
//
//
//
//        PrintWriter out = response.getWriter();
////        out.println("<html>\n"+
////                id+
////                "</html>");
//
//        out.println("<html>\n" +
//                "    <ul>\n" +
//                "          <li>\n"+byId.getName()+"</li>\n" +
//                "          <li>\n"+byId.getUsername()+"</li>\n" +
//                "          <li>\n"+byId.getPassword()+"</li>\n" +
//                "      </ul>\n" +
//                "</html>");
//    }
//}
