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

				<form class="form-horizontal" method="post"
					action="${basePath}/manage/pagesetting/homeIntroductionUpdate">
					
					<div class="control-group">
						<label class="control-label">标题</label>
						<div class="controls">
							<input type="text" name="title" value="${title!}"/>
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label">内容</label>
						<div class="controls">
							<textarea rows="5" cols="20" name="content" >${homeIntroduction!}</textarea>
						</div>
					</div>
					
					<div class="form-actions">
						<input type="hidden" id="image" name="image" /> <input
							type="submit" class="btn btn-success" value="保存" />
					</div>
				</form>

			</div>
		</div>


		<div class="row-fluid">
			<div id="footer" class="span12">
				2013 © by <a href="http://www.lingzerg.com">Lingzerg & Jeremy
					Menethil</a>
			</div>
		</div>
	</div>

</div>

</#macro>
