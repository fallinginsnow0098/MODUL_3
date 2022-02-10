<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/home?createPost" method="post">
    <label>ID
        <input type="text" name="id" placeholder="ID">
    </label>
    <label>Tên
        <input type="text" name="name" placeholder="NAME">
    </label>
    <label>Tuổi
        <input type="text" name="age" placeholder="AGE">
    </label>
    <label>Địa chỉ
        <input type="text" name="address" placeholder="ADDRESS">
    </label>
    <label>Tên lớp
        <input type="text" name="className" placeholder="CLASS NAME">
    </label>
    <input type="submit"  <c:if test="${student != null}" var="Edit"/>  <c:if test="${student == null}" var="Create"/>>
</form>
</body>
</html>
