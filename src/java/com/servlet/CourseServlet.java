/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.dao.CourseDao;
import com.model.Course;
import com.model.Profile;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nuha
 */
@WebServlet(urlPatterns = {"/Courses", "/viewdetails", "/register"})
public class CourseServlet extends HttpServlet {

    private CourseDao courseDao;

    public void init() throws ServletException {
        try {
            super.init();
            ServletContext context = getServletContext();
            courseDao = new CourseDao(); // Initialize the courseDao object
            context.setAttribute("courseDao", courseDao);
        } catch (SQLException ex) {
            Logger.getLogger(CourseServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CourseServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getServletPath();

            switch (action) {
                case "/viewdetails":
                    viewDetails(request, response);
                    break;
                case "/register":
                    registerCourse(request, response);
                    break;
                default:
                    viewAllCourse(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void viewDetails(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        // Retrieve the course ID from the request parameters
        int courseId = Integer.parseInt(request.getParameter("id"));

        // Fetch the course details from the database using CourseDao
        CourseDao courseDao = (CourseDao) getServletContext().getAttribute("courseDao");
        List<Course> courseDetails = courseDao.selectAllDetails(courseId);

        // Set the list of course details as an attribute in the request
        request.setAttribute("courseDetails", courseDetails);

        // Forward the request to the details.jsp file for displaying the course details
        RequestDispatcher rd = request.getRequestDispatcher("details.jsp");
        rd.forward(request, response);
    }

    private void viewAllCourse(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Course> listCourse = courseDao.selectAllCourse();
        request.setAttribute("listCourses", listCourse);
        RequestDispatcher rd = request.getRequestDispatcher("/courses.jsp");
        rd.forward(request, response);
    }


    private void registerCourse(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        // Get the user ID from the session
        HttpSession session = request.getSession();
        String profileName = ((Profile) session.getAttribute("profile")).getName(); // Assuming the attribute name is "profile" and the name is stored as a String

        if (profileName != null) {
            int courseId = Integer.parseInt(request.getParameter("id"));
            String courseStatus = "Registered";
            // Register the course
            courseDao.registerCourse(profileName, courseId, courseStatus);

            // Redirect to a success page or perform any other action
            response.sendRedirect("mycourse.jsp");
        } else {
            String errorMessage = "Profile name not found in session.";
            request.setAttribute("errorMessage", errorMessage);
            response.sendRedirect("error.jsp"); // Handle the case when the "profile" attribute is not set in the session
            // Display an error message or redirect to a login page
        }
    }

}
