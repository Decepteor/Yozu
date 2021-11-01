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

.title-div {
	border-bottom: 1px solid #9c446c;
	margin-bottom: 2px;
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

.side-floater {
	
	width: 15%;
	
}

#newMessageDiv {
	margin: 5px;
	text-align: left;
}

#postedMessageDiv {
	margin: 5px;
	text-align: left;
}

.input {
	width: 100%;
}

</style>

<div class="side-floater post" style="float: left!important; margin-top: 29px;">
<div class="title-div"><strong>Recent Tags:</strong><br></div>
<#list mostRecent as tag>
<a href="/messages?postTags=${tag.tag}">#${tag.tag}</a><br>
</#list>
<br><a href="/tags">See All<a>
</div>

<div class="message-section">
<div style="text-align: center;">
Hello, Welcome to Today I Have! <br>
</div>
<#if message??>
	<div id="response-message" <#if messageType = "Failed"> class="sad-post" <#elseif messageType = "Success"> class="happy-post" </#if>>
		${message}
	</div>
</#if>
<div id="newMessageDiv" class = "post">
What have you done today?
	<form id="postMessage" action="messages" method="post" role="form">
		<label for="title-input">Title:</label>
		<input id="title-input" type="text" name="title" class="input" style="margin-bottom: 2px" maxlength="50" required> <br>
		<label for="message-input">Message:</label>
		<textarea maxlength="300" id="message-input" type="text" name="message" class="input" style="margin-bottom: 2px" rows="5" required></textarea> <br>
		<label for="tag-input">Tags, Seperate with a Hash!</label>
		<input id="tag-input" type="text" name="tags" class="input" style="margin-bottom: 2px" required> <br>
		<input id="csrf_token" type="hidden" name="${_csrf.parameterName}" value=${_csrf.token}>
		<button id="submit-button" class="button-class input post"> Post! </button>
	</form>
</div>

<div id="postedMessageDiv">
<div style="margin-top: 4px; magin-bottom:4px;">
Today people have:   <#if filtered?has_content>(Filtered by: <#list filtered as tag><a href="/messages?postTags=${tag}">#${tag}</a></#list>) <a href="/messages">Remove All Filters</a></#if>
</div>
	<#list messages as posted>
		<div id="post-${posted.pk}" class="post">
			<div class= "title-div">
			<strong>${posted.title}</strong><br>
			</div>
			${posted.message}<br>
			<#if posted.tags?has_content>
				<div class="tags">
					<#list posted.tags as tag>
						<a href="/messages?postTags=${tag.tag}">#${tag.tag}</a>
					</#list>
				</div>
			</#if>
			<br>
			From: ${posted.user.username} at ${posted.lastUpdated}
		</div>
	<br>
	</#list>
<div>
</div>


</@base.basePage>