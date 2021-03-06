<#include "../layout.ftl"> <#macro head> </#macro> <#macro body>
<div id="content">
	<div id="content-header">
		<h1>用户管理</h1>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon"> <i class="icon-align-justify"></i> </span>
					<h5>创建用户</h5>
				</div>
				<form class="form-horizontal" method="post"
					action="${basePath}/manage/user/create">


					<div class="control-group">
						<label class="control-label">用户名</label>
						<div class="controls">
							<input name="username" type="text" maxlength="200"
								value="${title!}" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label">密码</label>
						<div class="controls">
							<input name="password" type="text" maxlength="200"
								value="${title!}" />
						</div>
					</div>

					<div class="form-actions">
						<input type="submit" class="btn btn-success" value="保存" /> <a
							class="btn" href="${basePath}/manage/user">返回列表</a>
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
