<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Register</title>
</head>
<body>
<h1>Welcome To Phonebook </h1>

<p>
<h3>Login now to manage your phonebook</h3>
<s:form action="loginUser">
    <s:textfield name="userBean.username" label="Username" />
    <s:password name="userBean.password" label="Password" />
    <s:submit/>
</s:form>
</p>

<p>
<h3>Not a user yet? Register Now</h3>
<s:form action="registerUser">
    <s:textfield name="userBean.username" label="Username" />
    <s:password name="userBean.password" label="Password" />
    <s:submit/>
</s:form>
</p>
</body>
</html>