<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="my" uri="/WEB-INF/tld/myTag.tld" %>
<%@taglib prefix="simple" uri="/simple" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    session.setAttribute("name", "session对象");//使用session对象,设置session对象的属性
    out.print(session.getAttribute("name") + "<br/>");//获取session对象的属性
    pageContext.setAttribute("name", "pageContext对象");//使用pageContext对象,设置pageContext对象的属性
    out.print(pageContext.getAttribute("name") + "<br/>");//获取pageContext对象的属性
    application.setAttribute("name", "application对象");//使用application对象,设置application对象的属性
    out.print(application.getAttribute("name") + "<br/>");//获取application对象的属性
    out.print("Hello Jsp" + "<br/>");//使用out对象
    out.print("服务器调用index.jsp页面时翻译成的类的名字是：" + page.getClass() + "<br/>");//使用page对象
    out.print("处理请求的Servlet的名字是：" + config.getServletName() + "<br/>");//使用config对象
    out.print(response.getContentType() + "<br/>");//使用response对象
    out.print(request.getContextPath() + "<br/>");//使用request对象

    out.print("----------------------<br/>");

    for (int i = 0; i < 10; i++)
        out.print(i + "<br/>");

    jspInit();
%>
<p>JSP声明</p>
<%!
    public int i = 0;

    public void jspInit() {
        System.out.println(i++);
    }
%>
<%
    jspInit();
%>
<h1>静态导入</h1>
<%@include file="test.jspf"%>
<h1>动态导入</h1>
<jsp:include page="author.jsp" flush="true"/>
<h1>测试自定义标签</h1>
<h2>java代码输出<%=request.getRemoteAddr()%></h2>
<h2>标签输出 客户IP : <my:ip/></h2>
<h1>简单标签</h1>
<h2><simple:demo>测试简单标签</simple:demo></h2>
<h1>大写字母标签</h1>
<h2><simple:uppercase>Immortal-soul编写</simple:uppercase></h2>
</body>
</html>
