<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: pardis
  Date: 1/29/2022
  Time: 9:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% User user = (User) request.getAttribute("user");%>

<%= user.getName() + " \n" + user.getPassword() %>
<%= user.getName() + " \n" + user.getPassword() %>

</body>
</html>
