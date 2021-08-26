<%-- 
    Document   : admin_register
    Created on : Apr 19, 2019, 2:37:45 AM
    Author     : lijin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Administrator Register</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

    </head>

    <body class="bg-gradient-primary">

        <div class="container">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                        <div class="col-lg-7">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Create an administrator here!</h1>
                                </div>
                                <form:form method="post" action="AdminReg.htm" commandName="administrator" class="user">
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            
                                            <input type="text" name="name" class="form-control form-control-user" id="exampleFirstName" placeholder="Name"/>                                          
                                        </div>
                                        <div class="col-sm-6">
                                            <input  type="text" name="phoneNum" class="form-control form-control-user"  placeholder="Phone Number"/>    
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <input  type="text" name="address" class="form-control form-control-user"  placeholder="Address"/>
                                    </div>
                                    
                                    <div class="form-group">
                                        <input type="text" name="email" class="form-control form-control-user" placeholder="Email"/>
                                    </div>
                                    <br/>

                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <input type="password" name="password" class="form-control form-control-user" placeholder="Password"/>
                                        </div>
                                                                                                                                                  
                                    </div> 
                                    <br/>
                                    
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">                        
                                            <div class="form-group" >
                                                <select path="gender" name="gender"  class="form-control form-control-user" >
                                                    <option value ="" disabled selected hidden>Select Gender</option>
                                                    <option value ="male">Male</option>
                                                    <option value ="female">Female</option>                                          
                                                </select>
                                            </div>
                                        </div>                                 
                                    </div>                             
                                    <input type="submit" value="Register Admin" class="btn btn-primary btn-user btn-block" />                                                                         
                                </form:form>
                                <hr>
                                
                                <div class="text-center">
                                    <a class="small" href="login_choose.jsp">Already have an account? Login!</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

    </body>

</html>
