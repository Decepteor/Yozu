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
  !function(r,e){"object"==typeof exports&&"object"==typeof module?module.exports=e():"function"==typeof define&&define.amd?define([],e):"object"==typeof exports?exports.FS=e():r.FS=e()}(this,function(){return function(r){function e(n){if(t[n])return t[n].exports;var s=t[n]={exports:{},id:n,loaded:!1};return r[n].call(s.exports,s,s.exports,e),s.loaded=!0,s.exports}var t={};return e.m=r,e.c=t,e.p="",e(0)}([function(r,e){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var t=function(r){var e=void 0;return r=r.map(function(r,t){return Array.isArray(r)?(e="no arrays permitted: "+r,null):"string"==typeof r?{id:t+1,string:r}:r.string?r.id?r:(r.id=t+1,r):(e="no string value: "+r,null)}),e?{error:e,items:r}:r},n=(e.search=function(r,e){if(!r)return{success:!1,error:"No term provided in FS.search(term, lib)."};if(!e)return{success:!1,error:"No lib provided in FS.search(term, lib)."};if(e=t(e),e.error)return{success:!1,error:e.error};var c={exact:[],fuzzy:[]},u=[],i=[],a=null,f=null;a="(.+)?("+n(r)+")(.+)?$";var p=new RegExp(a,"g"),l=r.split("").map(function(r){return"("+n(r)+")"});f="(.+)?"+l.join("(.+)?")+"(.+)?$";var g=new RegExp(f,"g");return e.forEach(function(r){r.string.match(p)?u.push(r):r.string.match(g)&&i.push(r)}),u.forEach(function(r){var e=s(a,r.string);r._matchType="exact",r._substrings=e.substrings,r._score=e.score,c.exact.push(r)}),i.forEach(function(r){var e=s(f,r.string);r._matchType="fuzzy",r._substrings=e.substrings,r._score=e.score,c.fuzzy.push(r)}),{success:!0,count:c.exact.concat(c.fuzzy).length,term:r,exact:c.exact.sort(o),fuzzy:c.fuzzy.sort(o),_regex:{exact:a,fuzzy:f}}},function(r){return r.replace(/([\/\\\*\?\+\.\(\)\[\]\{\}\$\!])/g,"\\$1")}),s=function(r,e){for(var t=new RegExp(r,"g"),n=t.exec(e),s=[],o=!1,c=0,u=0,i=1;i<n.length;i++)n[i]&&s.push({str:n[i],match:o}),n[i]||1===i||i===n.length-1||c++,n[i]||1!==i||u++,o=!o;return{substrings:s,score:c+u}},o=function(r,e){return r._score<e._score?1:r._score>e._score?-1:0}}])});
//# sourceMappingURL=fuzzy-search.min.js.map
</script>
</#macro>