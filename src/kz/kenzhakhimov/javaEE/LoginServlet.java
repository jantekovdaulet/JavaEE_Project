package kz.kenzhakhimov.javaEE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Blog> blogs = DBManager.getAllBlogs();
        request.setAttribute("blogs", blogs);
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect = "/login?emailError";
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = DBManager.getUser(email);
        if(user != null){
            redirect = "/login?passwordError";
            if(user.getPassword().equals(password)){
                redirect = "/login?success";
                request.getSession().setAttribute("currentUser",user);
            }
        }
        response.sendRedirect(redirect);
    }
}
