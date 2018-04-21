package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

@WebServlet(name = "CookieServlet", urlPatterns = "/CookieServlet")
public class CookieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置服务器以UTF-8编码输出
        response.setCharacterEncoding("UTF-8");
        //设置浏览器以UTF-8编码接收
        response.setContentType("text/html;charset=UTF-8");

        Enumeration<String> e = request.getParameterNames();
        if (e.hasMoreElements()) {
            int param = Integer.parseInt(request.getParameter("id"));
            if (param == 1)
                test1(request, response);
            else
                test(request, response);
        } else {
            response.getWriter().write("请求缺少参数：id");
        }

    }

    private void test1(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        //创建一个Cookie名字为lastAccessDate
        Cookie cookie = new Cookie("lastAccessDate", System.currentTimeMillis() + "");
        //将Cookie的MaxAge设置为0，命令浏览器删掉它
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.getWriter().write("Cookie已删除");

    }

    private void test(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter w = response.getWriter();

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            w.write("您上一次访问的时间是：");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("lastAccessDate")) {
                    long time = Long.parseLong(cookie.getValue());
                    Date date = new Date(time);
                    w.write(date.toLocaleString());
                }
            }
        } else {
            w.write("您是第一次访问");
        }

        //访问结束后设置用户最后访问时间,存储到cookie中，发送给服务器
        Cookie cookie = new Cookie("lastAccessDate", System.currentTimeMillis() + "");
        response.addCookie(cookie);
    }
}
