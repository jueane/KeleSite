<#include "../layout.ftl"> <#macro head>

<style>
table {
	table-layout: fixed;
}
td {
	text-overflow: ellipsis;
	overflow: hidden;	
}
</style>
</#macro> <#macro body>
<div id="content">
	<div id="content-header">
		<h1>留言管理</h1>
	</div>
	<div class="container-fluid">
		<div class="widget-box">
			<div class="widget-content nopadding">
				<div class="widget-title">
					<span class="icon"> <i class="icon-th"></i> </span>
					<h5>留言列表</h5>
				</div>
				<table class="table table-bordered table-striped">
					<tr>
						<th>Id</th>
						<th>内容</th>
						<th>作者</th>
						<th>电子邮箱</th>
						<th>操作</th>
					</tr>
					<#list pager.getList()! as entity>
					<tr>
						<td>${entity.getId()}</td>
						<td title="${entity.getContent()!}">${entity.getContent()!}</td>
						<td>${entity.getAuthor()!}</td>
						<td>${entity.getEmail()!}</td>
						<td><a
							href="${basePath}/manage/message/delete?id=${entity.getId()}">删除</a>
						</td>
					</tr>
					</#list>
				</table>
			</div>
		</div>
		<div>${pager.getPagerHtml()!}</div>
	</div>
	<div class="row-fluid">
		<div id="footer" class="span12">
			2013 © by <a href="http://www.lingzerg.com">Lingzerg & Jeremy
				Menethil</a>
		</div>
	</div>
</div>
</#macro>
