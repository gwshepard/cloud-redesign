<%@ include file="/WEB-INF/common/Taglibs.jsp" %>

<!-- Main Content -->
<div class="mainContent">

<h2>Account Center</h2>

<h3>Login To Your Account</h3>

<!-- Begin Error -->
<div class="userError">
	<s:fielderror />
	<s:actionerror />
</div>
<!-- End Error -->

<s:form method="post" action="login">

	<h4>* Your Email Address</h4>
	<s:textfield name="emailAddress" cssClass="registration_text" maxlength="60"></s:textfield> <br />
	
	<h4>* Account Password</h4>
	<s:password name="password" cssClass="registration_text" maxlength="16"></s:password> <br />
	
	<s:submit name="submit" value="%{getText('registration.submit')}"></s:submit>

</s:form> 

</div>
<!-- End Main Content -->