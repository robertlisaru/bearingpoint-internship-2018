<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>OMA tech</title>

</head>
<body>
<jsp:include page="header.jsp"/>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Task name</th>
        <th scope="col">Due date</th>
        <th scope="col">Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${taskList}" var="task">
        <tr>
            <td>${task.name}</td>
            <td>${task.dueDate}</td>
            <td>${task.status}</td>
            <br>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form method="POST" action="/CreateTask">
    <input name="projectId" type="hidden" value="${project.id}">
    <div class="container" id="BtnCreate">
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Create Task
        </button>

        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Create Task</h4>
                    </div>
                    <div class="modal-body">
                        Task name:<br>
                        <input type="text" class="tdl-new form-control" name="taskName" placeholder="Type here"><br>
                        Due date:<br>
                        <input type="date" class="tdl-new form-control" name="timeOfCompl" placeholder="Type here"><br>
                        Status:<br>
                        <div class="selection">
                            <select class="selection form-control" name="status">
                                <option value="Pending">Pending</option>
                                <option value="Assigned">Assigned</option>
                                <option value="In Progress">In Progress</option>
                                <option value="Done">Done</option>
                            </select>
                        </div>
                        <br>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary" value="ADD">Add</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
