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
<p><a href='<s:url action="logout" />'>Logout</a></p>
</body>
</html>