<%-- 
    Document   : cart
    Created on : Jul 12, 2021, 10:32:29 PM
    Author     : Thanh Dang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <title>Cart</title>
        <link href="table.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <table border="1">
            <tr>
                <th>Product Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Unit Pay</th>
            </tr>
            <c:forEach items="${Cart}" var="c">
                <tr>
                    <td>${c.getProductName()}</td>
                    <td>${c.getPrice()}</td>
                    <td>${c.getQuantity()}</td>
                    <td>${c.getPrice()*c.getQuantity()}</td>
                </tr>
            </c:forEach>
            <th>Total Pay: ${sum}</th>
        </table>   
        <a href="Home">Home</a>
    </body>
</html>
