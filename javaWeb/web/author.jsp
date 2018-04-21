<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--获得一个Person对象--%>
<jsp:useBean id="person" class="javaBean.Person" scope="page"/>
<%--设置Person对象属性--%>
<%--
    person.setName("Immortal-soul");
    person.setAge(22);
    person.setSex("男");
--%>
<jsp:setProperty name="person" property="name" value="Immortal-soul"/>
<jsp:setProperty name="person" property="age" value="22"/>
<jsp:setProperty name="person" property="sex" value="男"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--获得Person对象属性--%>
<h2>姓名：<%=person.getName()%></h2>
<h2>年龄：<%=person.getAge()%></h2>
<h2>性别：<%=person.getSex()%></h2>
<%--<jsp:getProperty>标签获得Person对象属性--%>
<h2>姓名：<jsp:getProperty name="person" property="name"/></h2>
<h2>年龄：<jsp:getProperty name="person" property="age"/></h2>
<h2>性别：<jsp:getProperty name="person" property="sex"/></h2>
</body>
</html>
