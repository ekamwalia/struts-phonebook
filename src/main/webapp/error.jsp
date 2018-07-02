<%--
  Created by IntelliJ IDEA.
  User: ekamwalia
  Date: 27/5/18
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid text-light">
        <div class="navbar-header text-light">
            <h1 class="navbar-brand text-light">Phonebook</h1>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><span class="glyphicon glyphicon-user"></span>Welcome, <s:property value="#session.username" /></li>
            <li><a href='<s:url action="logout" />'><span class="glyphicon glyphicon-user">Logout</span></a></li>
        </ul>
    </div>
</nav>


Some unknown error occured
</body>
</html>
