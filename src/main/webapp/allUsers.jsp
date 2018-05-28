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
        <th>User ID &nbsp;</th>
        <th>Username &nbsp;</th>
        <th>Admin Access &nbsp;</th>
    </tr>
    <s:iterator value="users" status="status">
        <tr>
            <td class="nowrap"><s:property value="id"/></td>
            <td class="nowrap"><s:property value="username"/></td>
            <td class="nowrap">
            <s:if test="admin == 1">
                <span>Yes</span>
            </s:if>
            <s:else>
                <span>No</span>
            </s:else>
            </td>
        </tr>
    </s:iterator>
</table>

<p><a href='home.jsp'>Return to homepage</a></p>
<p><a href='<s:url action="logout" />'>Logout</a></p>
</body>
</html>