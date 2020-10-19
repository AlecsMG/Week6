<%-- 
    Document   : shoppingList
    Created on : Oct 13, 2020, 12:43:26 PM
    Author     : 831690
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello, ${username}
        <form action="ShoppingList" method="post">
            <input type="submit" value="Logout">
            <input type="hidden" name="action" value="logout">
        </form>
        <br>
        <h2>List</h2>
        <form action="" method="post">
            <br>
            Add item: <input type="text" name="item">
            <br>
            <input type="submit" value="Add">
            <input type="hidden" name="action" value="add">     
        </form>
        <form action="" method="post">
            <ul>
                <c:forEach items="${itemList}" var="itemList" varStatus="i">
                    <li><input type="radio" name="item" value="${i.index}">${itemList}</li>
                </c:forEach>
            </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">   
        </form>

    </body>
</html>
