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
    <script type="text/javascript">
        let items = <%=request.getAttribute("items")%>;
    </script>
    <script>
        var idIncrement = 1;

        function setPrice(item) {
            this.document.getElementById("price-" + item.name.split("food-")[1]).setAttribute("value", item.value);
        }

        /*function setSubTotal(subTotal) {
            subTotal = price * qty;
            this.document.getElementById("subTotal").setAttribute("value", subTotal.value);
        }

        function setGrandTotal(grandTotal) {
            grandTotal = sum(SubTotal);
            this.document.getElementById("price").setAttribute("value", grandTotal.value);
        }*/

        function calculateSubtotal(item) {
            this.document.getElementById("sub-total-" + item.id.split("qty-")[1]).value = this.document.getElementById("price-" + item.id.split("qty-")[1]).value * item.value;
        }

        function myFunction() {
            let table = document.getElementById("myTable");
            let row = table.insertRow(1);
            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);
            let cell3 = row.insertCell(2);
            let cell4 = row.insertCell(3);
            let cell5 = row.insertCell(4);
            let options = '<option >Select Item</option>';
            items.forEach(item => {
                options = options + '<option value=' + item.price + '>' + item.itemName + '</option>';
            })
            cell1.innerHTML = "<input type='text'  id='item_id' value='" + idIncrement + "'>";
            if (options !== undefined) {
                cell2.innerHTML = "<select name='food-" + idIncrement + "' id='food' onchange='setPrice(this)'>" + options + "</select>";
            }
            cell3.innerHTML = "<input type='text' readonly id='price-" + idIncrement + "'>";
            cell4.innerHTML = "<input type='text'  id='qty-" + idIncrement + "' onchange='calculateSubtotal(this)'>";
            cell5.innerHTML = "<input type='text'  readonly id='sub-total-" + idIncrement + "'>";
            idIncrement++;
        }

        function myDeleteFunction() {
            document.getElementById("myTable").deleteRow(2);
        }
    </script>

</header>
<br>

<div class="row">
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
                </table>
                <br>
                <label>Grand Total</label> <input type="text" name="grandTotal">
                <br>
                <a href="<%=request.getContextPath()%>/create" class="btn btn-primary">Place an
                    Order</a>
                <button type="button" onclick="myFunction()" class="btn btn-primary">Add more Orders</button>

    </div>
</div>
</body>
</html>







