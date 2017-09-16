<#include "../layout.ftl"> <#macro head>
<script
	src="${basePath}/resources/scripts/jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
<link
	href="${basePath}/resources/scripts/jquery-easyui-1.3.4/themes/gray/tree.css"
	rel="stylesheet" />
</#macro> <#macro body>
<div id="content">

	<div id="content-header">
		<h1>分类管理</h1>
	</div>

	<div class="container-fluid">
		<div>
			<a id="insertNode" class="btn btn-primary"><i
				class="icon-plus-sign icon-white"></i><span>添加分类</span>
			</a> <a id="editNode" class="btn btn-info"><i
				class="icon-edit icon-white"></i><span>编辑</span>
			</a> <a id="deleteNode" class="btn btn-danger"><i
				class="icon-trash icon-white"></i><span>删除</span>
			</a>
		</div>
		<div class="widget-box">
			<div class="widget-content nopadding">

				<div></div>
				<ul id="ulCategoryTree"></ul>

			</div>
		</div>
	</div>

	<script>
		$(function() {

			var edittingNode = null;

			$("#ulCategoryTree").tree({
				url : "${basePath}/manage/category/list",
				loadFilter : function(rows) {
					return convert(rows);
				},
				animate : true,
				onDblClick : function(node) {
					edittingNode = node;
					$(this).tree('beginEdit', node.target);
				},
				onAfterEdit : function(node) {
					$.ajax({
						url : "${basePath}/manage/category/edit",
						type : 'post',
						data : {
							id : node.id,
							text : node.text
						},
						success : function(data) {
							if ("true" == data) {
								//$.noty({ "text": "操作成功", "layout": "topCenter", "type": "success" });
							} else {
								alert(data);
								if (node) {
									$("#ulCategoryTree").tree('update', {
										target : node.target,
										text : edittingNode.text
									});
								}
							}
						}
					});
				}
			});

		});

		function convert(rows) {
			function exists(rows, parentId) {
				for ( var i = 0; i < rows.length; i++) {
					if (rows[i].id == parentId)
						return true;
				}
				return false;
			}

			var nodes = [];
			// get the top level nodes
			for ( var i = 0; i < rows.length; i++) {
				var row = rows[i];
				if (!exists(rows, row.parentId)) {
					nodes.push({
						id : row.id,
						text : row.name
					});
				}
			}

			var toDo = [];
			for ( var i = 0; i < nodes.length; i++) {
				toDo.push(nodes[i]);
			}
			while (toDo.length) {
				var node = toDo.shift(); // the parent node
				// get the children nodes
				for ( var i = 0; i < rows.length; i++) {
					var row = rows[i];
					if (row.parentId == node.id) {
						var child = {
							id : row.id,
							text : row.name
						};
						if (node.children) {
							node.children.push(child);
						} else {
							node.children = [ child ];
						}
						toDo.push(child);
					}
				}
			}
			return nodes;
		}

		$("#insertNode").click(
				function() {
					var Selected = $("#ulCategoryTree").tree('getSelected');
					var ReceiveID;
					if (Selected == null) {
						alert("请选择父节点！");
					} else {
						$.ajax({
							url : "${basePath}/manage/category/create",
							type : "post",
							data : {
								id : Selected.id,
								text : 'New Node'
							},
							success : function(id_ret) {
								if (Selected) {
									$('#ulCategoryTree').tree('append', {
										parent : Selected.target,
										data : [ {
											id : id_ret,
											name : 'New Node'
										} ]
									});
									var found = $('#ulCategoryTree').tree(
											'find', id_ret);
									$('#ulCategoryTree').tree('select',
											found.target);
									$('#ulCategoryTree').tree('beginEdit',
											found.target);
								}
							},
							dataType : "text"
						});
					}
				});

		$("#editNode").click(function() {
			var selected = $("#ulCategoryTree").tree('getSelected');
			if (selected == null) {
				alert("请选择节点！");
			} else {
				edittingNode = selected;
				$("#ulCategoryTree").tree('beginEdit', selected.target);
			}
		});

		$("#deleteNode").click(
				function() {
					var node = $("#ulCategoryTree").tree('getSelected');
					if (node == null) {
						alert("请选择节点！");
					} else {
						if (confirm("确定删除此分类？")) {
							$.ajax({
								url : "${basePath}/manage/category/delete",
								type : 'post',
								data : {
									id : node.id
								},
								success : function(data) {
									//$.noty({ "text": "操作成功", "layout": "topCenter", "type": "success" });
									if ("true" == data) {
										if (node) {
											$('#ulCategoryTree').tree('remove',
													node.target);
										}
									} else {
										alert(data);
									}
								}
							});
						}
					}
				});
	</script>



	</#macro>