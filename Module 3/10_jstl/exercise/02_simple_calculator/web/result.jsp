<%--
  Created by IntelliJ IDEA.
  User: huynhnguyen
  Date: 5/27/21
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <h1>Result</h1>
    <p><c:out value="${firstOperandDisplay}"></c:out> <c:out value="${operatorDisplay}"></c:out> <c:out value="${secondOperandDisplay}"></c:out> = <c:out value="${resultDisplay}"></c:out></p>
</body>
</html>
