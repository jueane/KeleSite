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
		<h1>用户管理</h1>
	</div>
	<div class="container-fluid">
			<div>
			<a class="btn btn-info btn-large"  href="${basePath}/manage/user/create">创建用户</a>
			<a class="btn btn-info btn-large"  href="${basePath}/manage/user/passwordChange">修改个人密码</a>
			</div>
		<div class="widget-box">
			<div class="widget-content nopadding">
				<div class="widget-title">
					<span class="icon"> <i class="icon-th"></i> </span>
					<h5>用户列表</h5>
				</div>
				<table class="table table-bordered table-striped">
					<tr>
						<th>Id</th>
						<th>用户名</th>
						<th>密码</th>
						<th>操作</th>
					</tr>
					<#list pager.getList()! as entity>
					<tr>
						<td>${entity.getId()!}</td>
						<td>${entity.getUsername()!}</td>
						<td>${entity.getPassword()!}</td>
						<td><a href="${basePath}/manage/user/delete?id=${entity.getId()!}" >删除</a></td>	
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
