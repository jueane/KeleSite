<#include	 "../layout.ftl">

<#macro head>

</#macro>

<#macro body>
 
    <div class="breadcrumbs">
        <div class="container_12">
            <div class="grid_12">
                 <a href="${basePath}/home">主页</a><span></span><a href="${basePath}/article">新闻</a><span></span><span class="current">文章详情</span>
            </div><!-- .grid_12 -->
        </div><!-- .container_12 -->
    </div><!-- .breadcrumbs -->
    
    <section id="main">
        <div class="container_12">
            <div id="content" class="grid_9">
                <header>
                    <h1 class="page_title">${entity.getTitle()!}</h1>
                </header>
                
		<article>
		    <div class="content_article">
			<p>${entity.getContent()} </p>
                    </div><!-- .content_article -->
		    <div class="footer_article">
		    </div>
		</article>
             
		</div><!-- .comments_blog -->
                
        
            <div class="clear"></div>
        </div><!-- .container_12 -->
    </section><!-- #main -->
    <div class="clear"></div>


</#macro>