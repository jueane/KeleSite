<#include "../layout.ftl"> <#macro head>
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
					<h5>首页图片</h5>
				</div>

				<form id="imgUpload" class="form-horizontal"
					enctype="multipart/form-data" method="post"
					action="${basePath}/manage/upload">
					<div class="control-group">
						<label class="control-label">图片</label>
						<div class="controls">
							<div>
								<input type="file" id="imgFile" name="file"
									onchange="imgSubmit()" />
							</div>
							<img id="imgTag" style="width: 210px; height: 210px;" />
						</div>
					</div>
				</form>

				<form class="form-horizontal" method="post"
					action="${basePath}/manage/pagesetting/indexCreate">
					<div class="control-group">
						<label class="control-label">标题</label>
						<div class="controls">
							<input type="text" name="title" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label">URL</label>
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
		</div>


		<ul class="thumbnails">
			<#list entityList as entity>
			<li class="span2">
				<div
					style="width: 220px; heigth: 200px; float: left; background-color: #fff;padding-left:20px;">
					<img style="width: 210px; height: 210px"
						src="${basePath}/attachment/image/${entity.getImage()}" />
					<div style="width: 300px;">
						<a href="${basePath}/manage/pagesetting/indexDelete?id=${entity.getId()}">删除</a>
						<div>${entity.getTitle()!}</div>
					</div>
				</div></li> </#list>
		</ul>



		<div class="row-fluid">
			<div id="footer" class="span12">
				2013 © by <a href="http://www.lingzerg.com">Lingzerg & Jeremy
					Menethil</a>
			</div>
		</div>
	</div>

</div>







<script src="${basePath}/resources/scripts/jquery.form.js"></script>
<script>
	$(function() {
		$("#imgUpload").ajaxForm(
				function(data) {
					var obj = JSON.parse(data);
					$("#imgTag").attr("src",
							"${basePath}/attachment/image/" + obj.url);
					$("#image").attr("value", obj.url);
				});

	});
	function imgSubmit() {
		$("#imgUpload").submit();
	}
</script>


</#macro>
