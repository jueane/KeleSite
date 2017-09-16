<#include "../layout.ftl"> <#macro head>
<style>
.clear {
	clear: both
}

table {
	table-layout: fixed;
	width: 100%;
}

td {
	width: 200px;
}

tr {
	background-color: #eef;
}
</style>
</#macro> <#macro body>

<div id="content">
	<div id="content-header">
		<h1>网站页面设置</h1>
	</div>
	<div class="container-fluid">
		<div>
			<a href="${basePath}/manage/pagesetting">首页图片</a> <a
				href="${basePath}/manage/pagesetting/homeArticle">首页文章</a> <a
				href="${basePath}/manage/pagesetting/homeIntroduction">首页介绍</a> <a
				href="${basePath}/manage/pagesetting/companySummary">公司简介</a>
		</div>
		<div class="row-fluid">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon"> <i class="icon-align-justify"></i> </span>
					<h5>首页文章</h5>
				</div>

				<form class="form-horizontal" method="post"
					action="${basePath}/manage/pagesetting/homeArticleCreate">
					<div class="control-group">
						<label class="control-label">标题</label>
						<div class="controls">
							<input type="text" name="title" />
						</div>
					</div>


					<div class="control-group">
						<label class="control-label">Url</label>
						<div class="controls">
							<input type="text" name="url" />
						</div>
					</div>

					<div class="form-actions">
						<input type="hidden" id="image" name="image" /> <input
							type="submit" class="btn btn-success" value="保存" />
					</div>
				</form>

			</div>

			<div class="widget-box">
				<div class="widget-title">
					<h5>首页文章列表</h5>
				</div>
				<div class="widget-content nopadding">
					<table class="table table-bordered table-striped with-check">
						<thead>
							<tr>
								<th>Id</th>
								<th>标题</th>
								<th>Url</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<#list entityList! as entity>
							<tr>
								<td>${entity.getId()}</td>
								<td>${entity.getTitle()}</td>
								<td>${entity.getUrl()}</td>
								<td><a
									href="${basePath}/manage/pagesetting/homeArticleDelete?id=${entity.getId()}">删除</a>
								</td>
							</tr>
							</#list>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>



</#macro>
