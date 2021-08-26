<%-- 
    Document   : browse
    Created on : Feb 6, 2019, 3:40:36 PM
    Author     : lijin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choose the function</title>
    </head>

    <body>
        <h1>Welcome to our movie store</h1>
        <form action="function.htm" method="POST">
            <select name="option">
                <option value="searchMovie" >Search Movies</option>
                <option value ="addMovie">Add new movies to database</option>
            </select>   
            <input type="submit" value="submit"/>
        </form>
    </body>
</html>
