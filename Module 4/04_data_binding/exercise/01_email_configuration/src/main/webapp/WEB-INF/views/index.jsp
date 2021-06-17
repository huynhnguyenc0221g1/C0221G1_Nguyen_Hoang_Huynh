<%--
  Created by IntelliJ IDEA.
  User: huynhnguyen
  Date: 17/06/2021
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 class="text-danger">Setting</h2>
<div>
    <form:form action="/addEmail" method="post" modelAttribute="email">
        <table>
            <tr>
                <td>Language:</td>
                <td><form:select name="language" id="language" path="language">
                    <option value="English">English</option>
                    <option value="Vietnamese">Vietnamese</option>
                    <option value="Japanese">Japanese</option>
                    <option value="Chinese">Chinese</option>

                </form:select></td>
            </tr>
            <tr>
                <td>Size:</td>
                <td><form:select name="size" id="size" path="size">
                    <option value="5">5</option>
                    <option value="10">10</option>
                    <option value="15">15</option>
                    <option value="25">25</option>
                    <option value="50">50</option>
                    <option value="100">100</option>

                </form:select></td>
            </tr>
            <tr>
                <td>Spams filter:</td>
                <td><form:checkbox path="filter"/> Enable Spams Filter</td>
            </tr>
            <tr>
                <td>Signature:</td>
                <td><form:textarea path="signature"/></td>
            </tr>
            <tr>

                <td><input type="submit" value="Submit"/></td>
                <td><input type="button" value="Cancel"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
