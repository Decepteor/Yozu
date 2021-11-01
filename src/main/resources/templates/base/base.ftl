<#macro basePage url_link url_group>
<header>
	<div>
		<form id="logout-form" action="logout" method="post" role="form">
			<button href="/logout">Log Out</button> 
			<input id="csrf_token" type="hidden" name="${_csrf.parameterName}" value=${_csrf.token}>
		</form>
	</div>
</header>
<div>
<#nested/>
</div>


	
<script>
  
</script>
</#macro>