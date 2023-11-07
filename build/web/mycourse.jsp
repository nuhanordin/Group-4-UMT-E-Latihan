<%-- 
    Document   : mycourse
    Created on : 12 Jun 2023, 8:40:49 am
    Author     : nuha
--%>

<%@page import="com.dao.CourseDao"%>
<%@page import="com.model.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.model.Profile"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>    
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css?v=1.0">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>    
    </head>
    <body>

        <%
            Profile profile = (Profile) session.getAttribute("profile");
            if (profile == null) {
                // Redirect to login.jsp
                response.sendRedirect("login.jsp");
                return;
            }
        %>

        <!-- header start -->
        <header class="header">
            <section class="flex">
                <h1> E-Latihan </h1>

                <div class="icons">
                    <div id="menu-btn" class="fas fa-bars"></div>
                    <div id="search-btn" class="fas fa-search"></div>
                    <div id="user-btn" class="fas fa-user"></div>
                </div>

                <div class="profile">
                    <img src="img/staff.jpg" alt="me"> 
                    <h3><%=((Profile) session.getAttribute("profile")).getName()%></h3>
                    <span> Student </span>  
                    <a href="profile.jsp" class="btn"> View profile </a>
                    <a href="logout.jsp" class="option-btn">Logout</a> 
                </div>
            </section>
        </header>
        <!-- header end -->

        <!-- side bar start -->
        <div class="side-bar">
            <div class="close-side-bar">
                <i class="fas fa-times"></i>
            </div>

            <div class="profile">
                <img src="img/staff.jpg" alt="me"> 
                <%
                    if (profile != null) {
                %>
                <h3><%= profile.getName()%></h3>
                <span> Staff </span>  
                <a href="profile.jsp" class="btn"> View profile </a>
                <% } else { %>
                <h3>Error: Session expired</h3>
                <span>Please login again</span>
                <% } %>
            </div>

            <nav class="navbar">
                <a href="Courses"><i class="fas fa-question"></i><span> Courses </span></a>       
                <a href="mycourse.jsp"><i class="fas fa-chalkboard-user"></i><span> MyCourse </span></a>
            </nav>
        </div>
        <!-- side bar end -->

        <!-- content start -->
        <div class="main">
            <section class="content">
                <div class="container">
                    <h1 class="content-title">MyCourse</h1>

                    <!-- Course Progress Table -->
                    <div class="table-container">
                        <h2>Course Progress</h2>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Course ID</th>
                                    <th>Course Name</th>
                                    <th>Date</th>
                                    <th>Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    // Instantiate the CourseDao object
                                    CourseDao courseDao = new CourseDao();

                                    // Get the user's profile from the session
                                    Profile userProfile = (Profile) session.getAttribute("profile");
                                    String userName = userProfile.getName();

                                    List<Course> registeredCourses = courseDao.getRegisteredCourses(userName);
                                %>
                                <% for (Course course : registeredCourses) {
                                        if (!course.getCourseStatus().equals("Completed")) {
                                %>
                                <tr>
                                    <td><%= course.getId()%></td>
                                    <td><%= course.getCoursename()%></td>
                                    <td><%= course.getDate() != null ? new java.text.SimpleDateFormat("yyyy-MM-dd").format(course.getDate()) : ""%></td>
                                    <td><%= course.getCourseStatus()%></td>
                                </tr>
                                <% }
                                    } %>
                            </tbody>                                                
                        </table>
                    </div>

                    <%
                        int completedCourseCount = 0;
                        for (Course course : registeredCourses) {
                            if (course.getCourseStatus().equals("Completed")) {
                                completedCourseCount++;
                            }
                        }
                    %>
                    <!-- Completed Course Table -->
                    <div class="table-container">
                        <h2>Completed Course  
                            <button class="btn-primary btn-lg" disabled><%= completedCourseCount %></button>

                        </h2>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Course Name</th>
                                    <th>Date</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for (Course course : registeredCourses) {
                                        if (course.getCourseStatus().equals("Completed")) {
                                %>
                                <tr>
                                    <td><%= course.getCoursename()%></td>
                                    <td><%= course.getDate() != null ? new java.text.SimpleDateFormat("yyyy-MM-dd").format(course.getDate()) : ""%></td>
                                </tr>
                                <% }
                                    }%>
                            </tbody>
                        </table>
                    </div>
            </section>
        </div>
        <!-- content end -->

        <!-- footer start -->
        <footer class="footer">
            &copy; copyright @ 2023 by <span> Group 4 </span> | all rights 
            reserved 
        </footer>
        <!-- footer end -->

        <script>

            let body = document.body;

            let profile = document.querySelector('.header .flex .profile');

            document.querySelector('#user-btn').onclick = () => {
                profile.classList.toggle('active');
                searchForm.classList.remove('active');
            };

            let searchForm = document.querySelector('.header .flex .search-form');

            document.querySelector('#search-btn').onclick = () => {
                searchForm.classList.toggle('active');
                profile.classList.remove('active');
            };

            let sideBar = document.querySelector('.side-bar');

            document.querySelector('#menu-btn').onclick = () => {
                sideBar.classList.toggle('active');
                body.classList.toggle('active');
            };

            window.onscroll = () => {
                profile.classList.remove('active');
                searchForm.classList.remove('active');
            };

        </script>
    </body>
</html>

