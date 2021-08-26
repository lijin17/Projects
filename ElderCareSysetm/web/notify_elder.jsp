<%-- 
    Document   : nursingworker_register
    Created on : Apr 19, 2019, 2:37:04 AM
    Author     : lijin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Sent Notification</title>

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
                                    <h1 class="h4 text-gray-900 mb-4">Complete Your Notification here!</h1>
                                </div>
                                <form:form action="NotificationElder.htm" method="post" command="nursingworker" class="user">
                                    
                                    
                                    <div class="form-group row">
                                        
                                        <div class="col-sm-6">
                                            <a class="h4 text-gray-900 mb-4">Send From:</a>
                                            <select name="from" class="form-control form-control-user" id = "exampleInputEmail">                                                 
                                                    <option value ="${sessionScope.elderName}" selected>Send From:${sessionScope.elderName}</option>                                                                                     
                                                </select>   
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">                        
                                            <div class="form-group" >
                                                <a class="h4 text-gray-900 mb-4">Send To:</a>
                                                <select name="to" class="form-control form-control-user" id = "exampleInputEmail">
                                                    <option value ="" disabled selected hidden>Send To:</option>
                                                    <c:forEach items="${nursingworkerInfo}" var="v">
                                                    <option value ="${v.name}">${v.name}</option>
                                                    </c:forEach>                                       
                                                </select>
                                            </div>
                                        </div>                                 
                                    </div>
                                    
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">                        
                                            <div class="form-group" >
                                                <a class="h4 text-gray-900 mb-4">Content:</a>
                                                <select name="content" class="form-control form-control-user" id = "exampleInputEmail">
                                                    <option value ="" disabled selected hidden>Content:</option>                                                   
                                                    <option value ="I need a Doctor.">I need a Doctor.</option>
                                                    <option value ="I need a Nurse.">I need a Nurse.</option>
                                                    <option value ="I have a Head Issue.">I have a Head Issue.</option>
                                                    <option value ="I have a Body Issue.">I have a Body Issue.</option>
                                                    <option value ="I have a Heart Issue.">I have a Heart Issue.</option>
                                                    <option value ="Can you come to my room when you have time?">Can you come to my room when you have time?</option>
                                                </select>
                                            </div>
                                        </div>                                 
                                    </div>
                                    <input type="submit" value="Send" class="btn btn-primary btn-user btn-block">                                 
                                </form:form>
                                <hr>
                                
                                <div class="text-center">
                                    <a class="small" href="index_elder.jsp">back to function board</a>
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

