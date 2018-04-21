package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import java.io.IOException;
import java.io.StringWriter;

public class UpperCase extends SimpleTagDemo {

    @Override
    public void doTag() throws JspException, IOException {
        JspFragment jspFragment = this.getJspBody();
        StringWriter sw = new StringWriter();
        jspFragment.invoke(sw);
        String content = sw.getBuffer().toString();
        content = content.toUpperCase();
        PageContext pageContext = (PageContext)jspFragment.getJspContext();
        pageContext.getOut().write(content);
    }
}
