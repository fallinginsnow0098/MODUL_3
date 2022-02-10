<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>All Students</h1>
<button><a href="/students?param=createGet">Create new student</a></button>
<button><a href="/students?param=sort">Sắp xếp</a></button>
<button><a href="/students?param=great">SV giỏi</a></button>
<br>
<br>
<form action="/students?param=search" method="post">
    <label><input type="text" name="search-name"></label>
    <button type="submit">Search</button>
</form>

<table style="border: 1px solid black; border-collapse: collapse; background-color: bisque">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Age</td>
        <td>Address</td>
        <td>Average</td>
        <td colspan="2">Action</td>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.getId()}</td>
            <td>${student.getName()}</td>
            <td>${student.getAge()}</td>
            <td>${student.getAddress()}</td>
            <td>${student.getAvg()}</td>
            <td>
                <button><a href="/students?parram=editGet">Edit</a></button>
            </td>
            <td>
                <button><a href="">Delete</a></button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>