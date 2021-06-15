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
    <title>Creat Product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<div class="container-fluid col-lg-12 col-sm-12 align-content-center">
    <nav class="navbar navbar-dark bg-success navbar-expand-lg">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown px-4">
                    <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown-1" role="button"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Product
                    </a>
                    <div class="dropdown-menu bg-light" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/product">Products List </a>
                        <a class="dropdown-item" href="/product?action=create">Create Product </a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
</div>
<div class="container pt-5">
    <h1>Create Product</h1>
    <a href="/product">Back to Products List</a>
    <div class="container pt-5">
        <c:if test="${message!=null}">
            <h4 class="text-success">${message}</h4>
        </c:if>
        <c:if test="${message_error!=null}">
            <h4 class="text-danger">${message_error}</h4>
        </c:if>
        <form method="post">
            <div class="form-group">
                <label>Product's ID:</label>
                <input type="text" required value="${product.id}" title="Must not be empty" name="id" class="form-control"
                       placeholder="${product.id}">
            </div>
            <div class="form-group">
                <label>Product's Name:</label>
                <input type="text" required class="form-control" name="name" value="${product.name}"
                       placeholder="${product.name}">
            </div>
            <div class="form-group">
                <label>Product's Price:</label>
                <input type="number" required min="0" class="form-control" name="price" value="${product.price}" placeholder="${product.price}">
            </div>
            <div class="form-group">
                <label>Product's Quantity:</label>
                <input type="number" step="1" min="0"  class="form-control" name="quantity" value="${product.quantity}" placeholder="${product.quantity}">
            </div>
            <div class="form-group">
                <label>Product's Color:</label>
                <input type="text" required class="form-control" name="color" value="${product.color}"
                       placeholder="${product.color}">
            </div>
            <div class="form-group">
                <label>Product's Description:</label>
                <input type="text" required class="form-control" name="description" value="${product.description}"
                       placeholder="${product.description}">
            </div>
            <div class="form-group">
                <label>Product's Description:</label>
                <select name="category_id" class="form-control">
                    <c:forEach var="category" items="${categories}">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="d-fex justify-content-center">
                <input class="btn" type="submit" value="Create Product">
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</html>
