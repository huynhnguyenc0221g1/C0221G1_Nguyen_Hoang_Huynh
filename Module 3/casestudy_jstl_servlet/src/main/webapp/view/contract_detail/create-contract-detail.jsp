<%--
  Created by IntelliJ IDEA.
  User: huynhnguyen
  Date: 5/30/21
  Time: 6:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creat Contract Detail</title>
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
    <form>
        <div class=" row">
            <div class="col-lg-2"></div>
            <div class="col-lg-8 bg-light">
                <div class="row p-3 bg-light">
                    <div class="col-lg-12 text-center">
                        <h1>Create Contract Detail</h1>
                    </div>
                </div>
                <div class="row p-2 pt-5">
                    <div class="col-lg-3">
                        <label class="font-weight-bold">Contract Detail ID</label>
                    </div>
                    <div class="col-lg-9">
                        <input type="text" name="id">
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-3">
                        <label class="font-weight-bold">Contract</label>
                    </div>
                    <div class="col-lg-9">
                        <select name="contract_id" class="form-control">
                            <c:forEach var="contract" items="${contracts}">
                                <option value="${contract.id}">${contract.id}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-3">
                        <label class="font-weight-bold">Additional Service</label>
                    </div>
                    <div class="col-lg-9">
                        <select name="additional_service_id" class="form-control">
                            <c:forEach var="service" items="${additionalServices}">
                                <option value="${service.id}">${service.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row p-2">
                    <div class="col-lg-3">
                        <label class="font-weight-bold">Amount</label>
                    </div>
                    <div class="col-lg-9">
                        <input type="number" min="0" step="1" name="contractDetailAmount">
                    </div>
                </div>
                <div class="row p-2 align-items-center">
                    <div class="col-lg-5 col-md-4 col-sm-4 "></div>
                    <div class="col-lg-2 col-md-4 col-sm-4 ">
                        <input class="btn btn-success" type="submit" id="submit" value="Create Contract Detail"
                               style="width: 200px">
                    </div>
                    <div class="col-lg-5 col-md-4 col-sm-4 col-xl-4"></div>

                </div>
            </div>
            <div class="col-lg-2"></div>

        </div>
    </form>
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
