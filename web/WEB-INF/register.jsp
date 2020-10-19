<%-- 
    Document   : register
    Created on : Oct 13, 2020, 12:43:12 PM
    Author     : 831690
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="post">
            Username: <input type="text" name="username" value="${username}"> 
            <br>
            <input type="submit" value="Register name">
            <input type="hidden" name="action" value="register">
         <form
    </body>
</html>
