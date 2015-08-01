<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Welcome to Godwin's Site!</h1>
	
	<h1>User</h1>
	<p>
		<a href="/user/page">starter</a>
	</p>

	<h1>Demo page</h1>
	<p>
		<a href="/demo/starter">starter</a>
	</p>
	<p>
		<a href="/demo/theme">theme</a>
	</p>
	<p>
		<a href="/demo/fixedtop">fixedtop</a>
	</p>
	<p>
		<a href="/demo/dashboard">dashboard</a>
	</p>
	<P>Time: ${serverTime}.</P>
</body>
</html>
