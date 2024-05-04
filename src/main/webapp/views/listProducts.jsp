<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 5/2/2024
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List products</title>
</head>
<body>
<a href="add">Add product</a>
<table border="1">
    <thead>
    <tr>
        <th>No.</th>
        <th>Product Id</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Image</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listProducts}" var="prod" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${prod.productId}</td>
            <td>${prod.productName}</td>
            <td>${prod.price}</td>
            <td><img src="/uploads/${prod.imgUrl}" width="100" height="100" style="object-fit: cover"></td>
            <td><a href="update?productId=${prod.productId}">Update</a></td>
            <td><a href="delete?productId=${prod.productId}" onclick="return confirm('Bạn có chắc chắn muốn xóa không?')">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
