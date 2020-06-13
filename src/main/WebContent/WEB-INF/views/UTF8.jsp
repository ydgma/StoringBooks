<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add UTF8</title>
</head>
<body>
<div align="center">
    <h2>Add a new UTF8(TEXT) book</h2>
    <form:form action="saveUTF8" method="post" modelAttribute="UTF8">
        <table border="0" cellpadding="5">
            <tr>
                <td>Book Name:</td>
                <td><form:input path="bookName" /></td>
            </tr>
            <tr>
                <td>Book Rating(1-10):</td>
                <td><form:input path="rating" /></td>
            </tr>
            <tr>
                <td>Book Review:</td>
                <td><form:textarea path="review" rows="5" cols="30" /></td>
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