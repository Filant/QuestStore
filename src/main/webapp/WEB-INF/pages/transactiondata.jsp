<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
  <title>TransactionData</title>

  <style type="text/css">
    .tg {
      border-collapse: collapse;
      border-spacing: 0;
      border-color: #ccc;
    }

    .tg td {
      font-family: Arial, sans-serif;
      font-size: 14px;
      padding: 10px 5px;
      border-style: solid;
      border-width: 1px;
      overflow: hidden;
      word-break: normal;
      border-color: #ccc;
      color: #333;
      background-color: #fff;
    }

    .tg th {
      font-family: Arial, sans-serif;
      font-size: 14px;
      font-weight: normal;
      padding: 10px 5px;
      border-style: solid;
      border-width: 1px;
      overflow: hidden;
      word-break: normal;
      border-color: #ccc;
      color: #333;
      background-color: #f0f0f0;
    }

    .tg .tg-4eph {
      background-color: #f9f9f9
    }
  </style>

</head>
<body>
<h1>Transaction Details</h1>

<table class="tg">
  <tr>
    <th width="80">ID</th>
    <th width="120">Store_id</th>
    <th width="120">Product_id</th>
    <th width="120">Quantity</th>
	<th width="120">Value</th>
	<th width="120">Datetime</th>
  </tr>
  <tr>
    <td>${transaction.id}</td>
    <td>${transaction.store_id}</td>
    <td>${transaction.product_id}</td>
    <td>${transaction.quantity}</td>
	<td>${transaction.value}</td>
	<td>${transaction.dateandtime}</td>
  </tr>
</table>
</body>
</html>