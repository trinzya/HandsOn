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
Flight ID 
</th>
<th>
Flight name
</th>
<th>
Add a Passenger
</th>
<th>
Remove a Passenger
</th>
<th>
View All  a Passenger
</th>
<c:forEach var="f" items="${flightList}">

<tr>
<td>${f.id}</td>
<td>${f.flightType}</td>
<td><a href="addpassengertoflight?id=${f.id}">Add Passenger</a></td>
<td><a href="removepassengertoflight?id=${f.id}">Remove Passenger</a></td>
<td><a href="viewpassengertoflight?id=${f.id}">View Passenger</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>