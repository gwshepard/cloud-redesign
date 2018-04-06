<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" errorPage="/WEB-INF/jsp/ErrorPage.jsp" %>
<%@ include file="/WEB-INF/common/Taglibs.jsp" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><tiles:getAsString name="title"/></title>
	<link rel="stylesheet" href="styles/master.css" type="text/css">
</head>
<body>
<div class="container">
	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="navigation"/>
	<tiles:insertAttribute name="content"/>
	<tiles:insertAttribute name="footer"/>
</div>
</body>
</html>