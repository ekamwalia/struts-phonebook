<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <title>Welome</title>

    <style>
        .col-centered{
            float: none;
            margin: 0 auto;
        }
    </style>


</head>
<body>
<div class="jumbotron jumbotron-fluid text-center text-light bg-dark">
    <h1>Welcome To Phonebook</h1>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-6 col-centered">
        <h3>Login to your phonebook</h3>
        <s:form action="loginUser">
            <div class="form-group">
                <s:textfield name="userBean.username" cssClass="form-control" />
            </div>
            <div class="form-group">
                <s:password name="userBean.password" cssClass="form-control" />
            </div>
            <s:submit cssClass="btn btn-primary"/>
        </s:form>
        </div>

        <div class="col-sm-6">
        <h3>Not a user? Register Now</h3>
        <s:form action="registerUser">
            <div class="form-group">
                <s:textfield name="userBean.username" cssClass="form-control" />
            </div>
            <div class="form-group">
                <s:password name="userBean.password" cssClass="form-control" />
            </div>

            <s:submit cssClass="btn btn-primary"/>
        </s:form>
        </div>
    </div>
</div>
</body>
</html>