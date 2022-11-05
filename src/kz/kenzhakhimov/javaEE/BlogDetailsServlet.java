package kz.kenzhakhimov.javaEE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/blogdetails")
public class BlogDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Blog blog = DBManager.getBlog(id);
        request.setAttribute("blog", blog);
        if(blog != null){
            ArrayList<Comment> comments = DBManager.getAllComments(blog.getId());
            request.setAttribute("comments", comments);
        }
        request.getRequestDispatcher("/blogdetails.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
