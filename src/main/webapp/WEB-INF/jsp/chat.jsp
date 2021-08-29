<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: brian
  Date: 2016/3/8
  Time: 0:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>聊天室</title>
</head>
<body>
<label>内容</label>
<div id="msgFromPush" style="width: 800px; height: 600px;"></div>
</body>
<script src="<%=request.getContextPath()%>/static/js/jquery-3.5.1.min.js"></script>
<script>

    var url = "role_echo";

    if (window.EventSource) {
        var source = new EventSource('/role_echo');//发送消息
        s = '';

        source.addEventListener('message', function (e) {

            console.log("接收消息");

            s += e.data + "<br/>";
            $("#msgFromPush").html(s);
        }, false);//添加客户端的监听

        source.addEventListener('open', function (e) {
            console.log("连接打开");
        }, false);

        source.addEventListener('error', function (e) {
            if (e.currentTarget.readyState == EventSource.CLOSED) {
                console.log("连接关闭");
            } else {
                console.log(e.currentTarget.readyState);
            }
        });
    } else {
        console.log("您的浏览器不支持SSE");
    }
</script>
</html>
