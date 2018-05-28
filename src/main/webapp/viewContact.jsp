<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Phonebook</title>
</head>
<body>
<p>Viewing contact</p>
<p>Contact information: <s:property value="personBean" /> </p>

<p><a href="updateForm.jsp">Update this contact</a>.</p>
<p><a href="<s:url action='index' />">Return to home page</a></p>
</body>
</html>