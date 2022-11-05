package kz.kenzhakhimov.javaEE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addblog")
public class AddBlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User)req.getSession().getAttribute("currentUser");
        if(currentUser != null){
            req.getRequestDispatcher("/addblog.jsp").forward(req,resp);
        }
        else{
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "/login";
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String picture_url = req.getParameter("picture_url");
        User currentUser = (User)req.getSession().getAttribute("currentUser");
        if(currentUser != null){
            Blog blog = new Blog();
            blog.setTitle(title);
            blog.setContent(content);
            blog.setPicture_url(picture_url);
            blog.setUser(currentUser);
            if(DBManager.addBlog(blog)){
                redirect = "/login";
            }
        }
        resp.sendRedirect(redirect);
    }
}
