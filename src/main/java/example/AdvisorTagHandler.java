package example;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class AdvisorTagHandler extends SimpleTagSupport { // SimpleTagSupport implements things we need in custom tags.
    private String user;

    //The Container calls doTag() when the JSP invokes the tag using the name declared in the TLD.
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().write("Hello " + user + " <br>");
        getJspContext().getOut().write("Your advice is: " + getAdvice());
    }

    //The Container calls this method to set the value from the tag attribute. It uses JavaBean property naming conventions to figure out that a “user” attribute should be sent to the setUser() method.
    public void setUser(String user) {
        this.user = user;
    }

    //Our own internal method.
    String getAdvice() {
        String[] adviceStrings = {"That color’s not working for you.",
                "You should call in sick.", "You might want to rethink that haircut."};
        int random = (int) (Math.random() * adviceStrings.length);
        return adviceStrings[random];
    }
}