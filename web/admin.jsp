<%-- 
    Document   : admin
    Created on : 12 Jun 2023, 2:46:37 pm
    Author     : nuha
--%>
<%@page import="java.util.Date"%>
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
                    <div class="row">
                        <h1 class="content-title">Courses</h1>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Course ID</th>
                                    <th>Course Name</th>
                                    <th>Grade</th>
                                    <th>Date</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    List<Course> listcourse = (List<Course>) request.getAttribute("listCourses");
                                    for (Course crs : listcourse) {
                                        if (crs.getDate() != null && crs.getDate().before(new Date())) {
                                %>
                                <!-- Display the course details in the "Past Courses" table -->
                                <tr>
                                    <td>
                                        <%=crs.getId()%>
                                    </td>
                                    <td>
                                        <%=crs.getCoursename()%>
                                    </td>
                                    <td>
                                        <%=crs.getGrade()%>
                                    </td>
                                    <td>
                                        <%=new java.text.SimpleDateFormat("yyyy-MM-dd").format(crs.getDate())%>
                                    </td>
                                    <td>
                                        <a href="viewparticipant?id=<%=crs.getId()%>" class="btn-primary btn-lg" style="text-decoration: none;"> View Participants </a>
                                        &nbsp; &nbsp;
                                        <a href="delete?id=<%=crs.getId()%>" class="btn-danger btn-lg" style="text-decoration: none;" onclick="return confirm('Are you sure to delete?')"> Delete </a>
                                    </td>
                                </tr>
                                <% } else {%>
                                <!-- Display the course details in the existing table -->
                                <tr>
                                    <td>
                                        <%=crs.getId()%>
                                    </td>
                                    <td>
                                        <%=crs.getCoursename()%>
                                    </td>
                                    <td>
                                        <%=crs.getGrade()%>
                                    </td>
                                    <td>
                                        <%=new java.text.SimpleDateFormat("yyyy-MM-dd").format(crs.getDate())%>
                                    </td>
                                    <td>
                                        <a href="viewparticipant?id=<%=crs.getId()%>" class="btn-primary btn-lg" style="text-decoration: none;"> View Participants </a>
                                        &nbsp; &nbsp;
                                        <a href="delete?id=<%=crs.getId()%>" class="btn-danger btn-lg" style="text-decoration: none;" onclick="return confirm('Are you sure to delete?')"> Delete </a>
                                    </td>
                                </tr>
                                <% }
                                    } %>
                            </tbody>
                        </table>

                        <div class="row">
                            <div class="col-md-4">
                                <br><a href="addcourse.jsp" class="btn-primary btn-lg" style="text-decoration: none;"> Add Course </a>                                    
                            </div>
                        </div>
                        <h1 class="content-title">Past Courses</h1>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Course ID</th>
                                    <th>Course Name</th>
                                    <th>Grade</th>
                                    <th>Date</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for (Course crs : listcourse) {
                                        if (crs.getDate() != null && crs.getDate().before(new Date())) {
                                %>
                                <!-- Display the course details in the "Past Courses" table -->
                                <tr>
                                    <td>
                                        <%=crs.getId()%>
                                    </td>
                                    <td>
                                        <%=crs.getCoursename()%>
                                    </td>
                                    <td>
                                        <%=crs.getGrade()%>
                                    </td>
                                    <td>
                                        <%=new java.text.SimpleDateFormat("yyyy-MM-dd").format(crs.getDate())%>
                                    </td>
                                    <td>
                                        <a href="viewparticipant?id=<%=crs.getId()%>" class="btn-primary btn-lg" style="text-decoration: none;"> View Participants </a>
                                        &nbsp; &nbsp;
                                    </td>
                                </tr>
                                <% }
                                    }%>
                            </tbody>
                        </table>
                    </div>
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
