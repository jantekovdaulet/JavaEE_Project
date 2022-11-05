<%@ page import="kz.kenzhakhimov.javaEE.Admin" %><%--
  Created by IntelliJ IDEA.
  User: Даулет
  Date: 17.10.2022
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    Неверный email
</div>
<%
    }
%>
<%
    String error2 = request.getParameter("passwordError");
    if (error2 != null) {
%>
<div class="alert alert-danger alert-dismissible fade show">
    Неверный password
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
                            <a class="nav-link active" aria-current="page" href="/admin">Home</a>
                        </li>
                    </ul>
                    <%
                        Admin currentAdmin = (Admin) request.getSession().getAttribute("currentAdmin");
                        if (currentAdmin == null) {
                    %>
                    <form action="/admin" method="post" class="d-flex" role="search">
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
    <div>
        <%
            if (currentAdmin != null) {
        %>
        <div style="width: 50vw; display: flex; justify-content: center">
            <form action="/deleteuser" method="post" class="d-flex" role="search">
                <input class="form-control me-2 email" type="text" placeholder="email" aria-label="Search"
                       name="email">
                <button onclick="reg()" class="btn btn-outline-success moibtn" type="submit">DELETE</button>
            </form>
        </div>
        <br><br>
        <div style="width: 50vw; display: flex; justify-content: center">
            <form action="/saveuser" method="post" class="d-flex" role="search">
                <input class="form-control me-2 email" type="text" placeholder="email" aria-label="Search"
                       name="email">
                <input class="form-control me-2 email" type="text" placeholder="password" aria-label="Search"
                       name="password">
                <input class="form-control me-2 email" type="text" placeholder="city" aria-label="Search"
                       name="city">
                <button onclick="reg()" class="btn btn-outline-success moibtn" type="submit">UPDATE</button>
            </form>
        </div>
        <%
            }
        %>
    </div>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
<script src="inp.js"></script>
</body>
</html>