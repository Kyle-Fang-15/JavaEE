<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>


<!DOCTYPE HTML>
<html>
<head>

<title>Student Tracker App</title>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>



<body>
<div id="wrapper">
<div id="wrapper">

<h2>
UCSD Class of 2021
</h2>

</div>
</div>

<div id="container">
<div id="content">

<input type="button" value="Add Student" 
onclick="window.location.href='add-student-form.jsp'; return false;"
class="add-student-button" />

<table>
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
</tr>
<c:forEach var="temp" items="${STUDENT_LIST }">
	
	
	<tr>
	<td>${temp.firstName}</td>
	<td>${temp.lastName}</td>
	<td>${temp.email}</td>
	</tr>

</c:forEach>



</table>
</div>
</div>



</div>


</body>

</html>