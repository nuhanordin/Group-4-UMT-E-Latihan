package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.model.Course;
import java.util.List;
import com.model.Profile;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class addcourse_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Profile</title>    \n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css?v=1.0\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body class=\"active\">\n");
      out.write("\n");
      out.write("        ");

            Profile profile = (Profile) session.getAttribute("profile");
            if (profile == null) {
                // Redirect to login.jsp
                response.sendRedirect("login.jsp");
                return;
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <!-- header start -->\n");
      out.write("        <header class=\"header\">\n");
      out.write("            <section class=\"flex\">\n");
      out.write("                <h1> E-Latihan </h1>\n");
      out.write("\n");
      out.write("                <div class=\"icons\">\n");
      out.write("                    <div id=\"search-btn\" class=\"fas fa-search\"></div>\n");
      out.write("                    <div id=\"user-btn\" class=\"fas fa-user\"></div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"profile\">\n");
      out.write("                    <img src=\"img/admin.jpg\" alt=\"me\"> \n");
      out.write("                    <h3>");
      out.print(((Profile) session.getAttribute("profile")).getName());
      out.write("</h3>\n");
      out.write("                    <span> Admin </span>  \n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-6\">                    \n");
      out.write("                            <a href=\"Admin\" class=\"btn\"> View Courses </a>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-6\">                    \n");
      out.write("                            <a href=\"addcourse.jsp\" class=\"btn\"> Add Courses </a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <a href=\"logout.jsp\" class=\"option-btn\">Logout</a> \n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("        </header>\n");
      out.write("        <!-- header end -->\n");
      out.write("\n");
      out.write("        <!-- content start -->\n");
      out.write("        <div class=\"main\">\n");
      out.write("            <section class=\"content\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <h1 class=\"content-title\">Add New Course</h1>\n");
      out.write("                    <form method=\"post\" action=\"addcourse\" class=\"form-signup\">\n");
      out.write("\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                <div class=\"p-3 py-5\">\n");
      out.write("                                    <div class=\"d-flex justify-content-between align-items-center mb-3\">\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"row mt-2\">\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <label class=\"labels\">Course Name</label><br>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" placeholder=\"Enter course name\" name=\"coursename\" required>\n");
      out.write("                                        </div> \n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <label class=\"labels\">Instructor Name</label><br>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" placeholder=\"Enter instructor name\" name=\"instructor\" required>\n");
      out.write("                                        </div> \n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"row mt-2\">\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <label class=\"labels\">Date</label><br>\n");
      out.write("                                            <input type=\"date\" class=\"form-control\" placeholder=\"Enter date\" name=\"date\" required>\n");
      out.write("                                        </div> \n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <label class=\"labels\">Category</label><br>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" placeholder=\"Enter course category\" name=\"category\" required>\n");
      out.write("                                        </div> \n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"row mt-2\">\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <label class=\"labels\">Duration</label><br>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" placeholder=\"Enter duration\" name=\"duration\" required>\n");
      out.write("                                        </div> \n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <label class=\"labels\">Participant Limit</label><br>\n");
      out.write("                                            <input type=\"number\" class=\"form-control\" placeholder=\"Enter participant limit\" name=\"maximum\" required>\n");
      out.write("                                        </div> \n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"row mt-2\">\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <label class=\"labels\">Venue</label><br>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" placeholder=\"Enter venue\" name=\"venue\" required>\n");
      out.write("                                        </div> \n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <label class=\"labels\">About Course</label><br>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" placeholder=\"Enter about this course\" name=\"about\" required>\n");
      out.write("                                        </div> \n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"row mt-2\">\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <label class=\"labels\">Grade</label><br>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" placeholder=\"Enter grade eligibity\" name=\"grade\" required>\n");
      out.write("                                        </div> \n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <label class=\"labels\">Course Lesson</label><br>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" placeholder=\"Enter course lessons\" name=\"lesson\" required>\n");
      out.write("                                        </div> \n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"mt-5 text-center\">\n");
      out.write("                                        <button class=\"btn btn-primary profile-button\" type=\"submit\">Add Course</button>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>                        \n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("        </div>\n");
      out.write("        <!-- content end -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- footer start -->\n");
      out.write("        <footer class=\"footer\">\n");
      out.write("            &copy; copyright @ 2023 by <span> Group 4 </span> | all rights \n");
      out.write("            reserved \n");
      out.write("        </footer>\n");
      out.write("        <!-- footer end -->\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("            let body = document.body;\n");
      out.write("\n");
      out.write("            let profile = document.querySelector('.header .flex .profile');\n");
      out.write("\n");
      out.write("            document.querySelector('#user-btn').onclick = () => {\n");
      out.write("                profile.classList.toggle('active');\n");
      out.write("                searchForm.classList.remove('active');\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            let searchForm = document.querySelector('.header .flex .search-form');\n");
      out.write("\n");
      out.write("            document.querySelector('#search-btn').onclick = () => {\n");
      out.write("                searchForm.classList.toggle('active');\n");
      out.write("                profile.classList.remove('active');\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            let sideBar = document.querySelector('.side-bar');\n");
      out.write("\n");
      out.write("            document.querySelector('#menu-btn').onclick = () => {\n");
      out.write("                sideBar.classList.toggle('active');\n");
      out.write("                body.classList.toggle('active');\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            window.onscroll = () => {\n");
      out.write("                profile.classList.remove('active');\n");
      out.write("                searchForm.classList.remove('active');\n");
      out.write("            };\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
