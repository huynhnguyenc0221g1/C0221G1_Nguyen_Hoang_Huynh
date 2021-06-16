<%--
  Created by IntelliJ IDEA.
  User: huynhnguyen
  Date: 16/06/2021
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Spices List</h1>
<c:forEach var="spice" items="${spicesList}">
    <c:out value="${spice}"/>
    <br>
</c:forEach>
</body>
</html>
