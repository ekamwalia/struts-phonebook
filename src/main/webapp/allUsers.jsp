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
                <li><a href='home.jsp'>Home</a></li>
            </ul>
        </div>
    </nav>

    <div class="container">

        <div class="row col-centered">
            <h3>All Users</h3>
        </div>

        <div class="row">
           Click on a user's name to view the user's contact and access level to toggle access.
        </div>

        <div class="row col-centered">
            <table class="table table-striped table-bordered">
                <tr>
                    <th style="width: 25%">Username &nbsp;</th>
                    <th style="width: 25%">Admin Access &nbsp;</th>
                </tr>
                <s:iterator value="users" status="status">
                    <tr>
                        <td style="width: 25%">
                            <s:url action="viewUsersContacts" var="viewUsersContacts" escapeAmp="false">
                                <s:param name="userId"><s:property value="id"/></s:param>
                                <s:param name="username"><s:property value="username"/></s:param>
                            </s:url>
                            <a href="${viewUsersContacts}"><s:property value="username"/></a>
                        </td>

                        <td style="width: 25%">
                            <s:if test="admin == 1">
                                <s:url action="revokeAdminAccess" var="toggleAccess">
                                    <s:param name="userId"><s:property value="id"/></s:param>
                                </s:url>
                            </s:if>
                            <s:else>
                                <s:url action="grantAdminAccess" var="toggleAccess">
                                    <s:param name="userId"><s:property value="id"/></s:param>
                                </s:url>
                            </s:else>
                            <s:if test="admin == 1">
                                <p><a href="${toggleAccess}">Yes</a></p>
                            </s:if>
                            <s:else>
                                <p><a href="${toggleAccess}">No</a></p>
                            </s:else>
                        </td>

                    </tr>
                </s:iterator>
            </table>
        </div>
    </div>

</body>
</html>