<%-- 
    Document   : home
    Created on : Jul 12, 2021, 10:32:22 PM
    Author     : Thanh Dang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="table.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="Home" method="get">
            <select id="selected" name="select">
                <c:forEach items="${listCate}" var="d">
                    <option value ="${d.id}">${d.categoryName}</option>
                </c:forEach>
            </select>
            <input type="submit" name="submit" value="Submit"> 
            <a href="cart.jsp">View Cart</a>
        </form>
        
        <br>
        <br>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Buy</th>
            </tr>
            <c:if test="${check eq null}">
                <c:forEach items="${listProduct}" var="p">
                    <tr>    
                        <td>${p.productId}</td>
                        <td>${p.productName}</td>
                        <td>${p.price}</td>
                        <td><a href="Cart?productId=${p.productId}">Add</a></td>
                    </tr>
                </c:forEach>    
            </c:if> 
            <c:if test="${check ne null}"> 
                <c:forEach items="${listProduct}" var="p">
                    <tr>
                        <td>${p.productId}</td>
                        <td>${p.productName}</td>
                        <td>${p.price}</td>
                        <td><a href="Cart?productId=${p.productId}">Add</a></td>
                    </tr>
                </c:forEach>
            </c:if>           
        </table>
    </body>
</html>
