package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("        <title>Register</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Font Icon -->\n");
      out.write("        <!--        <link rel=\"stylesheet\" href=\"fonts/material-icon/css/material-design-iconic-font.min.css\">-->\n");
      out.write("\n");
      out.write("        <!-- Main css -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <input type=\"hidden\" id=\"status\" value=\"");
      out.print( request.getAttribute("status"));
      out.write("\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <section class=\"signup\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div clas=\"signup-content\">\n");
      out.write("                    <h1 class=\"content-title\">Register</h1><div class=\"row\">\n");
      out.write("                        <div class=\"col-md-4\">\n");
      out.write("                            <div class=\"d-flex flex-column align-items-center text-center p-3 py-5\">\n");
      out.write("<img alt=\"me\" class=\"rounded-circle mt-5\" width=\"150px\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/img/logo.png\">\n");
      out.write("                                <span class=\"labels\">");
      out.print(request.getParameter("name"));
      out.write("</span>\n");
      out.write("                                <span class=\"labels\">");
      out.print(request.getParameter("gender"));
      out.write("</span>\n");
      out.write("                                <span class=\"labels\">");
      out.print(request.getParameter("staffid"));
      out.write("</span>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-8\">\n");
      out.write("                            <div class=\"p-3 py-5\">\n");
      out.write("                                <div class=\"d-flex justify-content-between align-items-center mb-3\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row mt-2\">\n");
      out.write("                                    <div class=\"col-md-12\"><label class=\"labels\">Email</label>\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"");
      out.print(request.getParameter("email"));
      out.write("\" value=\"\"></div>      \n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"row mt-2\">\n");
      out.write("                                    <div class=\"col-md-12\"><label class=\"labels\">Ic Number</label>\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"");
      out.print(request.getParameter("ic"));
      out.write("\" value=\"\"></div>      \n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"row mt-3\">\n");
      out.write("                                    <div class=\"col-md-12\"><label class=\"labels\">Address</label>\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"");
      out.print(request.getParameter("address"));
      out.write("\" value=\"\"></div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row mt-3\">\n");
      out.write("                                    <div class=\"col-md-6\"><label class=\"labels\">Grade</label>\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"");
      out.print(request.getParameter("grade"));
      out.write("\" value=\"\"></div>\n");
      out.write("                                    <div class=\"col-md-6\"><label class=\"labels\">KPI</label>\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" value=\"\" placeholder=\"");
      out.print(request.getParameter("kpi"));
      out.write("\"></div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"row mt-2\">\n");
      out.write("                                    <div class=\"col-md-12\"><label class=\"labels\">Phone Number</label>\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" placeholder=\"");
      out.print(request.getParameter("contact"));
      out.write("\" value=\"\"></div>      \n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"mt-5 text-center\"><button class=\"btn btn-primary profile-button\" type=\"button\">Save Profile</button></div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
