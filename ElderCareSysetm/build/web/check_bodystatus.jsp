<%-- 
    Document   : check_bodystatus
    Created on : Apr 19, 2019, 2:31:25 AM
    Author     : lijin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Elder Body Status</title>

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
                                    <h1 class="h4 text-gray-900 mb-4">Check your Real Time Body status</h1>
                                </div>
                                <form:form method="post" id="fm" action="AddBody.htm" commandName="elder" class="user">       

                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <h2 class="h4 text-gray-900 mb-4">Heart Rate: 
                                                ${sessionScope.HR}
                                            </h2>    
                                                <input type="hidden" name="HR" value="${sessionScope.HR}" class="form-control form-control-user" id="exampleFirstName">                                         
                                            </div>
                                            <div class="col-sm-6">
                                                <h2 class="h4 text-gray-900 mb-4">Systolic Pressure:
                                                    ${sessionScope.SP}                                  
                                                </h2>
                                                <input type="hidden" name="SP" value="${sessionScope.SP}" class="form-control form-control-user" id="exampleLastName">    
                                            </div>
                                        </div>                                   
                                        <br/>

                                        <div class="form-group row">
                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <h2 class="h4 text-gray-900 mb-4">Diastolic Pressure:
                                                    ${sessionScope.DP}
                                                </h2>
                                                <input type="hidden" name="DP" value="${sessionScope.bodystatus.DP}" class="form-control form-control-user" id="exampleInputPassword">
                                            </div>
                                            <div class="col-sm-6">
                                                <h2 class="h4 text-gray-900 mb-4">Oxygen Saturation:
                                                    ${sessionScope.SPO2}
                                                </h2>
                                                <input type="hidden" value="${sessionScope.bodystatus.SPO2}" class="form-control form-control-user" id="exampleRepeatPassword">
                                            </div>                                                                                                          
                                        </div> 
                                        <br/>
                                        <div class="form-group row">
                                            <div class="col-sm-6">
                                                <h2 class="h4 text-gray-900 mb-4">Temperature:
                                                    ${sessionScope.TE}
                                                </h2>
                                                <input type="hidden" value="${sessionScope.bodystatus.TE}" name="TE" class="form-control form-control-user" id="exampleRepeatPassword">
                                            </div>  
                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <h2 class="h4 text-gray-900 mb-4">
                                                    Respiration:
                                                    ${sessionScope.RE}
                                                </h2>
                                                <input type="hidden" name="RE" value="${sessionScope.bodystatus.RE}" class="form-control form-control-user" id="exampleRepeatPassword">
                                            </div>                                 

                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-6 mb-3 mb-sm-0">                        

                                            </div>                                 
                                        </div>
                                        <div style="display:none;">
                                            <input type="submit" id="btn" class="btn btn-primary btn-user btn-block" value="submit data"/>
                                            
                                        </div>
                                            <a href="index_elder.jsp" class="small" href="index_elder.jsp">Back</a>
                                             
                                </form:form>
                               
                                <hr>                               
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
        <script>
            var times = 1;
            var timeDiv = document.getElementById("fm");
            var timeObj = null;
            var btn = document.getElementById("btn")
            function timer() {
                if (times == 0) {
                    btn.click();
                }
                times--;
            }
            timeObj = window.setInterval(timer, 1000);
        </script>

    </body>

</html>

