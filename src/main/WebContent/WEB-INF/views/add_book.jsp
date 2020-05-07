<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add Book</title>
</head>
<body>
<div align="center">
    <h2>Add a new book</h2>
    <h4>Test book stuff ${message1}</h4>
    <form:form action="save" method="post" modelAttribute="book">
        <table border="0" cellpadding="5">
            <tr>
                <td>Book Name:</td>
                <td><form:input path="bookName" /></td>
            </tr>
            <tr>
                <td>File Location:</td>
                 <td><form:input path="filePath" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save" /></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>