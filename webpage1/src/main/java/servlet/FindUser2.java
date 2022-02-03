package servlet;

import entity.User;
import lombok.NonNull;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(
        name = "FindUser2",
        urlPatterns = {"/FindUser2"}
)
public class FindUser2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("Id");
        UserService userService = new UserService();
        User user = userService.findById(Integer.parseInt(id));

        if (user != null){
            RequestDispatcher rd = request.getRequestDispatcher("/show-user.jsp");
            request.setAttribute("user",user);
            rd.forward(request,response);
        }
        if(user==null){
            response.sendRedirect("/servlet/formId.html");
        }
    }


    //----------------


    public class RequiredArgsDemo1 {
        private Long id;
        @NonNull
        private String username;
        @NonNull
        private String email;
        private final boolean status;

        public RequiredArgsDemo1(
                @NonNull final String username,
                @NonNull final String email,
                final boolean status
        ) {

            if (username == null) {
                throw new NullPointerException("username is marked non-null but is null");
            }
            if (email == null) {
                throw new NullPointerException("email is marked non-null but is null");
            }
            this.username = username;
            this.email = email;
            this.status = status;
        }
    }

    //----------------

}
