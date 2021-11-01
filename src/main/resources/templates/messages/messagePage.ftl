<#global page_title="messages" url_link="messages" url_group="">
<#import "../base/base.ftl" as base />
<@base.basePage url_link url_group>
<style>
.message-section {
	position: absolute;
	left: 50%;
	transform: translate(-50%, 0%);
	margin-top: 5px;
	width: 60%;
}

.happy-post {
	background-color: #9deb91;
	color: #0d5e00;
	width: 100%
}

.sad-post {
	background-color: #ff9191;
	color: #c20000;
	width: 100%
}

.sad-post {
	background-color: #ff9191;
	color: #c20000;
	width: 100%
}

.button-class {
	background-color: #f89ffc;
	color: #8b0091;
}

.post {
    padding: 3px;
    border-radius: 2px;
	border: 1px solid #9c446c;
}

#newMessageDiv {
	margin: 5px;
	text-align: left;
}

#postedMessageDiv {
	margin: 5px;
}

.input {
	width: 100%;
}

</style>
<div class="message-section">
<div style="text-align: center;">
Hello, Welcome to Today I have! <br>
<div>
<#if message??>
	<div id="response-message" <#if messageType = "Failed"> class="sad-post" <#elseif messageType = "Success"> class="happy-post" </#if>>
		${message}
	</div>
</#if>
<div id="newMessageDiv" class = "post">
Something to say for today?
	<form id="postMessage" action="messages" method="post" role="form">
		<label for="title-input">Title:</label>
		<input id="title-input" type="text" name="title" class="input" style="margin-bottom: 2px" maxlength="50"> <br>
		<label for="message-input">Message:</label>
		<textarea maxlength="300" id="message-input" type="text" name="message" class="input" style="margin-bottom: 2px" rows="5"></textarea> <br>
		<label for="tag-input">Tags, Seperate with a Hash!</label>
		<input id="tag-input" type="text" name="tags" class="input" style="margin-bottom: 2px"> <br>
		<input id="csrf_token" type="hidden" name="${_csrf.parameterName}" value=${_csrf.token}>
		<button id="submit-button" class="button-class input post"> Post! </button>
	</form>
</div>
<div id="postedMessageDiv">

Today these people have:
	<#list messages as posted>
		<br>
		<div id="post-${posted.pk}" class="post">
			<strong>${posted.title}</strong><br>
			${posted.message}<br>
			<#if posted.tags?has_content>
				<div class="tags">
					<#list posted.tags as tag>
						#${tag.tag}
					</#list>
				</div>
			</#if>
			<br>
			From: ${posted.user.username} at ${posted.lastUpdated}
		</div>
	
	</#list>
<div>
</div>


</@base.basePage>