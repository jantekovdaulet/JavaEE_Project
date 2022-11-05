<%--
  Created by IntelliJ IDEA.
  User: sultanbekkenzhakhimov
  Date: 26.09.2022
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>WEBPAGE</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="stylesheet" href="cs.css">
</head>
<body>
<div class="mainDiv">
    <div class="headeru">
        <nav class="navbar navbar-expand-lg bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">TECHNOHOUSE</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Link</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Dropdown
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="https://www.youtube.com">YOUTUBE</a></li>
                                <li><a class="dropdown-item" href="">FACEBOOK</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled">Disabled</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Sign up</a>
                        </li>
                    </ul>

                    <form action="/register" method="post" class="d-flex" role="search">
                        <input class="form-control me-2 email" type="text" placeholder="email" aria-label="Search" name="email">
                        <br>
                        <input class="form-control me-2 password" type="text" placeholder="password" aria-label="Search" name="password">
                        <br>
                        <input class="form-control me-2 email" type="text" placeholder="city" aria-label="Search" name="city">
                        <br>
                        <button onclick="reg()" class="btn btn-outline-success moibtn" type="submit">Register</button>
                    </form>
                </div>
            </div>
        </nav>
    </div>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
<script src="inp.js"></script>
</body>
</html>

