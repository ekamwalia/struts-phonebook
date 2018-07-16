<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <title>Home</title>

    <!-- Styles -->
    <style>
        #chartdiv {
            width		: 100%;
            height		: 500px;
            font-size	: 11px;
        }
    </style>

    <!-- Resources -->
    <script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
    <script src="https://www.amcharts.com/lib/3/serial.js"></script>
    <script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
    <link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
    <script src="https://www.amcharts.com/lib/3/themes/light.js"></script>
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

    <div class="container container-padding">

        <script>
            var arr = new Array();
            var counter = 0;
        </script>

        <s:iterator value="chartData" status="status">
            <script>

                x = {
                    "username": "${username}",
                    "count": "${count}"
                };

                arr[counter++] = x;
            </script>
        </s:iterator>

        <script>
            var chart = AmCharts.makeChart( "chartdiv", {
                "type": "serial",
                "theme": "light",
                "dataProvider": arr,
                "valueAxes": [ {
                    "gridColor": "#FFFFFF",
                    "gridAlpha": 0.2,
                    "dashLength": 0
                } ],
                "gridAboveGraphs": true,
                "startDuration": 1,
                "graphs": [ {
                    "balloonText": "[[category]]: <b>[[value]]</b>",
                    "fillAlphas": 0.8,
                    "lineAlpha": 0.2,
                    "type": "column",
                    "valueField": "count"
                } ],
                "chartCursor": {
                    "categoryBalloonEnabled": false,
                    "cursorAlpha": 0,
                    "zoomable": false
                },
                "categoryField": "username",
                "categoryAxis": {
                    "gridPosition": "start",
                    "gridAlpha": 0,
                    "tickPosition": "start",
                    "tickLength": 20
                },
                "export": {
                    "enabled": true
                }

            } );
        </script>

        <div id="chartdiv"></div>

    </div>
</body>
</html>