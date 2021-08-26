<%-- 
    Document   : addMovies
    Created on : Feb 6, 2019, 4:22:26 PM
    Author     : lijin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add movies</title>
    </head>
    <body>
        <form:form method="post" action="addMovie.htm" commandName="movie">       
        <h1>Please enter the details below:</h1>
        Movie Title:<form:input path="title" />
        <form:errors path="title" cssStyle="color:red"/>
        </br>
        </br>
        Lead Actor:<form:input path="actor" />
        <form:errors path="actor" cssStyle="color:red"/>
        </br>
        </br>
        Lead Actress:<form:input path="actress" />
        <form:errors path="actress" cssStyle="color:red"/>
        </br>
        </br>
        Genre:<form:input path="genre" />
        <form:errors path="genre" cssStyle="color:red"/>
        </br>
        </br>
        Year:<form:input path="year" />
        <form:errors path="year" cssStyle="color:red"/>
        </br>
        </br>
        <input type="submit" value="submit"/>
        </form:form>
        
        </br>
        </br>
        <a href="function.htm">Click here to go back to the main page</a>
    </body>
</html>
