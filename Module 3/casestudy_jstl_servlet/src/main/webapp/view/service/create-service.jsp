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
    <title>Creat Service</title>
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
    <h1>Create Service</h1>
    <div class="container">
        <c:if test="${message!=null}">
            <p class="text-success">${message}</p>
        </c:if>
        <form method="post">
            <fieldset>
                <legend>Service Information</legend>
                <table>
                    <tr>
                        <td>ID:</td>
                        <td><input type="text" name="id" id="id" value="${service.id}"></td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name" id="name" value="${service.name}"></td>
                    </tr>
                    <tr>
                        <td>Area:</td>
                        <td><input type="text" name="area" id="area" value="${service.area}"></td>
                    </tr>
                    <tr>
                        <td>Cost:</td>
                        <td><input type="text" name="cost" id="cost" value="${service.cost}"></td>
                    </tr>
                    <tr>
                        <td>Max In House:</td>
                        <td><input type="text" name="max_in_house" id="max_in_house" value="${service.maxInHouse}"></td>
                    </tr>
                    <tr>
                        <td>Rent Option:</td>
                        <td>
                            <select  name="rent_option_id" class="form-control">
                                <c:forEach var="option" items="${rentOptions}">
                                    <option value="${option.id}">${option.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Service Type:</td>
                        <td>
                            <select  name="service_type_id" class="form-control">
                                <c:forEach var="type" items="${serviceTypes}">
                                    <option value="${type.id}">${type.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Room Standard:</td>
                        <td><input type="text" name="standard" id="standard" value="${service.standard}"></td>
                    </tr>
                    <tr>
                        <td>Other Convenience Description:</td>
                        <td><input type="text" name="description" id="description" value="${service.description}"></td>
                    </tr>
                    <tr>
                        <td>Pool Area:</td>
                        <td><input type="text" name="pool_area" id="pool_area" value="${service.poolArea}"></td>
                    </tr>
                    <tr>
                        <td>Number Of Floors:</td>
                        <td><input type="text" name="number_of_floors" id="number_of_floors" value="${service.numberOfFloors}"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input class="btn btn-success" type="submit" value="Create Service"></td>
                    </tr>
                </table>
            </fieldset>
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