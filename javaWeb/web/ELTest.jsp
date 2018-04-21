<%@ page import="javaBean.Person" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="elel" uri="/myTag" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("name", "你猜啊");
%>
<%--${name}等同于pageContext.findAttribute("name")--%>
<h1>name : ${name}</h1>
<%
    Person person = new Person();
    person.setName("勇敢的迷茫");
    person.setSex("男");
    person.setAge(21);
    request.setAttribute("person", person);
%>
<%--取javaBean内容--%>
<h1>Person属性</h1>
<h2>name : ${person.name}</h2>
<h2>age : ${person.age}</h2>
<h2>sex : ${person.sex}</h2>

<%
    Person p1 = new Person();
    p1.setName("p1");
    p1.setSex("男");
    p1.setAge(212);

    Person p2 = new Person();
    p2.setName("p2");
    p2.setSex("男");
    p2.setAge(213);

    List<Person> list = new ArrayList<>();
    list.add(p1);
    list.add(p2);

    request.setAttribute("list", list);
%>
<%--取list数据--%>
<h2>取指定位置数据 : ${list.get(0).name}</h2>
<h2>取指定位置数据 : ${list[1].name}</h2>
<h1>迭代数据</h1>
<c:forEach var="person" items="${list}">
    ${person.name}
</c:forEach>

<%
    Map<String, String> map = new HashMap<>();
    map.put("a", "aaa");
    map.put("b", "bbb");
    map.put("1", "111");
%>
<%--取Map数据--%>
<h2>Map数据 : ${map.a}</h2>
<h2>Map数据 : ${map["1"]}</h2>
<h1>迭代数据</h1>

<%--执行运算--%>
<h1>四则运算</h1>
<h2>加 : ${1321+321}</h2>
<h2>减 : ${321-123}</h2>
<h2>乘 : ${123*3}</h2>
<h2>除 : ${100/10}</h2>
<h1>关系运算</h1>
<h2>person==null : ${person == null}</h2>
<h1>empty运算</h1>
<h2>empty(list) : ${empty(list)}</h2>
<h2>${list.get(0).name}</h2>
<h1>三目运算符</h1>
<h2>person == null? "对不起没有登陆":person.name</h2>
<h2>${person == null? "对不起没有登陆":person.name}</h2>
<input type="radio" name="sex" value="男" ${person.sex == "男"? "checked":""}>男
<input type="radio" name="sex" value="女" ${person.sex == "女"? "checked":""}>女

<h1>获得web常用对象</h1>
<h1>pageContext</h1>
<h2>${pageContext}</h2>
<%request.setAttribute("0","勇敢不迷茫");%>
<h1>requestScope</h1>
<h2>${requestScope.get("0")}</h2>
<%session.setAttribute("1","Immortal-soul");%>
<h1>sessionScope</h1>
<h2>${sessionScope.get("1")}</h2>
<%application.setAttribute("2","无奈");%>
<h1>applicationScope</h1>
<h2>${applicationScope.get("2")}</h2>

<h1>Cookie中数据</h1>
<h2>${cookie.JSESSIONID.value}</h2>

<h1>Web应用初始化参数</h1>
<h2>${initParam.url}</h2>

<h1>EL函数</h1>
<h2>${elel:plus(10, 30)}</h2>

<%--通过set标签设定score的值为85 --%>
<c:set var="score" value="85"/>
<c:choose>
    <%--使用<c:when>进行条件判断。
    如果大于等于90，输出“您的成绩为优秀”；
    如果大于等于70小于90，输出“您的成绩为良好”；
    大于等于60小于70，输出“您的成绩为及格”；
    其他（otherwise）输出“对不起，您没能通过考试”。
    --%>
    <c:when test="${score>=90}">
        你的成绩为优秀！
    </c:when>
    <c:when test="${score>70 && score<90}">
        您的成绩为良好!
    </c:when>
    <c:when test="${score>60 && score<70}">
        您的成绩为及格
    </c:when>
    <c:otherwise>
        对不起，您没有通过考试！
    </c:otherwise>
</c:choose>
</body>
</html>
