<%--
  Created by IntelliJ IDEA.
  User: fakoro.traore
  Date: 01/06/2024
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String email = request.getParameter("email");
  String motDePasse = request.getParameter("motDePasse");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1><%=email%></h1>
  <h2><%=motDePasse%></h2>
</body>
</html>
