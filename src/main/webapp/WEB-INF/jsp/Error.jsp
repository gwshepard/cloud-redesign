<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" %>
<%@ include file="/WEB-INF/common/Taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title>Struts2WebApp - Error</title>
		<link rel="stylesheet" href="/struts2webapp/styles/master.css" type="text/css">		
	</head>

<body>

<!-- Begin Container -->
<div class="container">

<!-- Master Head -->
<div class="topHeader">

<jsp:include page="/WEB-INF/common/Header.jsp" />

</div>
<!-- End Master Head -->

<!-- Sidebar -->
<div class="sideBar" id="sidebar-1">

	<jsp:include page="/WEB-INF/common/Navigation.jsp" />

</div>
<!-- End Sidebar -->

<!-- Main Content -->
<div class="mainContent">

<h2>An Error Has Occured</h2>

<p>We are sorry, the website had an unexpected error. Please report this error at <a href="mailto:tutorials@arctechsoftware.com" title="Please report this error.">tutorials@arctechsoftware.com</a>.</p>

</div>
<!-- End Main Content -->

<!-- Begin Main Footer -->
<div class="mainFooter" id="bottom">
<jsp:include page="/WEB-INF/common/Footer.jsp" />
</div>
<!-- End Main Footer -->

</div>
<!-- End Container -->

</body>
</html>