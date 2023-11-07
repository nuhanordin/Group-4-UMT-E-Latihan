/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.dao.CourseDao;
import com.model.Course;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

/**
 *
 * @author nuha
 */
@WebServlet(urlPatterns = {"/Admin", "/viewparticipant", "/delete", "/addcourse", "/updateCourseStatus"})
public class AdminServlet extends HttpServlet {

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
                case "/viewparticipant":
                    viewParticipant(request, response);
                    break;
                case "/delete":
                    deleteCourse(request, response);
                    break;
                case "/addcourse":
                    addCourse(request, response);
                    break;
                case "/updateCourseStatus":
                    updateStatus(request, response);
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

    private void viewAllCourse(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Course> listCourse = courseDao.selectAllCourse();
        request.setAttribute("listCourses", listCourse);
        RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
        rd.forward(request, response);
    }

    private void viewParticipant(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int courseId = Integer.parseInt(request.getParameter("id"));

        List<String> registeredProfileNames;
        try {
            CourseDao dao = (CourseDao) getServletContext().getAttribute("courseDao");
            registeredProfileNames = dao.getRegisteredProfileNames(courseId);
        } catch (SQLException e) {
            throw new ServletException(e);
        }

        request.setAttribute("registeredProfileNames", registeredProfileNames);
        RequestDispatcher rd = request.getRequestDispatcher("/participant.jsp");
        rd.forward(request, response);

    }

    private void deleteCourse(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int courseId = Integer.parseInt(request.getParameter("id"));

        try {
            courseDao.deleteCourse(courseId);
            response.sendRedirect("Admin");
        } catch (SQLException e) {
            response.sendRedirect("error.jsp");
        }
    }

    private void addCourse(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException, ServletException {
    // Retrieve the course details from the request parameters
    String courseName = request.getParameter("coursename");
    String dateString = request.getParameter("date");
    String duration = request.getParameter("duration");
    String venue = request.getParameter("venue");
    String instructor = request.getParameter("instructor");
    String grade = request.getParameter("grade");
    String category = request.getParameter("category");
    int maximum = Integer.parseInt(request.getParameter("maximum"));
    String about = request.getParameter("about");
    String lesson = request.getParameter("lesson");

    // Parse the date string to java.util.Date
    java.util.Date utilDate = null;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    try {
        utilDate = dateFormat.parse(dateString);
    } catch (ParseException e) {
        e.printStackTrace();
    }

    // Convert java.util.Date to java.sql.Date
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

    // Create a new Course object
    Course newCourse = new Course(courseName, sqlDate, duration, venue, instructor, grade, category, maximum, about, lesson);

    try {
        // Call the insertCourse method
        courseDao.insertCourse(newCourse);

        // Redirect to a success page or display a success message
        response.sendRedirect("Admin");
    } catch (SQLException e) {
        // Handle any database-related errors
        response.sendRedirect("error.jsp");
    }
}


    private void updateStatus(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int courseId = Integer.parseInt(request.getParameter("course_id"));
        String profileName = request.getParameter("profile_name");
        String courseStatus = request.getParameter("course_status");

        try {
            // Update the course status in the database
            courseDao.updateCourseStatus(courseId, profileName, courseStatus);
            response.sendRedirect("Admin");
            // Redirect or forward to the desired page
        } catch (SQLException e) {
            // Handle any exceptions
        }
    }

}
