<!DOCTYPE HTML>



<html>

<head>
<title>Add Student Form</title>

<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">


</head>
<body>

<div id="wrapper">
<div id="header">
<h2>UCSD Add Student Form</h2>
</div>
</div>

<div id="container">
<h3>Add Student</h3>
<form action="StudentControllerServlet" method="GET">
<input type="hidden" name="command" value="ADD" />
<table>
<tbody>
<tr>
<td>First Name:</td>
<td><input type="text" name="firstname" /></td>
</tr>
<tr>
<td>Last Name:</td>
<td><input type="text" name="lastname" /></td>
</tr>
<tr>
<td>Email:</td>
<td><input type="text" name="email" /></td>
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