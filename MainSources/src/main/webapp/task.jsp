<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oma tech</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<table>
    <div class="card-title">
        <thead>
        <tr>
            <th>Task ID</th>
            <th><a href="task.jsp" name="task"></a> Task name </th>
            <th>Estimated time of completion</th>
            <th> Status </th>
            <th>Time so far</th>
            <th>Assigned to</th>
        </tr>
        </thead>
    </div>
    <tbody>
    <tr>
        <td><span><input type="text" class="tdl-new form-control" name="name" placeholder=""></span></td>
        <td><input type="text" class="tdl-new form-control" name="projectId" placeholder=""></td>
        <td><span><input type="text" class="tdl-new form-control" name="timeOfCompl" placeholder=""></span></td>
        <td><input type="submit" name="editBtn" value="Edit"></td>
        <td><input type="submit" name="deleteBtn" value="Delete"></td>
    </tr>
    </tbody>
</table>
</body>
</html>
