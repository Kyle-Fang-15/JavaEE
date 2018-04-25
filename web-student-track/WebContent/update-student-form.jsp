<!DOCTYPE HTML>



<html>

<head>
<title>Update Student Form</title>

<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">


</head>
<body>

<div id="wrapper">
<div id="header">
<h2>Update Student Form</h2>
</div>
</div>

<div id="container">
<h3>Update Student</h3>
<form action="StudentControllerServlet" method="GET">
<input type="hidden" name="command" value="UPDATE" />
<table>
<tbody>
<tr>
<td>First Name:</td>
<td><input type="text" name="firstname" value="${THE_STUDENT.firstName }"/></td>
</tr>
<tr>
<td>Last Name:</td>
<td><input type="text" name="lastname" value="${THE_STUDENT.lastName }"/></td>
</tr>
<tr>
<td>Email:</td>
<td><input type="text" name="email" value="${THE_STUDENT.email }"/></td>
</tr>

<tr>
<td><input type="submit" value="Save" class="save" /></td>
</tr>
</tbody>

</table>



</form>

<div style="clear:both;"></div>

<p>
<a href="StudentControllerServlet">back to previous</a>
</p>
</div>



</body>


</html>