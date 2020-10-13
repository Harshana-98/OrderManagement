<%--
  Created by IntelliJ IDEA.
  User: Merlin
  Date: 10/10/2020
  Time: 1:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> User
                Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Orders</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">View Order</h3>
        <hr>

        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Item Name</th>
                <th>Price</th>
                <th>Qty</th>
                <th>Sub Total</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <!--   for (Todo todo: todos) {  -->
            <c:forEach var="order" items="${listOrder}">

                <tr>
                    <td><c:out value="${order.id}" /></td>
                    <td><c:out value="${order.itemName}" /></td>
                    <td><c:out value="${order.price}" /></td>
                    <td><c:out value="${order.qty}" /></td>
                    <td><c:out value="${order.qty}" /></td>
                    <td><a href="edit?id=<c:out value='${order.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="delete?id=<c:out value='${order.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
        <fieldset class="form-group">
            <label>Grand Total</label> <input type="text"
                                              value="<c:out value='${order.grandTotal}' />" class="form-control"
                                              name="grandTotal">
        </fieldset>
        <div class="container text-right">

            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Complete Order</a>
        </div>
    </div>
</div>
</body>
</html>
