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
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

    private ProfileDao profileDao;

    public void init() {
        try {
            profileDao = new ProfileDao();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String ic = request.getParameter("ic");
        String gender = request.getParameter("gender");
        String kpi = request.getParameter("kpi");
        String contact = request.getParameter("contact");
        String staffid = request.getParameter("staffid");
        String grade = request.getParameter("grade");
        String address = request.getParameter("address");

        Profile profile = new Profile();
        profile.setName(name);
        profile.setEmail(email);
        profile.setPassword(password);
        profile.setIc(ic);
        profile.setGender(gender);
        profile.setKpi(kpi);
        profile.setContact(contact);
        profile.setStaffid(staffid);
        profile.setGrade(grade);
        profile.setAddress(address);

        try {
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            session.setAttribute("email", email);

            if (profileDao.emailExists(email)) {
                response.sendRedirect("register.jsp?status=emailExists");
            } else {
                profileDao.insert(profile);
                request.setAttribute("status", "success");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            response.sendRedirect("register.jsp");
        }
    }

    public void destroy() {
        try {
            profileDao.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
