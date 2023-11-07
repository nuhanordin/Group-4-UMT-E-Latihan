<%-- 
    Document   : login
    Created on : 11 Jun 2023, 1:32:44 am
    Author     : nuha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Login</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="alert/dist/sweetalert.css">
        <link rel="stylesheet" href="css/style.css?v=1.0">
    </head>

    <body class="active">

        <input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
        <div class="main">
            <section class="signup">
                <div class="container">
                    <div clas="signup-content">
                        <h1 class="signup-title">Login</h1>
                        <div class="row">
                            <div class="col-md-5">
                                <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                                    <img alt="me" class="rounded-circle" width="380px" src="img/logo.png">
                                    <a href="register.jsp" class="signup-image-link">Create an account</a>
                                </div>
                            </div>

                            <div class="col-md-7">
                                <div class="p-3 py-5">
                                    <div class="d-flex justify-content-between align-items-center mb-3">
                                    </div>
                                    <form method="post" action="Login" class="form-signup">
                                        <div class="row mt-2">
                                            <div class="col-md-4">
                                                <input type="radio" value="Staff" name="role">
                                                <label class="labels">Staff</label>
                                            </div>      

                                            <div class="col-md-4">
                                                <input type="radio" value="Admin" name="role">
                                                <label class="labels">Admin</label>
                                            </div> 
                                            <br><br><br><br>

                                            <div class="row mt-2">
                                                <div class="col-md-12">
                                                    <label class="labels">Email</label>
                                                    <input type="text" class="form-control" placeholder="Enter email" name="email" required>
                                                </div>      
                                            </div>

                                            <div class="row mt-2">
                                                <div class="col-md-12">
                                                    <label class="labels">Password</label>
                                                    <input type="password" class="form-control" placeholder="Enter password" name="password" required>
                                                </div>      
                                            </div>

                                            <div class="mt-5 text-center">
                                                <button class="btn btn-primary profile-button" type="submit">Login</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
            </section>
        </div>


        <script type="text/javascript">
            var urlParams = new URLSearchParams(window.location.search);
            var status = document.getElementById("status").value;

            if (status === "Invalid Role") {
                swal("Ops", "Wrong Id or Password Entered", "error");
            } else if (status === "Invalid credentials") {
                swal("Ops", "Enter Id", "error");
            } else if (status === "invalidPw") {
                swal("Ops", "Enter Password", "error");
            } else if (status === "resetSuccess") {
                swal("Congrats", "Password Reset Succesful", "success");
            } else if (status === "resetFailed") {
                swal("Ops", "Password Reset Failed", "error");
            }
        </script>
    </body>
</html>
