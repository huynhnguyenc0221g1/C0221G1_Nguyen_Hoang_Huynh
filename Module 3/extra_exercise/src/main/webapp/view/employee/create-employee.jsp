<%--
  Created by IntelliJ IDEA.
  User: huynhnguyen
  Date: 5/30/21
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creat Employee</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<div class="container-fluid col-lg-12 col-sm-12">
    <nav class="navbar navbar-expand-lg navbar-light">
        <div class="col-lg-11 col-sm-10">
            <a class="navbar-brand" href="../view/main/main.jsp"><img class="mb-1" src="../image/furama.png" style="width: auto;height: 2.5rem"/></a>
        </div>
        <div class="col-lg-1 justify-content-end">
            <a class="text-muted link-dark mr-4" href="#">Profile</a>
        </div>
    </nav>
</div>
<div class="container-fluid col-lg-12 col-sm-12 align-content-center">
    <nav class="navbar navbar-dark bg-success navbar-expand-lg">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown px-4">
                    <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown-1" role="button"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Employee
                    </a>
                    <div class="dropdown-menu bg-light" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/employee">List Employee </a>
                        <a class="dropdown-item" href="/employee?action=create">Create Employee </a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
</div>
<div class="container">
    <h1>Create Employee</h1>
    <a href="/employee">Back to Employees List</a>
    <div class="container">
        <c:if test="${message!=null}">
            <h4 class="text-success">${message}</h4>
        </c:if>
        <c:if test="${message_error!=null}">
            <h4 class="text-danger">${message_error}</h4>
        </c:if>
        <form method="post">
            <div class="form-group">
                <label>Employee's ID:</label>
                <input type="text" required value="${employee.id}" title="Must not be empty" name="id" class="form-control"
                       placeholder="${employee.id}">
            </div>
            <div class="form-group">
                <label>Employee's Name</label>
                <input type="text" required pattern="\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+" class="form-control" name="name" title="Must not contain special character or number" value="${employee.name}"
                       placeholder="${employee.name}">
            </div>
            <div class="form-group">
                <label>Employee's Birthdate</label>
                <input type="date" required class="form-control" id="dob" name="birthdate" value="${employee.birthdate}" placeholder="${employee.birthdate}">
            </div>
            <div class="d-fex justify-content-center">
                <input class="btn" type="submit" value="Create Employee">
            </div>
        </form>
    </div>
</div>
<%--<div class="container">--%>
<%--    <h1>Create Employee</h1>--%>
<%--    <a href="/employee">Back to Employees List</a>--%>
<%--    <div class="container">--%>
<%--        <c:if test="${message!=null}">--%>
<%--            <p class="text-success">${message}</p>--%>
<%--        </c:if>--%>
<%--        <c:if test="${message_error!=null}">--%>
<%--            <h4 class="text-danger">${message_error}</h4>--%>
<%--        </c:if>--%>
<%--        <form method="post">--%>
<%--            <fieldset>--%>
<%--                <legend>Employee Information</legend>--%>
<%--                <table>--%>
<%--                    <tr>--%>
<%--                        <td>ID:</td>--%>
<%--                        <td><input type="text" name="id" id="id" value="${employee.id}"></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>Name:</td>--%>
<%--                        <td><input type="text" name="name" id="name" value="${employee.name}"></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>Position:</td>--%>
<%--                        <td>--%>
<%--                            <select name="position_id" class="form-control">--%>
<%--                            <c:forEach var="position" items="${positions}">--%>
<%--                                <option value="${position.id}">${position.name}</option>--%>
<%--                            </c:forEach>--%>
<%--                            </select>--%>
<%--                        </td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>Qualification:</td>--%>
<%--                        <td>--%>
<%--                            <select name="qualification_id" class="form-control">--%>
<%--                            <c:forEach var="qualification" items="${qualifications}">--%>
<%--                                <option value="${qualification.id}">${qualification.name}</option>--%>
<%--                            </c:forEach>--%>
<%--                            </select>--%>
<%--                        </td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>Department:</td>--%>
<%--                        <td>--%>
<%--                            <select name="department_id" class="form-control">--%>
<%--                            <c:forEach var="department" items="${departments}">--%>
<%--                                <option value="${department.id}">${department.name}</option>--%>
<%--                            </c:forEach>--%>
<%--                            </select>--%>
<%--                        </td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>Birthdate:</td>--%>
<%--                        <td><input type="date" name="birthdate" id="birthdate" value="${employee.birthdate}"></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>ID Card Number (Format: 9 or 12 digits):</td>--%>
<%--                        <td><input pattern="(^[0-9]{9}$)|(^[0-9]{12}$)" title="9 or 12 digits" name="id_number" id="id_number" value="${employee.id_number}"></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>Salary:</td>--%>
<%--                        <td><input type="number" min="0" name="salary" id="salary" value="${employee.salary}"></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>Phone Number (Format: 090xxxxxxx | 091xxxxxxx | (84)+90xxxxxxx |(84)+91xxxxxxx):</td>--%>
<%--                        <td><input pattern="(^0(90|91)[0-9]{7}$)|(^[(]84[)][+](90|91)[0-9]{7}$)" title="090xxxxxxx | 091xxxxxxx | (84)+90xxxxxxx |(84)+91xxxxxxx" name="phone_number" id="phone_number" value="${employee.phoneNumber}">--%>
<%--                        </td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>Email:</td>--%>
<%--                        <td><input type="email" name="email" id="email" value="${employee.email}"></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>Address:</td>--%>
<%--                        <td><input type="text" name="address" id="address" value="${employee.address}"></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>Username:</td>--%>
<%--                        <td><input type="text" name="username" id="username" value="${employee.username}"></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td></td>--%>
<%--                        <td><input class="btn btn-success" type="submit" value="Create Employee"></td>--%>
<%--                    </tr>--%>
<%--                </table>--%>
<%--            </fieldset>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--</div>--%>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
    $(function(){
        var dtToday = new Date();

        var month = dtToday.getMonth() + 1;// jan=0; feb=1 .......
        var day = dtToday.getDate();
        var year = dtToday.getFullYear() - 18;
        if(month < 10)
            month = '0' + month.toString();
        if(day < 10)
            day = '0' + day.toString();
        var minDate = year + '-' + month + '-' + day;
        var maxDate = year + '-' + month + '-' + day;
        $('#dob').attr('max', maxDate);
    });
</script>
</html>
