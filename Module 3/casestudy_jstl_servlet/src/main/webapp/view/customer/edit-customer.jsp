<%--
  Created by IntelliJ IDEA.
  User: huynhnguyen
  Date: 5/30/21
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Customer</title>
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
    <h1>Edit Customer</h1>
    <a href="/customer">Back to Customers List</a>
    <div class="container">
        <c:if test="${message!=null}">
            <p>${message}</p>
        </c:if>
        <form method="post">
            <div class="form-group">
                <label></label>
                <input pattern="^KH-[\d]{4}$" title="KH-XXXX" hidden type="text" value="${customer.id}" name="id" class="form-control"
                       placeholder="${customer.id}">
            </div>
            <div class="form-group">
                <label >Customer's Code (Format: KH-XXXX)</label>
                <input type="text" class="form-control" name="code" value="${customer.code}"
                       placeholder="${customer.code}">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput1">Customer's Type:</label>
                <select name="type_id">
                    <c:forEach var="type" items="${customerTypes}">
                        <c:choose>
                            <c:when test="${type.id == customer.typeId}">
                                <option value="${type.id}" selected>${type.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${type.id}">${type.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput3">Customer's Name</label>
                <input type="text" class="form-control" name="name" value="${customer.name}" id="formGroupExampleInput1"
                       placeholder="${customer.name}">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput3">Customer's Birthdate</label>
                <input type="text" class="form-control" name="birthdate" value="${customer.birthdate}" id="formGroupExampleInput3"
                       placeholder="${customer.birthdate}">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput5">Customer's Gender</label>
                <select name="gender" id="gender" class="form-control">
                    <option value="0"  ${customer.gender==0?"selected":""}>Male</option>
                    <option value="1"  ${customer.gender==1?"selected":""}>Female</option>
                </select>
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput6">Customer's ID Card Number (Format: 9 or 12 digits)</label>
                <input pattern="(^[0-9]{9}$)|(^[0-9]{12}$)" title="9 or 12 digits" type="text" class="form-control" name="id_number" value="${customer.idNumber}"
                       id="formGroupExampleInput5"
                       placeholder="${customer.idNumber}">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput7">Customer's Phone Number (Format: 090xxxxxxx | 091xxxxxxx | (84)+90xxxxxxx |(84)+91xxxxxxx)</label>
                <input pattern="(^0(90|91)[0-9]{7}$)|(^[(]84[)][+](90|91)[0-9]{7}$)" title="090xxxxxxx | 091xxxxxxx | (84)+90xxxxxxx |(84)+91xxxxxxx" type="text" class="form-control" name="phone_number" value="${customer.phoneNumber}"
                       id="formGroupExampleInput6"
                       placeholder="${customer.phoneNumber}">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput8">Customer's Email</label>
                <input type="email" class="form-control" name="email" value="${customer.email}"
                       id="formGroupExampleInput7"
                       placeholder="${customer.email}">
            </div>
            <div class="form-group">
                <label>Customer's Address</label>
                <input type="text" class="form-control" name="address" value="${customer.address}"
                       id="formGroupExampleInput8"
                       placeholder="${customer.address}">
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
