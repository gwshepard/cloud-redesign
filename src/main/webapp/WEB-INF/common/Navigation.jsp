<%@ include file="/WEB-INF/common/Taglibs.jsp" %>

<div class="sideBar" id="sidebar-1">

<div class="sbModule">
<h3>Quick Links</h3>
<ul>
<s:if test="%{#session.registration eq null}" >
<li><a href="<s:url value="login_input.action"/>" title="Login to your account">Login to Account</a></li>
<li><a href="<s:url value="registration_input.action"/>" title="Register a new account">Register New Account</a></li>
</s:if>
<s:else>
<li><a href="<s:url value="registrationUpdate_input.action"/>" title="Update your account">Update Account</a></li>
<li><a href="<s:url value="logout.action"/>" title="Logout of your account">Logout of Account</a></li>
</s:else>
</ul>
</div>

<div class="sbModule">
<h3>Related Links 1</h3>
<ul>
<li><a href="<s:url value="welcome.action"/>" title="Link 1A">Link 1A</a></li>
<li><a href="<s:url value="welcome.action"/>" title="Link 1B">Link 1B</a></li>
</ul>
</div>

<div class="sbModule">
<h3>Related Links 2</h3>
<ul>
<li><a href="<s:url value="welcome.action"/>" title="Link 2A">Link 2A</a></li>
<li><a href="<s:url value="welcome.action"/>" title="Link 2B">Link 2B</a></li>
<li><a href="<s:url value="welcome.action"/>" title="Link 2C">Link 2C</a></li>
</ul>
</div>

</div>