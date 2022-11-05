package kz.kenzhakhimov.javaEE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addcomment")
public class AddCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "/login";
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        if (currentUser != null) {
            String commentText = req.getParameter("comment");
            Long blogId = Long.parseLong(req.getParameter("blog_id"));
            Blog blog = DBManager.getBlog(blogId);
            if (blog != null) {
                Comment comment = new Comment();
                comment.setComment(commentText);
                comment.setBlog(blog);
                comment.setUser(currentUser);
                if (DBManager.addComment(comment)) {
                    redirect = "/blogdetails?id=" + blogId;
                }
            }
        }
        resp.sendRedirect(redirect);
    }
}
