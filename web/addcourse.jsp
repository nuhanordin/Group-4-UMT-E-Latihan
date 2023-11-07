<%-- 
    Document   : addcourse
    Created on : 13 Jun 2023, 12:33:47 pm
    Author     : nuha
--%>

<%@page import="com.model.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.model.Profile"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="css/style.css?v=1.0">
    </head>

    <body class="active">

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
                    <div id="search-btn" class="fas fa-search"></div>
                    <div id="user-btn" class="fas fa-user"></div>
                </div>

                <div class="profile">
                    <img src="img/admin.jpg" alt="me"> 
                    <h3><%=((Profile) session.getAttribute("profile")).getName()%></h3>
                    <span> Admin </span>  
                    <div class="row">
                        <div class="col-md-6">                    
                            <a href="Admin" class="btn"> View Courses </a>
                        </div>
                        <div class="col-md-6">                    
                            <a href="addcourse.jsp" class="btn"> Add Courses </a>
                        </div>
                    </div>
                    <a href="logout.jsp" class="option-btn">Logout</a> 
                </div>
            </section>
        </header>
        <!-- header end -->

        <!-- content start -->
        <div class="main">
            <section class="content">
                <div class="container">
                    <h1 class="content-title">Add New Course</h1>
                    <form method="post" action="addcourse" class="form-signup">

                        <div class="row">
                            <div class="col-md-12">
                                <div class="p-3 py-5">
                                    <div class="d-flex justify-content-between align-items-center mb-3">
                                    </div>

                                    <div class="row mt-2">
                                        <div class="col-md-6">
                                            <label class="labels">Course Name</label><br>
                                            <input type="text" class="form-control" placeholder="Enter course name" name="coursename" required>
                                        </div> 
                                        <div class="col-md-6">
                                            <label class="labels">Instructor Name</label><br>
                                            <input type="text" class="form-control" placeholder="Enter instructor name" name="instructor" required>
                                        </div> 
                                    </div>

                                    <div class="row mt-2">
                                        <div class="col-md-6">
                                            <label class="labels">Date</label><br>
                                            <input type="date" class="form-control" placeholder="Enter date" name="date" required>
                                        </div> 
                                        <div class="col-md-6">
                                            <label class="labels">Category</label><br>
                                            <input type="text" class="form-control" placeholder="Enter course category" name="category" required>
                                        </div> 
                                    </div>

                                    <div class="row mt-2">
                                        <div class="col-md-6">
                                            <label class="labels">Duration</label><br>
                                            <input type="text" class="form-control" placeholder="Enter duration" name="duration" required>
                                        </div> 
                                        <div class="col-md-6">
                                            <label class="labels">Participant Limit</label><br>
                                            <input type="number" class="form-control" placeholder="Enter participant limit" name="maximum" required>
                                        </div> 
                                    </div>

                                    <div class="row mt-2">
                                        <div class="col-md-6">
                                            <label class="labels">Venue</label><br>
                                            <input type="text" class="form-control" placeholder="Enter venue" name="venue" required>
                                        </div> 
                                        <div class="col-md-6">
                                            <label class="labels">About Course</label><br>
                                            <input type="text" class="form-control" placeholder="Enter about this course" name="about" required>
                                        </div> 
                                    </div>

                                    <div class="row mt-2">
                                        <div class="col-md-6">
                                            <label class="labels">Grade</label><br>
                                            <input type="text" class="form-control" placeholder="Enter grade eligibity" name="grade" required>
                                        </div> 
                                        <div class="col-md-6">
                                            <label class="labels">Course Lesson</label><br>
                                            <input type="text" class="form-control" placeholder="Enter course lessons" name="lesson" required>
                                        </div> 
                                    </div>

                                    <div class="mt-5 text-center">
                                        <button class="btn btn-primary profile-button" type="submit">Add Course</button>
                                    </div>
                                </div>
                            </div>
                        </div>                        
                    </form>
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

