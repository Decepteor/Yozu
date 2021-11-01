<#global page_title="error" url_link="error" url_group="">
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
Oh no! Looks like something went wrong, <a href="/messages">let's get back on track!</a>
</div>
</div>

</@base.basePage>