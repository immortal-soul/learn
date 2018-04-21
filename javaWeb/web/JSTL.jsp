<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <li><c:out value="核心标签测试"/></li>
    <li><c:out value="${null}">out标签测试(默认值)</c:out></li>
    <li><c:out value="<a href='http://www.baidu.com'>点击跳转到百度</a>" escapeXml="false"/></li>
    <li><c:out value="${null}" default="默认值"/> </li>
</ul>
</body>
</html>
