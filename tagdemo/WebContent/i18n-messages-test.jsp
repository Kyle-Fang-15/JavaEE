<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>


<c:set var="theLocale" 
value="${not empty param.theLocale? param.theLocale: pageContext.request.locale}" 
scope="session" />

<fmt:setLocale value="${theLocale}" />
<fmt:setBundle basename="com.my.jsp.i18n.resourses.mylabels" />
<body>



<a href="i18n-messages-test.jsp?theLocale=en_US">English (US)</a>|
<a href="i18n-messages-test.jsp?theLocale=es_ES">Spanish (ES)</a>|
<a href="i18n-messages-test.jsp?theLocale=de_DE">Germany (DE)</a>|
<hr >
<fmt:message key="label.greeting" /><br /><br />
<fmt:message key="label.firstname" /><br /><br/>
<fmt:message key="label.lastname" /><br /><br/>
<fmt:message key="label.welcome" /><br /><br/>






</body>

</html>

