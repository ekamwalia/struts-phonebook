<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <title>Phonebook</title>
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

<div class="container">
    <div class="row text-center">
        <div class="col">

            <s:if test = "personBean==null">
                <b>No contact with the given name found</b>
            </s:if>

            <s:else>
                <p><b>Contact Found</b></p>
                <p><b>Name:</b> <s:property value="personBean.name" /></p>
                <p><b>Email:</b> <s:property value="personBean.email" /></p>
                <p><b>Phone Number:</b> <s:property value="personBean.mobile" /></p>
                <p><b>Age:</b> <s:property value="personBean.age" /></p>
            </s:else>

            <p><a href="home.jsp">Return to home page</a></p>
            <p><a href="updateForm.jsp">Update this contact</a>.</p>
        </div>
    </div>
</body>
</html>