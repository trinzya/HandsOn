<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr> 
<th>
Passenger ID
</th>
<th>
Passenger name
</th>
<th>
Is Vip
</th>
<c:forEach var="p" items="${passengers}">
<tr>
<td>${p.id}</td>
<td>${p.name}</td>
<td>${p.vip}</td>
<td><a href="removepassengertoflight?id=${flight.id}">Delete</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>