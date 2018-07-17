<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OMA tech</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<table border="1">
    <th>Username</th>
    <th>Email</th>
    <th>Gender</th>
    <c:forEach items="${User}" var="user">
        <tr>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.gender}</td>
            <td><input type="Submit" name="editBtn" value="Edit"></td>
            <td><input type="Submit" name="deleteBtn" value="Delete"></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
