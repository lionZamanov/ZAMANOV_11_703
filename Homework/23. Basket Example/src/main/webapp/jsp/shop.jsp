<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 25.10.2018
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        body {
            font-family: sans-serif;
        }

        button {
            background: #00b5cc;
            border: 0;
            padding: 10px;
            color: #fff;
            font-family: sans-serif;
            font-weight: 700;
            border-bottom: 3px solid #078390;
        }

        table {
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
            font-size: 14px;
            background: white;
            max-width: 70%;
            width: 70%;
            border-collapse: collapse;
            text-align: left;
        }

        th {
            font-weight: normal;
            color: #039;
            border-bottom: 2px solid #6678b1;
            padding: 10px 8px;
        }

        td {
            color: #669;
            padding: 9px 8px;
            transition: .3s linear;
        }

        a {
            font-family: sans-serif;
            text-decoration: none;
        }

        tr:hover td {
            color: #6699ff;
        }
    </style>
    <title>Shop</title>
</head>
<body>
<h1>SHOP</h1>
<h3>Доступные товары</h3>
<div>
    <table>
        <tr>
            <th>id</th>
            <th>title</th>
            <th>cost</th>
            <th>Add</th>

        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.title}</td>
                <td>${product.cost}</td>
                <td>
                    <button id="${product.id}">Добавить</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<h3>Мои товары</h3>
<div>
    <table id="user-products">
        <tr>
            <th>id</th>
            <th>Title</th>
            <th>Cost</th>
            <th>Count</th>

        </tr>
        <%--<c:forEach items="${userProducts}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.title}</td>
                <td>${product.cost}</td>
            </tr>
        </c:forEach>--%>
    </table>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" charset="utf-8">

    function loadUserProducts() {
        $.ajax({
            method: "GET",
            url: "/products.json"
        })
            .done(function (data) {
                console.log(data);
                printProducts(data)
            });
    }

    $(document).ready(loadUserProducts());

    $('button').click(function () {
        var productId = $(this).attr("id");
        $.ajax({
            method: "POST",
            url: "/shop",
            data: {id: productId}
        })
            .done(function (data) {
                loadUserProducts();
            });
    });

    function printProducts(products) {
        $("#user-products tr:nth-child(n+2)").remove();
        $.each(products, function (index, product) {
            printProduct(product);
        })
    }

    function printProduct(productData) {
        var result = '<tr>';
        result += "<td>" + productData.product.id + "</td>";
        result += "<td>" + productData.product.title + "</td>";
        result += "<td>" + productData.product.cost + "</td>";
        result += "<td>" + productData.count + "</td>";
        result += "</tr>";
        console.log(result);
        $("#user-products tr:last").after(result)
    }
</script>
</body>
</html>
