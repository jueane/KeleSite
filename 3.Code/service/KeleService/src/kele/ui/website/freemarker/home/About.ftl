<#include	 "../layout.ftl">

<#macro head>

</#macro>


<#macro body>
<div style="text-align:center;">
<h2>公司介紹</h2>
${companySummary.getContent()!}
</div>
</#macro>