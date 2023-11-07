package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("<div class=\"main\">\n");
      out.write("\n");
      out.write("            <!-- Sign in  Form -->\n");
      out.write("            <section class=\"sign-in\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"signin-content\">\n");
      out.write("                        <div class=\"signin-image\">\n");
      out.write("                            <h1>UMT E-Latihan</h1>\n");
      out.write("                            <a href=\"registration.jsp\" class=\"signup-image-link\">Create an\n");
      out.write("                                account</a>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"signin-form\">\n");
      out.write("                            <h2 class=\"form-title\">Log in</h2>\n");
      out.write("                            <form method=\"post\" action=\"login\" class=\"register-form\"\n");
      out.write("                                  id=\"login-form\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"staffid\"><i\n");
      out.write("                                            class=\"zmdi zmdi-account material-icons-name\"></i></label> <input\n");
      out.write("                                        type=\"text\" name=\"staffid\" id=\"staffid\"\n");
      out.write("                                        placeholder=\"Your Staff Id\" required=\"required\"/>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"password\"><i \n");
      out.write("                                            class=\"zmdi zmdi-lock\"></i></label> <input\n");
      out.write("                                        type=\"password\" name=\"password\" id=\"password\"\n");
      out.write("                                        placeholder=\"Password\" required=\"required\"/>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <a href=\"forgotPass.jsp\"> Forgot Password? </a><br>\n");
      out.write("                                    <a href=\"registration.jsp\">Create an\n");
      out.write("                                account</a>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group form-button\">\n");
      out.write("                                    <input type=\"submit\" name=\"signin\" id=\"signin\"\n");
      out.write("                                           class=\"form-submit\" value=\"Log in\" />\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("\n");
      out.write("        </div>    \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
