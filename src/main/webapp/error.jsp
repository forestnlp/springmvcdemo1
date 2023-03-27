<%--
  Created by IntelliJ IDEA.
  User: jay
  Date: 2023/3/27
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="color: red">
<%
    out.println(request.getAttribute("fromhandler"));
    out.println(request.getAttribute("msg"));
%>
</h1>
</body>
</html>
