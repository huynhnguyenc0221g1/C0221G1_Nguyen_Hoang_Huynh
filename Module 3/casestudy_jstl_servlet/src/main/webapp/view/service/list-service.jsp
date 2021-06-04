<%--
  Created by IntelliJ IDEA.
  User: huynhnguyen
  Date: 5/30/21
  Time: 6:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Service List</title>
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
                        <a class="dropdown-item" href="../../view/contract_detail/list-contract-detail.jsp">List
                            Contract Detail</a>
                        <a class="dropdown-item" href="../../view/contract_detail/create-contract-detail.jsp">Create
                            Contract Detail</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
</div>
<div class="row ml-4 mt-4">
    <div class="col-lg-6">
        <h5>Service Management</h5>
    </div>
    <div class="col-lg-6">
        <h5>
            <a href="/service?action=create">Add New Service</a>
        </h5>
    </div>
</div>
<div align="center">
    <table id="serviceTable" class="table table-striped" border="1" cellpadding="5">
        <thead>
        <tr>
            <th>No</th>
            <th>ID</th>
            <th>Name</th>
            <th>Area</th>
            <th>Cost</th>
            <th>Max In House</th>
            <th>Rent Option ID</th>
            <th>Service Type ID</th>
            <th>Standard</th>
            <th>Other Convenience Description</th>
            <th>Pool Area</th>
            <th>Number of Floors</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="service" items="${services}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${service.id}</td>
                <td>${service.name}</td>
                <td>${service.area}</td>
                <td>${service.cost}</td>
                <td>${service.maxInHouse}</td>
                <td>${service.rentTypeId}</td>
                <td>${service.serviceTypeId}</td>
                <td>${service.standard}</td>
                <td>${service.description}</td>
                <td>${service.poolArea}</td>
                <td>${service.numberOfFloors}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
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
<script src="${pageContext.request.contextPath}/jquery/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/datatables/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function() {
        $('#serviceTable').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );

</script>
</html>