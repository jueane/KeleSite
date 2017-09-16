<#include "../layout.ftl"> <#macro head> </#macro> <#macro body>
<form id="form1" runat="server">
	<div>
		<section id="main" class="home">
			<div class="container_12">
				<div id="content">
					<div class="grid_12">
						<h2 class="product-title">为孩子写歌，写孩子的歌</h2>
					</div>
					<!-- .grid_12 -->

					<div class="clear"></div>

					<div class="products">
						<#list homePictureList as entity>
						</article>
						<!-- .grid_3.article -->
						<article class="grid_3 article">
							<div class="prev">
								<a href="${entity.getUrl()!}"><img
									src="${basePath}/attachment/image/${entity.getImage()!}"
									alt="Product 2" title="" />
								</a>
							</div>
							<!-- .prev -->
							<h3 class="title">${entity.getTitle()!}</h3>
						</article>
						<!-- .grid_3.article -->
						</#list>

						<div class="clear"></div>
					</div>
					<!-- .products -->
					<div class="clear"></div>
				</div>
				<!-- #content -->

				<div class="clear"></div>


				<div id="content_bottom">
					<div class="grid_6">
						<div class="bottom_block about_as">
							<h3>${homeIntro.getTitle()!}</h3>
							<p>${homeIntro.getContent()!}</p>
						</div>
						<!-- .about_as -->
					</div>
					<!-- .grid_6 -->

					<div class="grid_6">
						<div class="bottom_block news">
							<h3>新闻</h3>
							<ul>
								<#list homeArticleList! as entity>
								<li><a href="${basePath}/${entity.getUrl()!}">${entity.getTitle()!}</a>
								</li> </#list>
							</ul>
						</div>
						<!-- .news -->
					</div>
					<!-- .grid_6 -->
					<div class="clear"></div>
				</div>
				<!-- #content_bottom -->
			</div>
			<!-- .container_12 -->
		</section>
		<!-- #main.home -->

		<div class="clear"></div>
	</div>
</form>


</#macro>
