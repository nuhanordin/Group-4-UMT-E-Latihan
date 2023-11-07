<%-- 
    Document   : profile
    Created on : 10 Jun 2023, 1:06:29 pm
    Author     : nuha
--%>

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
                    <h1 class="content-title">Profile</h1>
                    <div class="row">
                        <div class="col-md-4">
                            <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                                <img alt="me"class="rounded-circle mt-5" width="150px" src="img/staff.jpg">
                                <span class="labels"><%=((Profile) session.getAttribute("profile")).getName()%></span>
                                <span class="labels"><%=((Profile) session.getAttribute("profile")).getGender()%></span>
                                <span class="labels"><%=((Profile) session.getAttribute("profile")).getStaffid()%></span>
                                <div class="mt-5 text-center">
                                    <form action="Profile" method="post">
                                        <input type="hidden" name="action" value="delete">
                                        <input type="hidden" name="id" value="<%=((Profile) session.getAttribute("profile")).getId()%>">
                                        <button class=" btn-danger btn-lg" type="submit" onclick="return confirm('Are you sure you want to delete your account?')">Delete Account</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-8">
                            <div class="p-3 py-5">
                                <div class="d-flex justify-content-between align-items-center mb-3">
                                </div>

                                <form action="edit" method="post">
                                    <input type="hidden" name="action" value="edit">
                                    <input type="hidden" name="id" value="<%=((Profile) session.getAttribute("profile")).getId()%>">

                                    <div class="row mt-2">
                                        <div class="col-md-12">
                                            <label class="labels">Email</label>
                                            <input type="text" class="form-control" name="email" value="<%=((Profile) session.getAttribute("profile")).getEmail()%>">
                                        </div>      
                                    </div>

                                    <div class="row mt-2">
                                        <div class="col-md-12">
                                            <label class="labels">Ic Number</label>
                                            <input type="text" class="form-control" name="ic" value="<%=((Profile) session.getAttribute("profile")).getIc()%>">
                                        </div>      
                                    </div>

                                    <div class="row mt-3">
                                        <div class="col-md-12">
                                            <label class="labels">Address</label>
                                            <input type="text" class="form-control" name="address" value="<%=((Profile) session.getAttribute("profile")).getAddress()%>">
                                        </div>
                                    </div>

                                    <div class="row mt-3">
                                        <div class="col-md-6">
                                            <label class="labels">Grade</label>
                                            <input type="text" class="form-control" name="grade" value="<%=((Profile) session.getAttribute("profile")).getGrade()%>">
                                        </div>
                                        <div class="col-md-6">
                                            <label class="labels">KPI</label>
                                            <input type="text" class="form-control" name="kpi" value="<%=((Profile) session.getAttribute("profile")).getKpi()%>">
                                        </div>
                                    </div>

                                    <div class="row mt-2">
                                        <div class="col-md-12">
                                            <label class="labels">Phone Number</label>
                                            <input type="text" class="form-control" name="contact" value="<%=((Profile) session.getAttribute("profile")).getContact()%>">
                                        </div>      
                                    </div>

                                    <div class="row mt-4">
                                        <div class="col-md-12 text-center">
                                            <button type="submit" class="btn btn-primary profile-button" onclick="return confirm('Are you sure you want to update your profile?')">Update Profile</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
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
