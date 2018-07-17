
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="header.jsp"/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>OMA Tech</title>
</head>
<body>



<form method="POST" action="/CreateProject">
<div class="container" id="BtnCreate">
    <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Create Project</button>

    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Create Project</h4>
                </div>
                <div class="modal-body">
                        Project name:<br>
                        <input type="text" class="tdl-new form-control" name="projectName" placeholder="Type here"><br>
                        Manager:<br>
                        <input type="text" class="tdl-new form-control" name="manager" placeholder="Type here"><br>
                        Client:<br>
                        <input type="text" class="tdl-new form-control" name="client" placeholder="Type here"><br>
                        Release date:<br>
                        <input type="date" class="tdl-new form-control" name=releaseDate" placeholder="Type here"><br>
                        Description:<br>
                        <input type="text" class="tdl-new form-control" name="description" placeholder="Type here"><br>
                        Status:<br>
                    <div class="selection">
                        <select class="selection form-control" name="status">
                            <option value="Pending">Pending</option>
                            <option value="Assigned">Assigned</option>
                            <option value="In Progress">In Progress</option>
                            <option value="Done">Done</option>
                        </select>
                    </div><br>
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