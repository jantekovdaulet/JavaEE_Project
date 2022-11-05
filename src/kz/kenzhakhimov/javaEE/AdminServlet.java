package kz.kenzhakhimov.javaEE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/admin.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect = "/admin?emailError";
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Admin admin = DBManager.getAdmin(email);
        if(admin != null){
            redirect = "/admin?passwordError";
            if(admin.getPassword().equals(password)){
                redirect = "/admin?success";
                request.getSession().setAttribute("currentAdmin", admin);
            }
        }
        response.sendRedirect(redirect);
    }
}
