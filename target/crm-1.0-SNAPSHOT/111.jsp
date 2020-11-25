<%--
  Created by IntelliJ IDEA.
  User: LX-PC
  Date: 2020/11/24
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>

<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
$.ajax({
url : "settings/user/login.do",
data : {
"" : ,
"" :
},
type : "post",
dataType : "json",
success : function (data){
if(data.success){
window.location.href = "workbench/index.html";
}else{
$("#msg").html(data.msg);
}
}


})
</body>
</html>
