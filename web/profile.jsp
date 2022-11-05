<%@ page import="org.postgresql.shaded.com.ongres.scram.common.util.UsAsciiUtils" %>
<%@ page import="kz.kenzhakhimov.javaEE.User" %><%--
  Created by IntelliJ IDEA.
  User: Даулет
  Date: 01.10.2022
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="cs.css">
</head>
<body id="profile-main">
<%
    User user = (User) request.getSession().getAttribute("currentUser");
    if (user != null) {
%>
<div class="infoBlock">
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">My profile
            </h5>
            <p class="card-text">Email: <%=user.getEmail()%>
            </p>
            <p class="card-text">City: <%=user.getCity()%>
            </p>
        </div>
    </div>
</div>
<%
    }
%>
</body>
</html>
