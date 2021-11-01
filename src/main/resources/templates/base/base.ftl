<#macro basePage url_link url_group>
<style>
.topbar {
	border-bottom: 1px solid #9c446c;
	padding: 5px;
}
</style>

<header class="topbar">
	<strong>Today I Have.</strong>
	<div style="float: right!important;">
		
		<form id="logout-form" action="logout" method="post" role="form">
			Welcome ${user}!
			<button href="/logout">Logout</button> 
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