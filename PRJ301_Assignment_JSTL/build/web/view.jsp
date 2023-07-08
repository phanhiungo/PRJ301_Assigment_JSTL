<%-- 
    Document   : view
    Created on : Jun 15, 2023, 10:22:21 AM
    Author     : moneymaker
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sample.shopping.Tea"%>
<%@page import="sample.shopping.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Detail</title>
    </head>
    <body>
        <h1>Order Information</h1>
        <c:if test="${sessionScope.CART != null}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total</th>
                        <th>Remove</th>
                        <th>Edit</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="count" value="0" />
                    <c:set var="total" value="0" />
                    <c:forEach items="${sessionScope.CART.cart.values()}" var="tea">
                        <c:set var="subtotal" value="${tea.price * tea.quantity}" />
                        <c:set var="total" value="${total + subtotal}" />
                        <tr>
                            <td><c:set var="count" value="${count+1}" /><c:out value="${count}" /></td>
                            <td>
                                <input type="text" name="id" value="${tea.id}" readonly="" />
                            </td>
                            <td><c:out value="${tea.name}" /></td>
                            <td><c:out value="${tea.price}" /></td>
                            <td>
                                <input type="number" name="quantity" value="${tea.quantity}" required="" min="1"/>
                            </td>
                            <td><c:out value="${subtotal}" /></td>
                            <td>
                                <form action="MainController" method="POST">
                                    <input type="hidden" name="id" value="${tea.id}" />
                                    <input type="hidden" name="action" value="remove" />
                                    <input type="submit" value="Remove" />
                                </form>
                            </td>
                            <td>
                                <form action="MainController" method="POST">
                                    <input type="hidden" name="id" value="${tea.id}" />
                                    <input type="hidden" name="action" value="edit" />
                                    <input type="submit" value="Edit" />
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <h1>Total <c:out value="${total}" /></h1>

            <form action="MainController" method="POST">
                <label for="customerFullName">Full Name:</label>
                <input type="text" id="customerFullName" name="customerFullName" required>
                <input type="submit" value="Checkout" name="action">
            </form>
        </c:if>

        <a href="shopping.html">Return to shopping</a>
    </body>
</html>
