<html>
<head><title>Personalize The Site</title></head>

<body>
<h3>Trainning Portal</h3>

<%
//
String favLang="Java";
Cookie[] theCookies=request.getCookies();

if (theCookies!=null){
	for (Cookie temp: theCookies){
		if ("myApp.favoriteLanguage".equals(temp.getName())){
			favLang=temp.getValue();
			break;
		}
	}
}
%>
<h4>New Books for <%= favLang %></h4>
<ul>
<li>ytetue</li>

</ul>
<a href="cookies-personalize-form.html">Personalize this page</a>
</body>

</html>