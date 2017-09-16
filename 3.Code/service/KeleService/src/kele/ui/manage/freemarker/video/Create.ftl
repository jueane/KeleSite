<#include	 "../layout.ftl">

<#macro head>
</#macro>

<#macro body>


${notice!}

<div id="content">
		<div id="content-header">
			<h1>创建文章</h1>
		</div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="widget-box">
					<div class="widget-title">
						<span class="icon"> <i class="icon-align-justify"></i>
						</span>
						<h5>请输入内容,分类默认为根目录</h5>
					</div>
					<form method="post" action="${basePath}/manage/video/create" class="form-horizontal"  >
						
						<div class="control-group">
							<label class="control-label">标题</label>
							<div class="controls">
								<input name="title" type="text" maxlength="200" />
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label">视频连接</label>
							<div class="controls">
								<input name="video" type="text" maxlength="200"/>
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label">视频说明：</label>
							<div class="controls">
								<textarea  id="myEditor" name="content" style="height:200px" ></textarea>
							</div>
						</div>
						
						<div class="form-actions">
							<input type="submit" class="btn btn-success" value="保存文章" /> 
							<a class="btn" href="../video">返回列表</a>
						</div>
					</form>
				
				</div>
			</div>
			<div class="row-fluid">
			<div id="footer" class="span12">
				2013 © by <a href="http://www.lingzerg.com">Lingzerg & Jeremy Menethil</a>
			</div>
		</div>
		</div>

	</div>
	</#macro>