<%@ page import="kz.kenzhakhimov.javaEE.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.concurrent.BlockingDeque" %>
<%@ page import="kz.kenzhakhimov.javaEE.Blog" %><%--
  Created by IntelliJ IDEA.
  User: Даулет
  Date: 23.09.2022
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>WEBPAGE</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="stylesheet" href="cs.css">
</head>
<body>
<%
    String error = request.getParameter("emailError");
    if (error != null) {
%>
<div class="alert alert-danger alert-dismissible fade show">
    Вы не авторизованный пользователь. Неверный email
</div>
<%
    }
%>
<%
    String error2 = request.getParameter("passwordError");
    if (error2 != null) {
%>
<div class="alert alert-danger alert-dismissible fade show">
    Вы не авторизованный пользователь. Неверный password
</div>
<%
    }
%>
<%
    String success = request.getParameter("success");
    if (success != null) {
%>
<div class="alert alert-success alert-dismissible fade show">
    Успешная авторизация!
</div>
<%
    }
%>
<div class="mainDiv">
    <div class="headeru">
        <nav class="navbar navbar-expand-lg bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">TECHNOHOUSE</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0" id="navbar-login">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/login">Home</a>
                        </li>
                        <%
                            User currentUser = (User) request.getSession().getAttribute("currentUser");
                            if (currentUser != null) {
                        %>
                        <li class="nav-item">
                            <a class="nav-link" href="/profile?email=<%out.print(currentUser.getEmail());%>">My
                                profile</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/addblog">Add blog</a>
                        </li>
                        <li class="nav-item" style="margin-top: 7px; margin-left: 950px ;">
                            <span class="badge rounded-pill text-bg-success">Online</span>
                        </li>
                        <%
                            }
                            if (currentUser == null) {
                        %>
                        <li class="nav-item">
                            <a class="nav-link" href="/register">Sign up</a>
                        </li>
                        <%
                            }
                        %>
                    </ul>
                    <%
                        if (currentUser == null) {
                    %>
                    <form action="/login" method="post" class="d-flex" role="search">
                        <input class="form-control me-2 email" type="text" placeholder="email" aria-label="Search"
                               name="email">
                        <input class="form-control me-2 password" type="text" placeholder="password" aria-label="Search"
                               name="password">
                        <button onclick="reg()" class="btn btn-outline-success moibtn" type="submit">LOGIN</button>
                    </form>
                    <%
                        }
                    %>
                </div>
            </div>
        </nav>
    </div>
    <%
        ArrayList<Blog> blogs = (ArrayList<Blog>) request.getAttribute("blogs");
        if (currentUser != null) {
    %>
    <div class="infoBlock">
        <%
            if (blogs != null) {
                for (Blog blog : blogs) {
        %>
        <div class="card" style="width: 18rem;">
            <img src="<%=blog.getPicture_url()%>" class="card-img-top svoiimg" alt="...">
            <div class="card-body">
                <h5 class="card-title"><%=blog.getTitle()%>
                </h5>
                <p class="card-text"><%=blog.getContent()%>
                </p>
                <a href="/blogdetails?id=<%=blog.getId()%>" class="btn btn-primary">Go somewhere</a>
                <p class="card-text"><%=blog.getUser().getEmail()%>
                </p>
                <p class="card-text"><%=blog.getPost_date()%>
                </p>
            </div>
        </div>
        <%
            }
        %>
    </div>
    <%
            }
        }
    %>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
<script src="inp.js"></script>
</body>
</html>