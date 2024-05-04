<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 5/2/2024
  Time: 11:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
</head>
<body>
<form action="add" method="post" enctype="multipart/form-data">
    <label>Product name</label>
    <input type="text" id="productName" name="productName"><br>
    <label>Price</label>
    <input type="number" id="price" name="price"><br>
    <label>Image</label>
    <input type="file" id="file" name="file"><br>
    <label>Category</label>
    <select name="categoryId">
        <c:forEach items="${categories}" var="cat">
            <option value="${cat.catalogId}">${cat.catalogName}</option>
        </c:forEach>
    </select>
    <button type="submit">Add</button>
</form>

</body>
</html>
