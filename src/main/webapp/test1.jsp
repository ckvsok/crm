<%--
  Created by IntelliJ IDEA.
  User: LX-PC
  Date: 2020/11/24
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>

    $.ajax({
        url : "",
        data : {

        },
        type : "",
        dataType : "json",
        success :
        function (data){

        }
    })


</head>
<body>

</body>
</html>
