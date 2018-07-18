<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oma tech</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<form method="POST" action="/CreateTask">
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
                        ProjectID:<br>
                        <input type="text" class="tdl-new form-control" name="projectId" placeholder="Type here"><br>
                        Release date:<br>
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

<table class="table">
    <thead>
    <tr>
        <th scope="col">Task name</th>
        <th scope="col">ProjectID</th>
        <th scope="col">Estimated Time</th>
        <th scope="col">Status </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${taskList}" var="task">
        <tr>
            <td><a href="task?taskID=${task.id}">${task.name}</a></td>
            <td>${task.projectID}</td>
            <td>${project.estimatedTime}</td>
            <td>${project.status}</td>
            <br>
        </tr>
    </c:forEach>
    </tbody>
</table>



<table>
    <div class="card-title">
        <thead>
        <tr>
            <th>Task ID</th>
            <th><a href="tasks.jsp" name="task"></a> Task name </th>
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
