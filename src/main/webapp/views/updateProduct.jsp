<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 5/3/2024
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update product</title>
</head>
<body>
<form action="update" method="post" enctype="multipart/form-data">
    <label>Product Id</label>
    <input type="number" name="productId" value="${updateProduct.productId}" readonly><br>
    <label>Product Name</label>
    <input type="text" name="productName" value="${updateProduct.productName}"><br>
    <label>Price</label>
    <input type="number" id="price" name="price" value="${updateProduct.price}"><br>
    <label>Image</label>
    <img src="/uploads/${updateProduct.imageUrl}" height="100" width="100" style="object-fit: cover"><br>
    <input type="file" id="file" name="file"><br>
    <label>Category</label>
    <select name="categoryId">
        <c:forEach items="${categories}" var="cat">
            <option value="${cat.catalogId}">${cat.catalogName}</option>
        </c:forEach>
    </select><br>
    <button type="submit">Update</button>
</form>
</body>
</html>
