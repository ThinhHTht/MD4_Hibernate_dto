<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/28/2024
  Time: 5:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update category</title>
</head>
<body>
<form action="update" method="post">
    <label>Category id</label>
    <input type="text" id="catalogId" name="catalogId" value="${updateCat.catalogId}" readonly><br>
    <label>Category name</label>
    <input type="text" id="catalogName" name="catalogName" value="${updateCat.catalogName}"><br>
    <label>Descriptions</label>
    <textarea rows="10" cols="20" id="descriptions" name="descriptions">
        ${updateCat.descriptions}
    </textarea><br>
    <label>Status</label>
    <input type="radio" name="status" value="true" ${updateCat.status? "checked": ""}><label>Active</label>
    <input type="radio" name="status" value="false" ${!updateCat.status? "checked": ""}><label>Inactive</label><br>
    <input type="submit" value="Update">
</form>
</body>
</html>
