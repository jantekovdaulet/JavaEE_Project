package kz.kenzhakhimov.javaEE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deleteuser")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "/admin?deleteError";
        String email = req.getParameter("email");
        Admin currentAdmin = (Admin) req.getSession().getAttribute("currentAdmin");
        if (currentAdmin != null) {
            User checkUser = DBManager.getUser(email);
            if (checkUser != null) {
                if (DBManager.deleteUser(email)) {
                    redirect = "/admin";
                }
            }
        }
        resp.sendRedirect(redirect);
    }
}
