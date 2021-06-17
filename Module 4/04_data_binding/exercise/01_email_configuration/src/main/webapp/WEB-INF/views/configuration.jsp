<%--
  Created by IntelliJ IDEA.
  User: huynhnguyen
  Date: 17/06/2021
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Email's Configuration</h2>
<table>
    <tr>
        <td>Language:</td>
        <td>${language}</td>
    </tr>
    <tr>
        <td>Size:</td>
        <td>${size}</td>
    </tr>
    <tr>
        <td>Filter:</td>
        <c:choose>
            <c:when test="${filter = true}">
                <td>Enable</td>
            </c:when>
            <c:when test="${filter = false}">
                <td>Disable</td>
            </c:when>
        </c:choose>
    </tr>
    <tr>
        <td>Signture:</td>
        <td>${signature}</td>
    </tr>
</table>

</body>
</html>