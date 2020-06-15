<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Home</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
</head>
<body>
<div align="center">
    <h2>Home</h2>
    <h3><a href="savePDF"><button>Save a PDF file</button></a></h3>
    <h3><a href="saveUTF8"><button>Save a Text file</button></a></h3>
</div>
<h1 align="center"> List of current books </h1>
<div align="center">
    <table>
        <tr>
            <th>Book ID</th>
            <th>Book Name</th>
            <th>Book Rating</th>
            <th>Book Review</th>
        </tr>
        <c:forEach items="${listOfBooks}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.bookName}</td>
            <td>${book.rating}</td>
            <td>${book.review}</td>
         </tr>
         </c:forEach>
    </table>
<div>
</body>
</html>