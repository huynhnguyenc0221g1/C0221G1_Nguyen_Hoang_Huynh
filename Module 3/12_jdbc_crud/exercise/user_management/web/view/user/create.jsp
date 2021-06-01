<%--
  Created by IntelliJ IDEA.
  User: huynhnguyen
  Date: 6/2/2021
  Time: 3:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Create User</h1>
    <a href="/">Back to list</a>
    <div class="container">
        <c:if test="${message!=null}">
            <p class="text-success">${message}</p>
        </c:if>
        <form method="post">
            <fieldset>
                <legend>User Information</legend>
                <table>
                    <tr>
                        <td>Name:</td>
                        <td><input  type="text" name="name" id="name" value="${user.name}"></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input  type="text" name="email" id="email" value="${user.email}"></td>
                    </tr>
                    <tr>
                        <td>Country:</td>
                        <td><input  type="text" name="country" id="country" value="${user.country}"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input class="btn btn-success" type="submit" value="Create User"></td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>
</html>

