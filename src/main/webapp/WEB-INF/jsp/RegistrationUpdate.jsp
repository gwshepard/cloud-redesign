<%@ include file="/WEB-INF/common/Taglibs.jsp" %>

<!-- Main Content -->
<div class="mainContent">

<h2>Account Center</h2>

<h3>Update Your Profile</h3>

<!-- Begin Error -->
<div class="userError">
	<s:fielderror />
	<s:actionerror />
</div>
<!-- End Error -->

<s:form method="post" action="registrationUpdate">

	<h4>* Email Address <span>(this will be your user ID)</span></h4>
	<s:textfield name="registration.emailAddress" cssClass="registration_text" maxlength="60"></s:textfield> <br />

	<h4>* Confirm Email Address</h4>
	<s:textfield name="registration.confirmEmailAddress" cssClass="registration_text" maxlength="60"></s:textfield> <br />

	<h4>* Account Password</h4>
	<s:password name="registration.password" cssClass="registration_text" maxlength="16" showPassword="true"></s:password> <br />

	<h4>* Confirm Account Password</h4>
	<s:password name="registration.confirmPassword" cssClass="registration_text" maxlength="16" showPassword="true"></s:password> <br />

	<h4>* Password Hint</h4>
	<s:textfield name="registration.passwordHint" cssClass="registration_text" maxlength="50"></s:textfield> <br />

	<h4>* First and Last Name</h4>
	<h6>First Name</h6>
	<s:textfield name="registration.firstName" cssClass="registration_text" maxlength="20"></s:textfield> <br />
	<h6>Last Name</h6>
	<s:textfield name="registration.lastName" cssClass="registration_text" maxlength="20"></s:textfield> <br />
	
	<h4>Add me to your email list</h4>
	<s:checkbox name="registration.emailList"></s:checkbox><span class="general_text">Check here to be on the email list.</span> <br /><br />
	
	<s:submit name="method:update" value="%{getText('registration.update')}" ></s:submit>
	<s:submit name="method:input" value="%{getText('registration.reset')}" ></s:submit>
	<s:submit name="method:cancel" value="%{getText('registration.cancel')}" ></s:submit>
	
</s:form>

</div>
<!-- End Main Content -->