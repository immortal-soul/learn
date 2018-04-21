package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.jsp.PageContext;
import java.io.*;


@WebServlet(name = "Upload", urlPatterns = "/Upload")
public class Upload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            processRequest(request, response);
        }catch (Exception e){
            e.printStackTrace();
            out.write("上传失败");
        }

        out.write("上传成功");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("222");
    }

    /**
     * part获取文件信息
     */
    private void test(HttpServletRequest request, HttpServletResponse response) {
        try {
            Part part = request.getPart("upload");
            //获取请求的信息
            String name = part.getHeader("content-disposition");
            //System.out.println(name);//测试使用
            //System.out.println(desc);//

            //获取上传文件的目录
            String root = request.getServletContext().getRealPath("/upload");
            System.out.println("测试上传文件的路径：" + root);

            //获取文件的后缀
            String str = name.substring(name.lastIndexOf("."), name.length() - 1);
            System.out.println("测试获取文件的后缀：" + str);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取上传文件名字
     * @param body 上传流转的字符串
     * @return
     */
    public String getFileName(String body){
        //获取上传文件名字
        int begin = body.indexOf("filename=")+10;
        int end = body.indexOf("\n",begin)-2;
        return body.substring(begin,end);
    }

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //读取请求Body
        byte[] body = readBody(request);
        //取得所有Body内容的字符串表示
        String textBody = new String(body, "ISO-8859-1");
        //取得上传的文件名称
        String fileName = getFileName(textBody);
        //取得文件开始与结束位置
        Position p = getFilePosition(request, textBody);
        //设置存储地址
        String path = this.getServletContext().getRealPath("WEB-INF/images/"+fileName);
        //输出至文件
        writeTo(path, body, p);
    }

    //构造类
    class Position {

        int begin;
        int end;

        public Position(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }

    private byte[] readBody(HttpServletRequest request) throws IOException {
        //获取请求文本字节长度
        int formDataLength = request.getContentLength();
        //取得ServletInputStream输入流对象
        DataInputStream dataStream = new DataInputStream(request.getInputStream());
        byte body[] = new byte[formDataLength];
        int totalBytes = 0;
        while (totalBytes < formDataLength) {
            int bytes = dataStream.read(body, totalBytes, formDataLength);
            totalBytes += bytes;
        }
        return body;
    }

    private Position getFilePosition(HttpServletRequest request, String textBody) throws IOException {
        //取得文件区段边界信息
        String contentType = request.getContentType();
        String boundaryText = contentType.substring(contentType.lastIndexOf("=") + 1, contentType.length());
        //取得实际上传文件的气势与结束位置
        int pos = textBody.indexOf("filename=\"");
        pos = textBody.indexOf("\n", pos) + 1;
        pos = textBody.indexOf("\n", pos) + 1;
        pos = textBody.indexOf("\n", pos) + 1;
        int boundaryLoc = textBody.indexOf(boundaryText, pos) - 4;
        int begin = ((textBody.substring(0, pos)).getBytes("ISO-8859-1")).length;
        int end = ((textBody.substring(0, boundaryLoc)).getBytes("ISO-8859-1")).length;

        return new Position(begin, end);
    }

    private void writeTo(String outPath, byte[] body, Position p) throws IOException {
        System.out.println(outPath);
        FileOutputStream fileOutputStream = new FileOutputStream(outPath);
        fileOutputStream.write(body, p.begin, (p.end - p.begin));
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
