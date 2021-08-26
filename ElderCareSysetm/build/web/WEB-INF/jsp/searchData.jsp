<%-- 
    Document   : showResults
    Created on : Feb 6, 2019, 8:24:14 PM
    Author     : lijin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Data</title>
    </head>
    <body>
        <h1>
        <c:out value="${keyword}"></c:out>
        </h1>
        

        <b>Here are the search results:</b>
        
        <table border="2">
            <tr>
                <td>
                    ID
                </td>
                <td>
                    Title
                </td>
                <td>
                    Actor
                </td>
                <td>
                    Actress
                </td>
                <td>
                    Genre
                </td>
                <td>
                    Year
                </td>
            </tr>
            <br></br>
            <c:forEach var="movie" items="${movies}">
                <tr>
                    <td>
                        <c:out value="${movie.movieID}"></c:out>
                    </td>
                    <td>
                        <c:out value="${movie.title}"></c:out>
                    </td>
                    <td>
                        <c:out value="${movie.actor}"></c:out>
                    </td>
                    <td>
                        <c:out value="${movie.actress}"></c:out>
                    </td>
                    <td>
                        <c:out value="${movie.genre}"></c:out>
                    </td>
                    <td>
                        <c:out value="${movie.year}"></c:out>
                    </td>
                </tr>                      
            </c:forEach>  
        </table>
        <br><br/>
        <a href="function.htm">Click here to go back to the main page</a>

    </body>
</html>
