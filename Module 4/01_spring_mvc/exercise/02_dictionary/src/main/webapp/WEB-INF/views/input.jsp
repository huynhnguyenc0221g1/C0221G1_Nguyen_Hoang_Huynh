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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Dictionary</title>
</head>
<body>
<h2>English to Vietnamese Dictionary</h2>
<form method="post">
    <p>Input an English word: </p>
    <input type="text" name="english" />
    <input type="submit" value="Translate">
    <hr>
    <h2><span style="color: dodgerblue">${vietnamese}</span></h2>
</form>
</body>
</html>
