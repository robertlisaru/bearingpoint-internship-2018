<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Oma tech</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<table class="table">
    <div class="card-title">
        <thead>
        <tr>
            <th>Task Name</th>
            <th>Due date</th>
            <th>Status</th>
        </tr>
        </thead>
    </div>
    <tbody>
    <form method="GET" action="/updatetask">
        <input type="hidden" name="taskID" value="${task.id}">
        <tr>
            <td><input type="text" class="tdl-new form-control" name="taskName" value="${task.name}"></td>
            <td><span><input type="text" class="tdl-new form-control" name="dueDate" value="${task.dueDate}"></span></td>
            <td><span><input type="text" class="tdl-new form-control" name="status" value="${task.status}"></span></td>
            <td>
                <button type="submit">Update</button>
            </td>
    </form>

    <td>
        <a href="/deletetask?taskID=${task.id}" class="btn btn-default">Delete</a>
    </td>
    </tr>
    </tbody>
</table>
</body>
</html>
