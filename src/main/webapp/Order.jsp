<%@ page import="net.javaguides.ordermanagement.model.Item" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Merlin
  Date: 10/10/2020
  Time: 1:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <title>Order Detail Management</title>
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
            <a href="https://www.javaguides.net" class="navbar-brand"> Order Detail Management App</a>
        </div>
        <ul class="navbar-nav">

            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Home</a></li>
        </ul>
    </nav>
    <script>
        function setPrice(price) {
            this.document.getElementById("price").setAttribute("value", price.value);
        }
        //function setSubTotal(subTotal) {
           // subTotal = price *qty;
           // this.document.getElementById("subTotal").setAttribute("value", subTotal.value);
        //}
       // function setGrandTotal(grandTotal) {
           // grandTotal=sum(SubTotal);
           // this.document.getElementById("price").setAttribute("value", grandTotal.value);
      //  }

        function myFunction() {
            var table = document.getElementById("myTable");
            var row = table.insertRow(2);
            var cell1 = row.insertCell(0);
            var cell2 = row.insertCell(1);
            var cell3 = row.insertCell(2);
            var cell4 = row.insertCell(3);
            var cell5 = row.insertCell(4);
            var cell6 = row.insertCell(5);
            cell1.innerHTML = "<input type=\"text\"  id=\"itemid\">";
            cell2.innerHTML = "<select name=\"food\" id=\"food\" onchange=\"setPrice(this)\">";
            cell3.innerHTML = "<input type=\"text\" readonly id=\"price\">";
            cell4.innerHTML = "<input type=\"text\"  id=\"qty\">";
            cell5.innerHTML = "<input type=\"text\"  readonly id=\"subTotal\">";
            cell6.innerHTML = "<button type=\"button\" onclick=\"myFunction()\">Add more\n" +
                "                        Orders</button>";
        }
        function myDeleteFunction() {
            document.getElementById("myTable").deleteRow(2);
        }
    </script>

</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <c:if test="$(id != null)">
        <form action="update" method="post">
        </c:if>
        <c:if test="$(id == null)">
        <form action="insert" method="post">
         </c:if>
        <h3 class="text-center">Place Order</h3>
        <hr>

        <table class="table table-bordered" id="myTable">
            <thead>
            <tr>
                <th>Item ID (AI)</th>
                <th>Item Name</th>
                <th>Price</th>
                <th>Qty</th>
                <th>Sub Total</th>
            </tr>
            </thead>
                <tr>
                    <td><input type="text"  id="itemid"></td>


                    <td>
                        <select name="food" id="food" onchange="setPrice(this)">
                            <%
                                List<Item> items = (List<Item>) request.getAttribute("items");
                                for (Item item : items) {%>
                            <option value="<%= item.getPrice()%>"><%= item.getItemName()%>
                            </option>
                            <% }%>
                        </select>
                    </td>
                    <td><input type="text" readonly id="price"></td>
                    <td><input type="text"  id="qty"></td>
                    <td><input type="text"  readonly id="subTotal"></td>
                    <td><button type="button" onclick="myFunction()">Add more
                        Orders</button> <button onclick="myDeleteFunction()">Delete row</button></td>
                </tr>
        </table>
             <br>
            <label>Grand Total</label> <input type="text" name="grandTotal">
        <br>
        <a href="<%=request.getContextPath()%>/create" class="btn btn-success">Place an
            Order</a>
        <div class="container text-left">

        </div>

    </div>
</div>
</body>
</html>







