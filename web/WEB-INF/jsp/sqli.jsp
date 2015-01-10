<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title> <%-- Title goes here --%> </title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script src="scripts/jquery-1.3.2.js" type="text/javascript"></script>
    <script type="text/javascript">
        function inject() {
            $.get("sqli.htm", {method: "inject", user_input: $("#user_input").val()});
        }
    </script>
</head>
<body>
<div id="wrap">
    <jsp:include page="header.jsp"/>
    <jsp:include page="navigationbar.jsp"/>

    <div id="center">

        <input type="text" id="user_input"/> <input type="submit" value="Save" onclick="inject();">

    </div>
    <div style="clear: both;">
        <jsp:include page="footer.jsp"/>
    </div>
</div>
</body>
</html>
