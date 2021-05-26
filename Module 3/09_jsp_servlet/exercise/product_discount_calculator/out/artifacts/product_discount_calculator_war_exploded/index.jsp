<%--
  Created by IntelliJ IDEA.
  User: huynhnguyen
  Date: 5/26/21
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/display-discount" method="post">
    <p>Product Description:</p>
    <input type="text" name="product_description" placeholder="Product Description: "/>
    <br>
    <p>List Price:</p>
    <input type="text" name="list_price" placeholder="List Price: "/>
    <br>
    <p>Discount Percent:</p>
    <input type="text" name="discount_percent" placeholder="Discount Percent:"/>
    <br>
    <br>
    <input style="size:30px" type = "submit" id = "submit" value = "Display Discount"/>
  </form>
  </body>
</html>
