<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <title>Home</title>

    <style>
        .container-padding {
            padding: 1vh 1vw 1vh 1vw;
            margin: 1vh 1vw 1vh 1vw;
        }
    </style>
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
<div class="container container-padding">

    <div class="list-group">
        <a href="registerForm.jsp" class="list-group-item">
            <h4 class="list-group-item-heading">Add Contact</h4>
            <p class="list-group-item-text">Add a new contact to your phonebook</p>
        </a>
        <a href="viewForm.jsp" class="list-group-item">
            <h4 class="list-group-item-heading">Find Contact</h4>
            <p class="list-group-item-text">Find a contact stored in your phonebook</p>
        </a>
        <a href="updateForm.jsp" class="list-group-item">
            <h4 class="list-group-item-heading">Update Contact</h4>
            <p class="list-group-item-text">Update an existing contact from your phonebook</p>
        </a>
        <a href="deleteForm.jsp" class="list-group-item">
            <h4 class="list-group-item-heading">Delete Contact</h4>
            <p class="list-group-item-text">Delete an existing contact from your phonebook</p>
        </a>

        <s:if test = "#session.userAccess==1">
            <a href="<s:url action="viewAllUsers" />" class="list-group-item">
                <h4 class="list-group-item-heading">View All Users</h4>
                <p class="list-group-item-text">View all users who are registered on this platform</p>
            </a>
            <a href="<s:url action="viewLogs" />" class="list-group-item">
                <h4 class="list-group-item-heading">View Logs</h4>
                <p class="list-group-item-text">View the recent activity of all users using this platform</p>
            </a>

        </s:if>
    </div>
</div>
</body>
</html>