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
<input id="finder" type="text" placeholder="search tag" max-length="50">
<ul id="list">
	<#list tags as tag>
		<li><a href="/messages?postTags=${tag.tag}">#${tag.tag}</a></li>
	</#list>
</ul>
</div>
<a href="/messages">Back to Messages</a>
</div>
</div>

<script>

var finder = document.querySelector("#finder"),
    list   = document.querySelector("#list"),
    lib    = library();

finder.addEventListener("keyup", onKeydown);

// basic usage
function onKeydown(e) {
  if(!e.target.value) { 
      var results = {exact: lib, fuzzy: []};
	  outputSearchResults(results); 
	  return; 
  }
  var results = FS.search(e.target.value, lib);
  if(results.success) { 
    outputSearchResults(results);
    console.log(results);
  } else {
    console.error(results);
  }
}



// handling search results
function outputSearchResults(results) {
  // clear list
  list.innerHTML = '';

  // you deleted the last letter, do nothing more
  if(results.count === lib.length) return;
  
  // label exact
  if(results.exact.length) label(list, 'Exact Matches');
  // spit out exacts
  outputMatches(results.exact);
  
  // no need to go further unless fuzzy
  if(!results.fuzzy.length) return;

  // label fuzzy
  if(results.fuzzy.length) label(list, 'Fuzzy Matches');
  // spit out fuzzies
  outputMatches(results.fuzzy);
}

// outputting matches
function outputMatches(matchesArray) {
  matchesArray.forEach((match) => {
    var el = document.createElement('li');
    el.innerHTML += '<a href="/messages?postTags=' + getStringFrom(match) + '">#' + getStringFrom(match) + '</a>';
    list.appendChild(el);
  });
}

function getStringFrom(str) {
	if (typeof str === 'string' || str instanceof String) {
		return str;
	}
	return str.string;
}

// labeling output
function label(list, text) {
  var line = document.createElement('li');
  line.innerHTML = text;
  line.className = 'label';
  list.appendChild(line);
}

// we would probably sort these names by last touched so that "recent" has value
// it will still prefer an exact match over a fuzzy, 
// but each would be sorted by this order
function library() {
  return [
	<#list tags as tag>'${tag.tag}',</#list>
  ];
}
</script>

</@base.basePage>