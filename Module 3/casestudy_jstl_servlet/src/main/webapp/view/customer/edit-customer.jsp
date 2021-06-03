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
            <a class="navbar-brand" href="../../view/main/main.jsp"><img class="mb-1" src="../../image/furama.png" style="width: auto;height: 2.5rem"/></a>
        </div>
        <div class="col-lg-1 justify-content-end">
            <a class="text-muted link-dark mr-4" href="#">Profile</a>
        </div>
    </nav>
</div>
<div class="container-fluid col-lg-12 col-sm-12 align-content-center">
    <nav class="navbar navbar-dark bg-success navbar-expand-lg">
        <a class="text-light link-dark mr-4" href="../../view/main/main.jsp">Home</a>
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
                        <a class="dropdown-item" href="../../view/employee/list-employee.jsp">List Employee </a>
                        <a class="dropdown-item" href="../../view/employee/create-employee.jsp">Create Employee </a>
                    </div>
                </li>
                <li class="nav-item dropdown px-4">
                    <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown-2" role="button"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Service
                    </a>
                    <div class="dropdown-menu bg-light" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="../../view/service/list-service.jsp">List Service</a>
                        <a class="dropdown-item" href="../../view/service/create-service.jsp">Create Service</a>
                    </div>
                </li>
                <li class="nav-item dropdown px-4">
                    <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown-3" role="button"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Contract
                    </a>
                    <div class="dropdown-menu bg-light" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="../../view/contract/list-contract.jsp">List Contract</a>
                        <a class="dropdown-item" href="../../view/contract/create-contract.jsp">Create Contract</a>
                    </div>
                </li>
                <li class="nav-item dropdown px-4">
                    <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown-4" role="button"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Contract Detail
                    </a>
                    <div class="dropdown-menu bg-light" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="../../view/contract_detail/list-contract-detail.jsp">List Contract Detail</a>
                        <a class="dropdown-item" href="../../view/contract_detail/create-contract-detail.jsp">Create Contract Detail</a>
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
                <label for="formGroupExampleInput"></label>
                <input hidden type="text" value="${customer.id}" name="id" class="form-control"
                       id="formGroupExampleInput"
                       placeholder="Example input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Customer's Type Id</label>
                <input type="text" value="${customer.typeId}" name="type_id" class="form-control" id="formGroupExampleInput2"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Customer's Name</label>
                <input type="text" class="form-control" name="name" value="${customer.name}" id="formGroupExampleInput1"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Customer's Birthdate</label>
                <input type="text" class="form-control" name="birthdate" value="${customer.birthdate}" id="formGroupExampleInput3"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Customer's Gender</label>
                <input type="text" class="form-control" name="gender" value="${customer.gender}"
                       id="formGroupExampleInput4"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Customer's ID Card Number</label>
                <input type="text" class="form-control" name="id_number" value="${customer.idNumber}"
                       id="formGroupExampleInput5"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Customer's Phone Number</label>
                <input type="text" class="form-control" name="phone_number" value="${customer.phoneNumber}"
                       id="formGroupExampleInput6"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Customer's Email</label>
                <input type="text" class="form-control" name="email" value="${customer.email}"
                       id="formGroupExampleInput7"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Customer's Address</label>
                <input type="text" class="form-control" name="address" value="${customer.address}"
                       id="formGroupExampleInput8"
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
