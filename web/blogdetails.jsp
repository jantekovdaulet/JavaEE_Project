<%@ page import="kz.kenzhakhimov.javaEE.Blog" %>
<%@ page import="kz.kenzhakhimov.javaEE.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.kenzhakhimov.javaEE.Comment" %>
<%@ page import="kz.kenzhakhimov.javaEE.DBManager" %><%--
  Created by IntelliJ IDEA.
  User: Даулет
  Date: 14.10.2022
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="stylesheet" href="cs.css">
</head>
<body>
<%
    Blog blog = (Blog) request.getAttribute("blog");
    if (blog != null) {
%>
<div>
    <div class="card mb-3">
        <img src="<%=blog.getPicture_url()%>" class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title"><%=blog.getTitle()%>
            </h5>
            <p class="card-text"><%=blog.getTitle()%>
            </p>
            <p class="card-text"><small class="text-muted">Posted by <%=blog.getUser().getEmail()%>
                at <%=blog.getPost_date()%>
            </small></p>
        </div>
    </div>
    <%
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (currentUser != null) {
    %>
    <div class="row mt-2">
        <div class="col-12">
            <form action="/addcomment" method="post">
                <input type="hidden" name="blog_id" value="<%=blog.getId()%>">
                <textarea class="form-control" name="comment" placeholder="Write a comment"></textarea>
                <button class="btn btn-success mt-3">ADD COMMENT</button>
            </form>
        </div>
    </div>
</div>
<%
    }
    ArrayList<Comment> comments = DBManager.getAllComments(blog.getId());
    if (comments != null) {
        for (Comment comment : comments) {
%>
<div class="card row mt-2">
    <div class="col-12">
        <h5><%=comment.getUser().getEmail()%></h5>
        <p><%=comment.getComment()%></p>
        <p>At <strong><%=comment.getPost_date()%></strong></p>
    </div>
</div>
<%
            }
        }
    }
%>
</body>
</html>
