package kz.kenzhakhimov.javaEE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/saveuser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "/admin?none";
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String city = req.getParameter("city");
        User checkUser = DBManager.getUser(email);
        Admin currentAdmin = (Admin) req.getSession().getAttribute("currentAdmin");
        if (currentAdmin != null) {
            if (checkUser != null) {
                redirect = "admin?unsuccessSave";
                User user = new User();
                user.setEmail(email);
                user.setPassword(password);
                user.setCity(city);
                if (DBManager.updateUser(checkUser)) {
                    redirect = "/admin?successSave";
                }
            }
        }
        resp.sendRedirect(redirect);
    }
}
