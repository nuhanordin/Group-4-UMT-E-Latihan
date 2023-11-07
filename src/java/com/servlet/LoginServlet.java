/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.dao.ProfileDao;
import com.model.Profile;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        try {
            ProfileDao profileDao = new ProfileDao();
            boolean isValidLogin = profileDao.validateLogin(email, password);
            profileDao.closeConnection();

            if (isValidLogin) {
                ProfileDao dao = new ProfileDao();
                Profile profile = dao.getUserByEmail(email);

                if (profile != null) {
                    // Set session attributes
                    HttpSession session = request.getSession();
                    session.setAttribute("profile", profile);
                    session.setAttribute("role", role);

                    switch (role) {
                        case "Staff":
                            // Redirect to staff profile page
                            response.sendRedirect("profile.jsp");
                            break;
                        case "Admin":
                            // Redirect to admin page
                            response.sendRedirect("Admin");
                            break;
                        default:
                            // Invalid role, redirect back to the login page with an error message
                            response.sendRedirect("login.jsp?error=Invalid role");
                            break;
                    }
                } else {
                    // User not found, handle the error appropriately
                    response.sendRedirect("login.jsp?error=User not found");
                }
            } else {
                // Login failed, redirect back to the login page with an error message
                response.sendRedirect("login.jsp?error=Invalid credentials");
            }
        } catch (SQLException | ClassNotFoundException e) {
            // Handle the exception appropriately, e.g., redirect to an error page
            response.sendRedirect("error.jsp");
        }
    }
    
}
