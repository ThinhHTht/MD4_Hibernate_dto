<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/28/2024
  Time: 3:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List category</title>
</head>
<body>
<h1>List category</h1>
<a href="addCategory">Add category</a>
<table border="1">
    <thead>
    <tr>
        <td>No.</td>
        <td>Id</td>
        <td>Name</td>
        <td>Created</td>
        <td colspan="2">Actions</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCategories}" varStatus="loop" var="cat">
        <tr>
            <td>${loop.count}</td>
            <td>${cat.catalogId}</td>
            <td>${cat.catalogName}</td>
            <td>${cat.created}</td>
            <td> <a href="initUpdate?catalogId=${cat.catalogId}">Update</a></td>
            <td><a href="delete?catalogId=${cat.catalogId}" onclick="return confirm('Bạn có chắc muốn xóa không?')">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
