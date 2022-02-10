<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/25/2022
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit student</h1>
<form action="/students?param=edit" method="post">
<%--    <label for="id" hidden>ID:--%>
<%--        <input type="text" id="id" name="id" value="${student.getId()}">--%>
<%--    </label><br>--%>
    <label for="name">Name:
        <input id="name" type="text" name="name" value="${student.getName}" >
    </label><br>
    <label for="age">Age:
        <input id="age" type="text" name="age" value="${student.getAge()}">
    </label><br>
    <label for="address">Address:
        <input id="address" type="text" name="address" value="${student.getAddress()}">
    </label><br>
    <label for="avg">Avg:
        <input id="avg" type="text" name="avg" value="${student.getAvg()}">
    </label><br>
    <button type="submit">Edit</button>
</form>
</body>
</html>
