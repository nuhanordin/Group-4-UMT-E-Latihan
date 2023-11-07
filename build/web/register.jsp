<%-- 
    Document   : register
    Created on : 10 Jun 2023, 4:09:31 pm
    Author     : nuha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Register</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" href="css/style.css?v=1.0">
    </head>

    <body class="active">

        <input type="hidden" id="status" value="<%=request.getAttribute("status")%>">
        <div class="main">
            <section class="signup">
                <div class="container">
                    <div clas="signup-content">
                        <h1 class="signup-title">Register</h1>
                        <div class="row">

                            <div class="col-md-6">
                                <div class="p-3 py-5">
                                    <div class="d-flex justify-content-between align-items-center mb-3">
                                    </div>
                                    <form method="post" action="Register" class="form-signup">
                                        <div class="row mt-2">
                                            <div class="col-md-12">
                                                <label class="labels">Name</label><br>
                                                <input type="text" class="form-control" placeholder="Enter name" name="name" required>
                                            </div>      
                                        </div>

                                        <div class="row mt-2">
                                            <div class="col-md-12">
                                                <label class="labels">Email</label>
                                                <input type="email" class="form-control" placeholder="Enter email" name="email" required>
                                            </div>      
                                        </div>

                                        <div class="row mt-2">
                                            <div class="col-md-12">
                                                <label class="labels">Password</label>
                                                <input type="password" class="form-control" placeholder="Enter password" name="password" required>
                                            </div>      
                                        </div>

                                        <div class="row mt-2">
                                            <div class="col-md-12">
                                                <label class="labels">Identity Card Number</label>
                                                <input type="text" class="form-control" placeholder="Enter IC" name="ic" required>
                                            </div>      
                                        </div>

                                        <div class="row mt-2">                                            
                                            <label class="labels">Gender</label><br><br>

                                            <div class="col-md-5">

                                                <input type="radio"placeholder="Enter gender" name="gender" value="Male">
                                                <label class="labels">Male</label>
                                            </div>
                                            <div class="col-md-5">
                                                <input type="radio"placeholder="Enter gender" name="gender" value="Female">
                                                <label class="labels">Female</label>
                                            </div>      
                                        </div> <br>


                                        <div class="row mt-2">
                                            <div class="col-md-12">
                                                <label class="labels">KPI</label>
                                                <input type="text" class="form-control" placeholder="Enter KPI" name="kpi" required>
                                            </div>      
                                        </div>

                                        <div class="row mt-2">
                                            <div class="col-md-12">
                                                <label class="labels">Phone Number</label>
                                                <input type="text" class="form-control" placeholder="Enter phone number" name="contact" required>
                                            </div>      
                                        </div>

                                        <div class="row mt-2">
                                            <div class="col-md-12">
                                                <label class="labels">Staff Id</label>
                                                <input type="text" class="form-control" placeholder="Enter staff id" name="staffid" required>
                                            </div>      
                                        </div>

                                        <div class="row mt-2">
                                            <div class="col-md-12">
                                                <label class="labels">Grade</label>
                                                <input type="text" class="form-control" placeholder="Enter grade" name="grade" required>
                                            </div>      
                                        </div>

                                        <div class="row mt-3">
                                            <div class="col-md-12">
                                                <label class="labels">Address</label>
                                                <input type="text" class="form-control" placeholder="Enter address" name="address" required>
                                            </div>
                                        </div>

                                        <div class="mt-5 text-center">
                                            <button class="btn btn-primary profile-button" type="submit">Register</button>
                                        </div>
                                    </form>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                                    <img alt="me"class="rounded-circle mt-5" width="380px" src="img/logo.png">
                                    <a href="login.jsp" class="signup-image-link">Already have an account</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>

        <script type="text/javascript">
            var urlParams = new URLSearchParams(window.location.search);
            var status = urlParams.get('status');

            if (status === "success") {
                swal("Congrats", "Account Created", "success");
            } else if (status === "error") {
                swal("Oops", "Account Creation Failed", "error");
            } else if (status === "emailExists") {
                swal("Oops", "Email already exists", "error");
            }

        </script>
    </body>
</html>
