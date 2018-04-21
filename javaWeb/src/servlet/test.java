package servlet;

import org.omg.IOP.Encoding;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Enumeration;

public class test extends HttpServlet {

    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //设置服务器编码为UTF-8
        request.setCharacterEncoding("UTF-8");

        testRequest(request, response);


    }

    private void testRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {


        res.setContentType("text/html;charset=UTF-8");
        PrintWriter w = res.getWriter();
        //获取客户机信息
        w.write("客户信息如下：");
        w.write("<br/>");
        w.write("请求的URL地址：" + req.getRequestURL().toString());
        w.write("<br/>");
        w.write("请求的资源：" + req.getRequestURI());
        w.write("<br/>");
        w.write("请求参数部分：" + req.getQueryString());
        w.write("<br/>");
        w.write("请求额外路径信息：" + req.getPathInfo());
        w.write("<br/>");
        w.write("客户IP地址：" + req.getRemoteAddr());
        w.write("<br/>");
        w.write("客户主机名：" + req.getRemoteHost());
        w.write("<br/>");
        w.write("客户网络端口号：" + req.getRemotePort());
        w.write("<br/>");
        w.write("Web服务器IP：" + req.getLocalAddr());
        w.write("<br/>");
        w.write("Web服务器主机名：" + req.getLocalName());
        w.write("<br/>");
        //获取客户请求头
        w.write("客户请求头：");
        w.write("<br/>");
        Enumeration<String> e = req.getHeaderNames();//获取所有请求头名称
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            String value = req.getHeader(name);
            w.write(name + " : " + value);
            w.write("<br/>");
        }
    }

    private void test1(HttpServletResponse response) throws IOException {
        response.getWriter().println(this.getClass().getName());

        //获取<servlet>中的初始化参数
        Enumeration<String> e = config.getInitParameterNames();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            String value = config.getInitParameter(name);
            response.getWriter().println(name + " : " + value);
        }

        //ServletContext 实现Servlet通讯
        ServletContext context = config.getServletContext();
        String data = (String) context.getAttribute("data");
        response.getWriter().println("servletContext数据 : " + data);

        //ServletContext实现请求转发
//        RequestDispatcher rd = context.getRequestDispatcher("/TestDefault");
//        rd.forward(request, response);

        //获取Web应用初始化参数
        ServletContext context1 = config.getServletContext();
        String contextInitParam = (String) context1.getAttribute("url");
        response.getWriter().println("web初始化数据 : " + contextInitParam);
    }

    private String toUTF8(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, "UTF-8");
    }
}
