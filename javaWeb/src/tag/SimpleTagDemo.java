package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class SimpleTagDemo extends SimpleTagSupport{

    @Override
    public void doTag() throws JspException, IOException {

        JspFragment jspFragment = this.getJspBody();

        //得到jsp页面的的PageContext对象
        PageContext pageContext = (PageContext) jspFragment.getJspContext();
        //调用JspWriter将标签体的内容输出到浏览器
        jspFragment.invoke(pageContext.getOut());

        jspFragment.invoke(null);
    }
}
