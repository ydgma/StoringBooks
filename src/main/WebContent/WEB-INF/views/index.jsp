<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Home</title>

</head>
<body>
<div align="center">
    <h2>Home</h2>
    <h3><a href="addBook">Add New Book</a></h3>
    <h4>Test book stuff ${bookname}</h4>
    <h4>${message}</h4>
</div>
</body>
</html>