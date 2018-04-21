package servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "SessionServlet",urlPatterns = "/SessionServlet")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //从request中获取一个session，如果没有则创建一个
        HttpSession session = request.getSession();
        boolean del = false;
        Enumeration<String> e = request.getParameterNames();
        if (e.hasMoreElements()){
            del = Boolean.parseBoolean(request.getParameter("del"));
            response.getWriter().write("Session已删除");
        }
        if (del){
            //摧毁Session
            session.invalidate();
            response.getWriter().write("新建Session  id : " +session.getId());
        }else{
            if (session.isNew()){
                response.getWriter().write("新建Session  id : " +session.getId());
                session.setAttribute("hello","你好世界");
            }else{
                response.getWriter().write("服务器已存在Session  id : " +session.getId());
                response.getWriter().println("hello : " +session.getAttribute("hello"));
            }
        }

    }
}
