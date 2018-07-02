<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <title>Basic Struts 2 Application - Welcome</title>

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


<h3>All Users</h3>
<table class="borderAll">
    <tr>
        <th>Log ID &nbsp;</th>
        <th>Contact Name &nbsp;</th>
        <th>User Id &nbsp;</th>
        <th>Operation &nbsp;</th>
    </tr>
    <s:iterator value="logs" status="status">
        <tr>
            <td class="nowrap"><s:property value="id"/></td>
            <td class="nowrap"><s:property value="contactName"/></td>
            <td class="nowrap"><s:property value="userId"/></td>
            <td class="nowrap"><s:property value="operation"/></td>
        </tr>
    </s:iterator>
</table>

<p><a href='home.jsp'>Return to homepage</a></p>
</body>
</html>