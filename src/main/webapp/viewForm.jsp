<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>View</title>
</head>
<body>
<h3>Find a contact in your Phonebook</h3>

<s:form action="view">
    <s:textfield name="username" label="Name" />
    <s:if test = "#session.userAccess==1">
        <s:textfield name="userId"  label="User ID"  />
    </s:if>
    <s:submit/>
</s:form>

</body>
</html>