<%-- 
    Document   : details.jsp
    Created on : 12 Jun 2023, 11:53:47 pm
    Author     : nuha
--%>

<%@page import="com.model.Course"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="com.model.Profile"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>    
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="css/style.css?v=1.0">
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
                    <h3><%= ((Profile) session.getAttribute("profile")).getName()%></h3>
                    <span> Staff </span>  
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
                <h3><%=((Profile) session.getAttribute("profile")).getName()%></h3>
                <span> Staff </span>  
                <a href="profile.jsp" class="btn"> View profile </a>
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
                    <div class="row">
                        <% List<Course> courses = (List<Course>) request.getAttribute("courseDetails"); %>
                        <% for (Course course : courses) {%>
                        <h1 class="content-title"><%=course.getCoursename()%> Details </h1>
                        <%-- Display the course details --%>
                        <div class="row details-text">
                            <div class="col-md-4">
                                <p>Date: <%= course.getDate() != null ? new java.text.SimpleDateFormat("yyyy-MM-dd").format(course.getDate()) : ""%></p>
                                <p>Duration: <%= course.getDuration()%></p>
                                <p>Venue: <%= course.getVenue()%></p>
                                <p>Instructor: <%= course.getInstructor()%></p>
                                <p>Grade: <%= course.getGrade()%></p>
                            </div>

                            <div class="col-md-4">
                                <p>Category: <%= course.getCategory()%></p>
                                <p>Maximum: <%= course.getMaximum()%></p>
                                <p>About: <%= course.getAbout()%></p>
                                <p>Lesson: <%= course.getLesson()%></p>
                            </div>
                        </div>
                        <% }%> 
                    </div>
                    <a href="Courses" class="btn-primary btn-lg" style="text-decoration: none;">Back to Course List</a>
                    <br><br>
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
