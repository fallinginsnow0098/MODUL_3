<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Student Detail</h1>
<p>Id: ${student.getId()()}</p>
<p>Tên: ${student.getName()}</p>
<p>Tuổi: ${student.getAge()()}</p>
<p>Địa chỉ: ${student.getAddress()}</p>
<p>Tên lớp: ${student.getClassName()}</p>
</body>
</html>