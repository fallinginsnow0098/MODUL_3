<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Student List</h1>
<table>
    <tr>
        <td>ID</td>
        <td>Tên</td>
        <td>Tuổi</td>
        <td>Địa chỉ</td>
        <td>Tên lớp</td>
        <td colspan="2"> Nút</td>
    </tr>
    <c:forEach var="st" items="students">
        <tr>
            <td>${st.getId()}</td>
            <td><a id="name" style="text-decoration: none" href="/home?action=&id=${st.getId()}"> ${st.getName()} </a></td>
            <td>${st.getAge()}</td>
            <td>${st.getAddress()}</td>
            <td>${st.getClassName()}</td>
            <td><a href="/home?action=editGet&id=${city.getId()}">Edit</a></td>
            <td><a href="/home?action=delete&id=${city.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
