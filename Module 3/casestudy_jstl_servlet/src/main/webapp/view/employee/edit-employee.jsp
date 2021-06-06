<%--
  Created by IntelliJ IDEA.
  User: huynhnguyen
  Date: 5/30/21
  Time: 6:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Employee</title>
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
        <a class="text-light link-dark mr-4" href="../view/main/main.jsp">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown px-4">
                    <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown" role="button"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Customer
                    </a>
                    <div class="dropdown-menu bg-light" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/customer">List Customer</a>
                        <a class="dropdown-item" href="/customer?action=create">Create Customer</a>
                    </div>
                </li>
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
                <li class="nav-item dropdown px-4">
                    <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown-2" role="button"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Service
                    </a>
                    <div class="dropdown-menu bg-light" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/service?action=create">Create Service</a>
                    </div>
                </li>
                <li class="nav-item dropdown px-4">
                    <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown-3" role="button"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Contract
                    </a>
                    <div class="dropdown-menu bg-light" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/contract?action=create">Create Contract</a>
                    </div>
                </li>
                <li class="nav-item dropdown px-4">
                    <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown-4" role="button"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Contract Detail
                    </a>
                    <div class="dropdown-menu bg-light" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/contract-detail?action=create">Create
                            Contract Detail</a>
                    </div>
                </li>
                <li class="nav-item dropdown px-4">
                    <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown-5" role="button"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Customers With Services
                    </a>
                    <div class="dropdown-menu bg-light" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/customer-with-services">List</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
</div>
<div class="container">
    <h1>Edit Employee</h1>
    <a href="/employee">Back to Employees List</a>
    <div class="container">
        <c:if test="${message!=null}">
            <p>${message}</p>
        </c:if>
        <form method="post">
            <div class="form-group">
                <label for="formGroupExampleInput"></label>
                <input hidden type="text" value="${employee.id}" name="id" class="form-control"
                       id="formGroupExampleInput"
                       placeholder="Example input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput1">Employee's Name</label>
                <input type="text" class="form-control" name="name" value="${employee.name}" id="formGroupExampleInput1"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label>Employee's Position</label>
                <select class="form-control" name="position_id">
                    <c:forEach var="position" items="${requestScope['positions']}">
                        <c:choose>
                            <c:when test="${position.id == employee.positionId}">
                                <option value="${position.id}" selected>${position.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${position.id}">${position.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Employee's Qualification</label>
                <select class="form-control" name="qualification_id">
                    <c:forEach var="qualification" items="${requestScope['qualifications']}">
                        <c:choose>
                            <c:when test="${qualification.id == employee.qualificationId}">
                                <option value="${qualification.id}" selected>${qualification.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${qualification.id}">${qualification.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Employee's Department</label>
                <select class="form-control" name="department_id">
                    <c:forEach var="department" items="${requestScope['departments']}">
                        <c:choose>
                            <c:when test="${department.id == employee.departmentId}">
                                <option value="${department.id}" selected>${department.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${department.id}">${department.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Employee's Birthdate</label>
                <input type="date" class="form-control" name="birthdate" value="${employee.birthdate}">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput6">Employee's ID Card Number</label>
                <input type="text" class="form-control" name="id_number" value="${employee.idNumber}"
                       id="formGroupExampleInput6"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput7">Employee's Salary</label>
                <input type="text" class="form-control" name="salary" value="${employee.salary}"
                       id="formGroupExampleInput7"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput8">Employee's Phone Number</label>
                <input type="text" class="form-control" name="phone_number" value="${employee.phoneNumber}"
                       id="formGroupExampleInput8"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput9">Employee's Email</label>
                <input type="text" class="form-control" name="email" value="${employee.email}"
                       id="formGroupExampleInput9"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput10">Employee's Address</label>
                <input type="text" class="form-control" name="address" value="${employee.address}"
                       id="formGroupExampleInput10"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput11">Employee's Username</label>
                <input type="text" class="form-control" name="username" value="${employee.username}"
                       id="formGroupExampleInput11"
                       placeholder="Another input placeholder">
            </div>
            <div class="d-fex justify-content-center">
                <input class="btn" type="submit" value="update">
            </div>
        </form>
    </div>
</div>
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
</html>
