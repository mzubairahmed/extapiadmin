<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>External API Admin Console - Information</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.2.js"></script>
<script type="text/javascript" src="<c:url value="/js/common-utils.js" />"></script>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<p>
		Copy process has been started and an email will be sent to ${email} once the process is complete.<br>
		If you want to begin another copy process for another supplier please <a href="${contextPath}/login.jsp">click here</a> to go to the login screen again.
	</p>
</body>
</html>