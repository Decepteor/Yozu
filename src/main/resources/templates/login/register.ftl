<#global page_title="login" urlLink="login" urlGroup="">

<style>
.centre {
	position: absolute;
	left: 50%;
	top: 45%;
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

.login-label {
	width: 33%;
}

</style>
<div class="centre">
<div class="above-centre"><strong>Today I Have.</strong></div>
<div class="main-boarder">

		<div style="width=100%; text-align: center;">
		  Registration
		</div>
		<#if invalid??>
			<div style="color: red; width=100%; text-align: center;">
				Those Credentials are not Valid.
			</div>
		</#if>
		<div>
		 <br>
		</div>

	<form id="login-form" action="register" method="post" role="form">
		<div>
			<label for="username-input" >Username:</label>
		</div>
		<input id="username-input" type="text" name="username" class="boarder" style="margin: 2px"> <br>
		<div>
		<label for="email-input" class="login-label">Email:</label>
		</div>
		<input id="email-input" type="text" name="emailAdress" class="boarder" style="margin: 2px"> <br>
		<div>
		<label for="password-input" class="login-label">Password:</label>
		</div>
		<input id="password-input" type="password" name="password" class="boarder" style="margin: 2px"><br>
		<input id="csrf_token" type="hidden" name="${_csrf.parameterName}" value=${_csrf.token}>
		<button id="submit-button" style="width: 100%"> Register </button>
	</form>
	<a href="/login">back to login</a>
</div>
<div>