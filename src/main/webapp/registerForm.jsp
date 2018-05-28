<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Register</title>
</head>
<body>
<h3>Add a new user using this contact</h3>

<s:form action="create">
    <s:textfield name="personBean.name" label="Name" />
    <s:textfield name="personBean.mobile" label="Mobile" />
    <s:textfield name="personBean.email"  label ="Email"/>
    <s:textfield name="personBean.age"  label="Age"  />

    <s:if test = "#session.userAccess==1">
        <s:textfield name="userId"  label="User ID"  />
    </s:if>
    <s:submit/>
</s:form>
</body>
</html>