<html>
<head><title>Confirmation</title></head>

<%
//
String favLang=request.getParameter("favoriteLanguage");
//
Cookie theCookie=new Cookie("myApp.favoriteLanguage", favLang);

//
theCookie.setMaxAge(60*24*2);

//
response.addCookie(theCookie);

%>
<body>

The favoriate language has been set to ${param.favoriteLanguage } or: <%=theCookie.getValue() %>
<br />
<br />

<a href="cookies-homepage.jsp">Retrun to homepage</a>

</body>
</html>