<%@ page import="java.util.*" %>

<html>
<body>
<form action="todo-demo.jsp" >
Add new item: <input type="text" name="theItem"/>

<input type="submit" name="Submit"/>



</form>

<br />

Item entered: <%=request.getParameter("theItem") %>

<%


List<String> items= (List<String>) session.getAttribute("toDoList");
if (items==null){
	
	items= new ArrayList<String>();
	session.setAttribute("toDoList", items);
}


String theItem=request.getParameter("theItem");
if(theItem!=null){
	items.add(theItem);
}
%>

<hr>

<br />
<b>To Do List Items: </b>

<br />
<ol>
<%

for (String temp: items){
	out.println("<li>" +temp+"</li>");
}

%>

</ol>

</body>

</html>