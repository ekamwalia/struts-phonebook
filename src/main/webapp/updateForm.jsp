<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    
    <title>Register</title>
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
    <div class="row">
        <div class="col-sm-12 col-centered">
            <h3 class="text-center">Enter details for the new contact</h3>
            <s:form action="update">
                <div class="form-group">
                    <s:textfield name="personBean.name" value="Name" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <s:textfield name="personBean.mobile" value="Mobile" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <s:textfield name="personBean.email"  value="Email" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <s:textfield name="personBean.age"  value="Age" cssClass="form-control" />
                </div>


                <div class="form-group">
                    <s:if test = "#session.userAccess==1">
                        <s:textfield name="userId" value="User Id" cssClass="form-control" />
                    </s:if>
                </div>
                <s:submit cssClass="btn btn-primary"/>
            </s:form>
        </div>
    </div>
</div>
</body>
</html>