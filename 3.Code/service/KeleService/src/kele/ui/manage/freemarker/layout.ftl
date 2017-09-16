<html>
<head>
        <title></title>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <script src="${basePath}/resources/scripts/jquery-1.7.2.min.js"></script>
        
        <link rel="stylesheet" href="${basePath}/resources/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${basePath}/resources/css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" href="${basePath}/resources/css/uniform.css" />
		<link rel="stylesheet" href="${basePath}/resources/css/select2.css" />
		<link rel="stylesheet" href="${basePath}/resources/css/unicorn.main.css" />
		<link rel="stylesheet" href="${basePath}/resources/css/unicorn.grey.css" class="skin-color" />
		<script src="${basePath}/resources/js/excanvas.min.js"></script>
		<script src="${basePath}/resources/js/jquery.min.js"></script>
		<script src="${basePath}/resources/js/jquery.ui.custom.js"></script>
		<script src="${basePath}/resources/js/bootstrap.min.js"></script>
		<script src="${basePath}/resources/js/jquery.flot.min.js"></script>
		<script src="${basePath}/resources/js/jquery.flot.resize.min.js"></script>
		<script src="${basePath}/resources/js/jquery.peity.min.js"></script>
		<script src="${basePath}/resources/js/fullcalendar.min.js"></script>
		<script src="${basePath}/resources/js/unicorn.js"></script>
		<!-- <script src="${basePath}/resources/js/unicorn.dashboard.js"></script> -->
		        
        
        
        <@head />
</head>
<body>



<div id="header">
			<h1><a href="http://www.calamus-media.com/">菖蒲文化传播有限公司</a></h1>	</div>

		<div id="user-nav" class="navbar navbar-inverse">
            <ul class="nav btn-group">
                <li class="btn btn-inverse"><a title="" href="${basePath}/manage/user/passwordChange"><i class="icon icon-cog"></i> <span class="text">密码设置</span></a></li>
                <li class="btn btn-inverse"><a title="" href="${basePath}/manage/login/logout"><i class="icon icon-share-alt"></i> <span class="text">退出</span></a></li>
            </ul>
        </div>



<div id="sidebar">
	<a href="#" class="visible-phone"><i class="icon icon-th-list"></i>
		Tables</a>
	<ul>
		<li><a href="${basePath}/manage/article"><i class="icon icon-th"></i> <span>文章管理</span></a>
		</li>
		<li><a href="${basePath}/manage/video"><i class="icon icon-th"></i> <span>视频管理</span></a>
		</li>
		<li><a href="${basePath}/manage/category"><i class="icon icon-th-list"></i> <span>分类管理</span></a>
		</li>		
		<li><a href="${basePath}/manage/message"><i class="icon icon-th"></i> <span>留言管理</span></a></li>
		<li><a href="${basePath}/manage/pagesetting"><i class="icon icon-th"></i> <span>网站页面设置</span></a></li>
		<li><a href="${basePath}/manage/user"><i class="icon icon-inbox"></i> <span>系统用户管理</span></a>
		</li>
	</ul>
</div>


<@body/>
</html>