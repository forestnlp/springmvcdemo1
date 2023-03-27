<%--
  Created by IntelliJ IDEA.
  User: jay
  Date: 2023/3/27
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.get("testAjax", {pname: "晓明", page: "10"}, function (data) {
                    console.log(data.petName)
                    console.log(data.petType)
                })
            })
        })
    </script>
</head>
<body>
<input id="btn" type="button" value="testJSON">
</body>
</html>
