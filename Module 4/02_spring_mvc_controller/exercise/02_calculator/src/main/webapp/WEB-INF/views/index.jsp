<%--
  Created by IntelliJ IDEA.
  User: huynhnguyen
  Date: 16/06/2021
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Calculator</title>
</head>
<body>
  <form action="/calculator" method="post">
    <h1>Calculator</h1>
    <br>
    <p>Number 1:</p>
      <input class="input" type="text" name="number1" value="${number1}">
    <br>
    <p>Number 2:</p>
      <input class="input" type="text" name="number2" value="${number2}">
    <br>
    <p class="result">Result : ${result}</p>
    <br>
    <br>
      <input type="submit" name="operation" value="Addition">
      <input type="submit" name="operation" value="Subtraction">
      <input type="submit" name="operation" value="Multiplication">
      <input type="submit" name="operation" value="Division">
  </form>
</div>
</body>
</html>