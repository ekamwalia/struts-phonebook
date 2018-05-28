<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Basic Struts 2 Application - Welcome</title>
</head>
<body>
<h1>Welcome To Phonebook <s:property value="#session.username" /></h1>

<h3>User Options</h3>
<ul>
<li><a href="registerForm.jsp">Add a new contact</a></li>
<li><a href="viewForm.jsp">Find a contact</a></li>
<li><a href="updateForm.jsp">Update a contact</a></li>
<li><a href="deleteForm.jsp">Delete a contact</a></li>
</ul>
<s:if test = "#session.userAccess==1">
    <h3>Admin options</h3>
    <ul>
        <li><a href="<s:url action="viewAllUsers" />">View all users</a></li>
        <li><a href="<s:url action="viewLogs" />">View Logs</a></li>
    </ul>
</s:if>

<p><a href='<s:url action="logout" />'>Logout</a></p>
</body>
</html>