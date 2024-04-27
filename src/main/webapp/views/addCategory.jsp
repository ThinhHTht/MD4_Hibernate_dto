<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/28/2024
  Time: 3:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add category</title>
</head>
<body>
<form action="add" method="post">
  <label>Category name</label>
  <input type="text" id="catalogName" name="catalogName"><br>
  <label>Descriptions</label>
  <textarea rows="10" cols="20" id="descriptions" name="descriptions"></textarea><br>
  <input type="submit" value="Add">
</form>
</body>
</html>
