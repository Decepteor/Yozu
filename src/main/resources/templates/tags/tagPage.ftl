<#global page_title="tags" url_link="tags" url_group="">
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



<div class="message-section">
<div style="text-align: center;">
Hello, Welcome to Today I Have! <br>
<div>
<div class="title-div"><strong>All Tags:</strong><br></div>
<#list tags as tag>
<a href="/messages?postTags=${tag.tag}">#${tag.tag}</a><br>
</#list>
</div>
</div>
</div>

</@base.basePage>