<%--
  Created by IntelliJ IDEA.
  User: huynhnguyen
  Date: 15/06/2021
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Exchange - USD to VND</title>
</head>
<body>
<h2>Currency Exchange - USD to VND</h2>
<form method="post">
    <p>Input USD amount: </p>
    <input type="text" name="amount" />
    <p>Input USD-VND rate: </p>
    <input type="text" name="rate" />
    <p></p>
    <input type="submit" value="Convert">
    <hr>
    <h2><span style="color: dodgerblue">${VND}</span></h2>
</form>
</body>
</html>
