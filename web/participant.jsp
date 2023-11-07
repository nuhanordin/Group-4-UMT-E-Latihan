<%-- 
    Document   : participant
    Created on : 13 Jun 2023, 1:37:23 pm
    Author     : nuha
--%>

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
            Profile profiles = (Profile) session.getAttribute("profile");
            if (profiles == null) {
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

                        <h1 class="content-title">Participants</h1>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    List<String> registeredProfileNames = (List<String>) request.getAttribute("registeredProfileNames");
                                    int courseId = Integer.parseInt(request.getParameter("id"));

                                    // Loop through the registered profile names and display them
                                    for (String profileName : registeredProfileNames) {
                                        // Split the profileName to separate the profile name and course status
                                        String[] parts = profileName.split(" - ");
                                        String participant = parts[0];
                                        String courseStatus = parts[1];
                                %>
                                <tr>
                                    <td>
                                        <%= participant%>
                                    </td>
                                    <td> <form action="updateCourseStatus" method="POST">
                                            <input type="hidden" name="profile_name" value="<%= participant%>">
                                            <input type="hidden" name="course_id" value="<%= courseId%>">                                            
                                            <select name="course_status" id="course_status">
                                                <option value="Registered" <%= courseStatus.equals("Registered") ? "selected" : ""%>>Registered</option>                                  
                                                <option value="In Progress" <%= courseStatus.equals("In Progress") ? "selected" : ""%>>In Progress</option>
                                                <option value="Completed" <%= courseStatus.equals("Completed") ? "selected" : ""%>>Completed</option>
                                                <option value="Cancelled" <%= courseStatus.equals("Cancelled") ? "selected" : ""%>>Cancelled</option>
                                            </select>
                                            <button type="submit" class="btn-primary btn-lg" style="text-decoration: none;">Update</button>
                                        </form>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>
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

