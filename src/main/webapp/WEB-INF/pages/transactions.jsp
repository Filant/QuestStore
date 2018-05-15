<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Transactions Page</title>

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
<a href="../../QuestStore/index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Transaction List</h1>

<c:if test="${!empty listTransaction}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Store_id</th>
            <th width="120">Prodcut_id</th>
            <th width="120">Quantity</th>
			<th width="120">Value</th>
			<th width="120">Datetime</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listTransaction}" var="transaction">
            <tr>
                <td>${transaction.id}</td>
                <td><a href="transactiondata/${transaction.id}" target="_blank">${transaction.store_id}</a></td>
                <td>${transaction.product_id}</td>
                <td>${transaction.quantity}</td>
				<td>${transaction.value}</td>
				<td>${transaction.datetime}</td>
                <td><a href="<c:url value='/editTransaction/${transaction.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/removeTransaction/${transaction.id}'/>">Delete</a></td>

            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Transaction</h1>

<c:url var="addAction" value="/transactions/add"/>

<form:form action="${addAction}" commandName="transaction">
    <table>
        <c:if test="${!empty transaction.id}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="store_id">
                    <spring:message text="Store_id"/>
                </form:label>
            </td>
            <td>
                <form:input path="store_id"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="product_id">
                    <spring:message text="Product_id"/>
                </form:label>
            </td>
            <td>
                <form:input path="product_id"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="quantity">
                    <spring:message text="Quantity"/>
                </form:label>
            </td>
            <td>
                <form:input path="quantity"/>
            </td>
        </tr>
		 <tr>
            <td>
                <form:label path="value">
                    <spring:message text="Value"/>
                </form:label>
            </td>
            <td>
                <form:input path="value"/>
            </td>
        </tr>
		 <c:if test="${!empty transaction.id}">
            <tr>
                <td>
                    <form:label path="datetime">
                        <spring:message text="Datetime"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="datetime" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="datetime"/>
                </td>
            </tr>
        </c:if>
				
        <tr>
            <td colspan="2">

                <c:if test="${!empty transaction.id}">
                    <input type="submit"
                           value="<spring:message text="Edit Transaction"/>"/>
                </c:if>
                <c:if test="${empty transaction.id}">

                    <input type="submit"
                           value="<spring:message text="Add Transaction"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
