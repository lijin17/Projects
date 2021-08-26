<%-- 
    Document   : searchMovies
    Created on : Feb 6, 2019, 4:23:02 PM
    Author     : lijin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search by title</title>
    </head>
    <body>
        <h1>Searching Movies</h1>
        <form:form method="post" action="searchMovie.htm" commandName="SearchInfo">
            keyword:<form:input path="keyword"/>
            <form:errors path="keyword" cssStyle="color:red"/>
            </br>
            </br>
            <form:radiobutton path="type" value="MovieID" label="Search By ID"/>
            </br>
            </br>
            <form:radiobutton path="type" value="title" label="Search By Title"/>
            </br>
            </br>
            <form:radiobutton path="type" value="actor" label="Search By Actor"/>
            </br>
            </br>
            <form:radiobutton path="type" value="actress" label="Search By Actress"/>
            </br>
            </br>
            <form:errors path="type" cssStyle="color:red"/>
            </br>
            </br>
            <input type="submit" value="search"/>
        </form:form>
        </br>
        </br>
        <a href="function.htm">Click here to go back to the main page</a>
    </body>
</html>
