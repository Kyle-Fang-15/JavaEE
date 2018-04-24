<%@ page import ="java.util.*, com.code.web.jdbc.*" %>
<!DOCTYPE HTML>
<html>
<head>

<title>Student Tracker App</title>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>
<%
List<Student> theStudents=(List<Student>) request.getAttribute("STUDENT_LIST");




%>
<body>
<div id="wrapper">
<div id="wrapper">

<h2>
UCSD Class of 2021
</h2>
</div>

<div id="container">
<div id="content">
<table>
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
</tr>
<% for (Student temp: theStudents){ %>
	
	
	<tr>
	<td><%=temp.getFirstName() %></td>
	<td><%=temp.getLastName() %></td>
	<td><%=temp.getEmail() %></td>
	</tr>
<%} %>





</table>
</div>
</div>



</div>


</body>

</html>