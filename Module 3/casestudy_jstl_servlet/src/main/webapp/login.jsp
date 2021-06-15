<%--
  Created by IntelliJ IDEA.
  User: huynhnguyen
  Date: 11/06/2021
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Form Login</title>
</head>
<body>
<div style="width: 500px; margin: 50px auto;background:#D0D01A;padding:30px">
    <h2>Login:</h2>
    <c:if test="${error != null}">
        <p style='color:red'>Wrong username or id</p>
    </c:if>
    <form method="post" >
        <div>
            <label>Username: </label>
            <input type="text" name="username" value="" />
        </div>
        <br />
        <div>
            <label>Password: </label>
            <input type="password" name="password" value="" />
        </div>
        <br />
        <div>
            <input type="submit" name="submit" value="Login" />
            <input type="reset" name="reset" value="Reset" />
        </div>
    </form>
</div>
</body>
</html>