<%--
  Created by IntelliJ IDEA.
  User: eocjf
  Date: 2022-03-01
  Time: 오전 1:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <title>Welcome</title>
</head>
<body>
<nav class="navbar navbar-expand  navbar-dark bg-dark">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="./welcome.jsp">Home</a>
        </div>
    </div>
</nav>
<%! String greeting = "Welcome to Web Shopping Mall";
    String tagline = "Welcome to Web Market!"; %>
<div class="jumbotron">
    <div class="container">
        <h1 class="display-3">
            <%=greeting%>
        </h1>
    </div>
</div>

<div class="container">
    <div class="text-center">
        <h3>
            <%=tagline%>
        </h3>
        <%
            Date day = new java.util.Date();
            String am_pm;
            int hour = day.getHours();
            int minute = day.getMinutes();
            int second = day.getSeconds();
            if (hour / 12 == 0) {
                am_pm = "AM";
            } else {
                am_pm = "PM";
                hour = hour - 12;
            }

            String CT = hour + ":" + minute + ":"+ second +":"+am_pm;
            out.println("현재 접속 시각: " + CT + "\n");
            %>
    </div>
    <hr>
</div>
<footer class="container">
    <p>&copy; WebMarket</p>
</footer>

</body>
</html>