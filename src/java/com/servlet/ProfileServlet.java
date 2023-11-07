/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.dao.ProfileDao;
import com.model.Profile;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(urlPatterns = {"/Profile", "/edit"})
//@WebServlet("/Profile")
public class ProfileServlet extends HttpServlet {

    private ProfileDao profileDao; // Assuming you have a ProfileDao instance

    @Override
    public void init() throws ServletException {
        super.init();
        // Instantiate the ProfileDao object
        ServletContext context = getServletContext();
        profileDao = (ProfileDao) context.getAttribute("profileDao");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        String email = (String) session.getAttribute("email");
        String gender = (String) session.getAttribute("gender");
        String staffid = (String) session.getAttribute("staffid");
        String ic = (String) session.getAttribute("ic");
        String address = (String) session.getAttribute("address");
        String grade = (String) session.getAttribute("grade");
        String kpi = (String) session.getAttribute("kpi");
        String contact = (String) session.getAttribute("contact");

        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("gender", gender);
        request.setAttribute("staffid", staffid);
        request.setAttribute("ic", ic);
        request.setAttribute("address", address);
        request.setAttribute("grade", grade);
        request.setAttribute("kpi", kpi);
        request.setAttribute("contact", contact);

        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String action = request.getServletPath();

        if (action != null) {
            switch (action) {
                case "edit":
                    editProfile(request, response);
                    break;
                case "delete":
                    deleteProfile(request, response);
                    break;
                default:
                    response.sendRedirect("Profile"); // Redirect to the profile page
                    break;
            }
        } else {
            response.sendRedirect("Profile"); // Redirect to the profile page
        }
    }

    private void editProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String idString = request.getParameter("id");

    if (idString != null) {
        int id = Integer.parseInt(idString);
        String email = request.getParameter("email");
        String ic = request.getParameter("ic");
        String address = request.getParameter("address");
        String grade = request.getParameter("grade");
        String kpi = request.getParameter("kpi");
        String contact = request.getParameter("contact");

        try {
            Profile profile = profileDao.selectById(id);

            if (profile != null) {
                // Update the profile object with the new values
                profile.setEmail(email);
                profile.setIc(ic);
                profile.setAddress(address);
                profile.setGrade(grade);
                profile.setKpi(kpi);
                profile.setContact(contact);

                // Update the profile in the database
                profileDao.update(profile);
                request.setAttribute("successMessage", "Profile updated successfully");
            } else {
                // Profile not found
                request.setAttribute("errorMessage", "Profile not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Log the SQL exception
            Logger.getLogger(ProfileServlet.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", "An error occurred while updating the profile");
        }
    } else {
        // Invalid or missing id parameter
        request.setAttribute("errorMessage", "Invalid request");
    }

    response.sendRedirect("Profile"); // Redirect to the profile page
}


    private void deleteProfile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            ProfileDao profileDao = new ProfileDao();
            boolean deleted = profileDao.delete(id);
            profileDao.closeConnection();

            if (deleted) {
                // Delete successful
                response.sendRedirect("Register"); // Redirect to the profile page
            } else {
                // Delete failed
                response.sendRedirect("Profile?deleteError=true"); // Redirect to the profile page with an error parameter
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("Profile?deleteError=true"); // Redirect to the profile page with an error parameter
        }
    }
}
