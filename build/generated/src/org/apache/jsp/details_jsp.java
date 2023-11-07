package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.model.Course;
import java.util.List;
import java.util.List;
import com.model.Profile;

public final class details_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Profile</title>    \n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <!-- Font Icon -->\n");
      out.write("        <!--        <link rel=\"stylesheet\" href=\"fonts/material-icon/css/material-design-iconic-font.min.css\">-->\n");
      out.write("\n");
      out.write("        <!-- Main css -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- header start -->\n");
      out.write("        <header class=\"header\">\n");
      out.write("            <section class=\"flex\">\n");
      out.write("                <a href=\"index.html\" class=\"logo\"> E-Latihan </a>\n");
      out.write("\n");
      out.write("                <form action=\"\" method=\"post\" class=\"search-form\">\n");
      out.write("                    <input type=\"text\" name=\"searchbox\" placeholder=\"search course\" required maxlength=\"100\">\n");
      out.write("                    <button type=\"submit\" class=\"fas fa-search\" name=\"searchbox\"></button>\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("                <div class=\"icons\">\n");
      out.write("                    <div id=\"menu-btn\" class=\"fas fa-bars\"></div>\n");
      out.write("                    <div id=\"search-btn\" class=\"fas fa-search\"></div>\n");
      out.write("                    <div id=\"user-btn\" class=\"fas fa-user\"></div>\n");
      out.write("                    <div id=\"toggle-btn\" class=\"fas fa-sun\"></div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"profile\">\n");
      out.write("                    <img src=\"img/20210918165722174.jpg\" alt=\"me\"> \n");
      out.write("                    <h3>");
      out.print(((Profile) session.getAttribute("profile")).getName());
      out.write("</h3>\n");
      out.write("                    <span> Staff </span>  \n");
      out.write("                    <a href=\"profile.html\" class=\"btn\"> View profile </a>\n");
      out.write("                    <a href=\"logout.jsp\" class=\"option-btn\">Logout</a> \n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("        </header>\n");
      out.write("        <!-- header end -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- side bar start -->\n");
      out.write("        <div class=\"side-bar\">\n");
      out.write("            <div class=\"close-side-bar\">\n");
      out.write("                <i class=\"fas fa-times\"></i>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"profile\">\n");
      out.write("                <img src=\"img/20210918165722174.jpg\" alt=\"me\"> \n");
      out.write("                <h3>");
      out.print(((Profile) session.getAttribute("profile")).getName());
      out.write("</h3>\n");
      out.write("                <span> Staff </span>  \n");
      out.write("                <a href=\"profile.jsp\" class=\"btn\"> View profile </a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <nav class=\"navbar\">\n");
      out.write("\n");
      out.write("                <a href=\"Courses\"><i class=\"fas fa-question\"></i><span> Courses </span></a>       \n");
      out.write("                <a href=\"mycourse.jsp\"><i class=\"fas fa-chalkboard-user\"></i><span> MyCourse </span></a>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("        <!-- side bar end -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- content start -->\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <h1 class=\"content-title\">Courses</h1>\n");
      out.write("                <table class=\"table table-bordered\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Course ID</th>\n");
      out.write("                            <th>Course Name</th>\n");
      out.write("                            <th>Grade</th>\n");
      out.write("                            <th>Date</th>\n");
      out.write("                            <th>Action</th>\n");
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");

                            List<Course> listcourse = (List<Course>) request.getAttribute("listCourses");
                            for (Course tdl : listcourse) {
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                ");
      out.print(tdl.getId());
      out.write("\n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("                            <td>\n");
      out.write("                                ");
      out.print(tdl.getCoursename());
      out.write("\n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("                            <td>\n");
      out.write("                                ");
      out.print(tdl.getGrade());
      out.write("\n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("                            <td>\n");
      out.write("                                ");
      out.print(tdl.getDate());
      out.write("\n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("                            <td>\n");
      out.write("                                <a href=\"viewdetails?id=");
      out.print(tdl.getId());
      out.write("\" class=\"btn-primary\"> Details </a> &nbsp; &nbsp; &nbsp;\n");
      out.write("                                <a href=\"register?id=");
      out.print(tdl.getId());
      out.write("\" class=\"btn-primary\" onclick=\"return confirm('Are you sure you confirm?')\"> Register </a>\n");
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
 }
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- content end -->\n");
      out.write("\n");
      out.write("        <!-- footer start -->\n");
      out.write("\n");
      out.write("        <footer class=\"footer\">\n");
      out.write("            &copy; copyright @ 2023 by <span> Group 4 </span> | all rights \n");
      out.write("            reserved \n");
      out.write("        </footer>\n");
      out.write("\n");
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
      out.write("\n");
      out.write("\n");
      out.write("//            document.getElementById(\"deleteProfileLink\").addEventListener(\"click\", function (event) {\n");
      out.write("//                event.preventDefault(); // Prevent the link from navigating to a different page\n");
      out.write("//                if (confirm(\"Are you sure you want to delete your profile? This action cannot be undone.\")) {\n");
      out.write("//                    // Submit the hidden form to trigger the profile deletion\n");
      out.write("//                    document.getElementById(\"deleteProfileForm\").submit();\n");
      out.write("//                }\n");
      out.write("//            });\n");
      out.write("\n");
      out.write("        </script>\n");
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
