<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>OMA tech</title>

</head>
<body>
<jsp:include page="header.jsp"/>
<table class="table">
    <div class="card-title">
        <thead>
        <tr>
            <th>Project Name</th>
            <th>Manager</th>
            <th>Client</th>
            <th>Release Date</th>
            <th>Description</th>
            <th>Status</th>
        </tr>
        </thead>
    </div>
    <tbody>
    <form>
        <tr>
            <td><input type="text" class="tdl-new form-control" name="projectName" value="${project.name}"></td>
            <td><span><input type="text" class="tdl-new form-control" name="manager" value="${project.manager}"></span>
            </td>
            <td><span><input type="text" class="tdl-new form-control" name="client" value="${project.client}"></span>
            </td>
            <td>
                <span><input type="text" class="tdl-new form-control" name="releaseDate" value="${project.releaseDate}"></span>
            </td>
            <td>
                <span><input type="text" class="tdl-new form-control" name="description" value="${project.description}"></span>
            </td>
            <td><span><input type="text" class="tdl-new form-control" name="status" value="${project.status}"></span>
            </td>
            <td>
                <button type="submit">Edit</button>
            </td>
            <td>
                <form action="/deleteProject?projectID=${project.id}" method="POST">
                    <button type="submit"></button>
                    Delete
                </form>
            </td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
