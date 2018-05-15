<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ page session="false" %>
<html>
<head>
    <title>Stores Page</title>

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

<h1>Stores List</h1>
<form:form>
	<table>
		<tr>
			<td>
				<input type="submit"
							   value="<spring:message text="Group By"/>"/>
			</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
</form:form>


<c:if test="${!empty listStore}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Address</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listStore}" var="store">
            <tr>
                <td>${store.id}</td>
				<td>${store.name}</td>
                <td><a href="storedata/${store.id}" target="_blank">${store.address}</a></td>				
                <td><a href="<c:url value='/editStore/${store.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/removeStore/${store.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Store</h1>

<c:url var="addAction" value="/stores/add"/>

<form:form action="${addAction}" commandName="store">
    <table>
        <c:if test="${!empty store.address}">
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
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="address">
                    <spring:message text="Address"/>
                </form:label>
            </td>
            <td>
                <form:input path="address"/>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <c:if test="${!empty store.address}">
                    <input type="submit"
                           value="<spring:message text="Edit Store"/>"/>
                </c:if>
                <c:if test="${empty store.address}">
                    <input type="submit"
                           value="<spring:message text="Add Store"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>

