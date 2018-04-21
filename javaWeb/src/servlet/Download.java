package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "Download",urlPatterns = "/Download")
public class Download extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");

        String fileName = "test.jpg";

        //3.设置content-disposition响应头控制浏览器以下载的形式打开文件
        response.setHeader("content-disposition", "attachment;filename="+fileName);

        String path = this.getServletContext().getRealPath("/WEB-INF/images/"+fileName);

        try{
            File file = new File(path);
            InputStream is = new FileInputStream(file);
            OutputStream os = response.getOutputStream();
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            os.write(bytes);
            is.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
