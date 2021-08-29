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

    // var url = "http://localhost:8080/sse";
    var url = "http://localhost:8080/sse/12";

    if (window.EventSource) {

        var count = 0;
        // 创建sse推送源
        var sse = new EventSource(url);

        sse.onmessage = function (e) {
            // console.log("接收消息")
            $("#msgFromPush").append(e.data||'');
            count += 1;
            if (count >=10) {
                sse.close();
                $("#msgFromPush").append("关闭")
            }
        };
        sse.onopen = function (e) {
            // console.log("接收消息")
            console.log("建立连接");
        };
        sse.onerror = function (e) {
            // console.log("接收消息")
            console.log("异常")
        };

    } else {
        alert("您的浏览器不支持SSE");
    }
</script>
</html>
