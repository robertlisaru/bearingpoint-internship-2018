<title>OMA Tech</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="utf-8">
<link href="css/style.css" rel="stylesheet">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <div class="navbar-header">
            <img id="brand-image" alt="Logo Website" src="images/icons/Logo.png"/>

        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="index">Home</a></li>
            </p>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="${user != null}">
                    <li>Logged in as: ${user.username}</li>
                    <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="login.jsp"><span class="glyphicon glyphicon-user"></span> Login</a></li>
                    <li><a href="register.jsp"><span class="glyphicon glyphicon-user"></span> Register</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>

