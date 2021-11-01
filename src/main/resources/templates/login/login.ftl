<#global page_title="login" urlLink="login" urlGroup="">

<style>
.centre {
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);

}
.main-boarder {
	border: 2px solid #9c446c;
	padding: 10px;
}
.above-centre {
	color: #9c446c;
	width=100%; 
	text-align: center;
	margin-bottom: 2%;
}
.boarder {
    padding: 3px;
    border-radius: 2px;
	border: 1px solid #9c446c;
}
</style>
<div class="centre">
<div class="above-centre"><strong>Today I Have.</strong></div>
<div class="main-boarder">
	<#if RequestParameters.error??>
		<div style="color: red; width=100%; text-align: center;">
		 Invalid credentials.
		</div>
	<#else>
		<div>
		 <br>
		</div>
	</#if>
	<form id="login-form" action="login" method="post" role="form">
		<input id="username-input" type="text" name="username" class="boarder" style="margin: 2px"> <br>
		<input id="password-input" type="password" name="password" class="boarder" style="margin: 2px"><br>
		<input id="csrf_token" type="hidden" name="${_csrf.parameterName}" value=${_csrf.token}>
		<button id="submit-button" style="width: 100%"> login </button>
	</form>
</div>
<div>