<#include	 "../layout.ftl">

<#macro head>
</#macro>

<#macro body>
<div id="content">
	
		<div id="content-header">
			<h1>文章管理</h1>
		</div>
		<div class="container-fluid">
			<div>
				<a class="btn btn-info btn-large" href="${basePath}/manage/article/create">添加文章</a>
			</div>
			<div class="widget-box">
				<div class="widget-content nopadding">
				<div class="widget-title">
								<span class="icon">
									<i class="icon-th"></i>
								</span>
								<h5>文章列表</h5>
							</div>
					<table class="table table-bordered table-striped">
						<tr>
							<th><p style="text-overflow:ellipsis; overflow:hidden; white-space:nowrap; width:100px;">标题</p></th>
							
							<th>操作</th>
						</tr>
						<#list pager.getList()! as entity>
						<tr>
							<td><p style="text-overflow:ellipsis; overflow:hidden; white-space:nowrap; width:100px;">${entity.getTitle()}</p></td>
							
							<td><a href="${basePath}/manage/article/edit?id=${entity.getId()}">编辑</a> |
								<a href="${basePath}/manage/article/delete?id=${entity.getId()}">删除</a></td>
						</tr>
						</#list>
					</table>
					
				</div>
			</div>
			<div>
				${pager.getPagerHtml()!}
			</div>

		</div>
		
		<div class="row-fluid">
			<div id="footer" class="span12">
				2013 © by <a href="http://www.lingzerg.com">Lingzerg & Jeremy Menethil</a>
			</div>
		</div>
	</div>
</#macro>