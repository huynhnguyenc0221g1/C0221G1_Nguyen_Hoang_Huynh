<%--
  Created by IntelliJ IDEA.
  User: huynhnguyen
  Date: 16/06/2021
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/save-spices" method="post">
    <h1>Sandwich Condiments</h1>
    <br>
        <input type="checkbox" name="spices" value="Lettuce">Lettuce
        <input type="checkbox" name="spices" value="Tomato">Tomato
        <input type="checkbox" name="spices" value="Mustard">Mustard
        <input type="checkbox" name="spices" value="Sprouts">Sprouts
    <br>
    <br>
        <input type="submit" value="Save Spices">
</form>
</body>
</html>
