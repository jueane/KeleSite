<#include	 "../layout.ftl">

<#macro head>

</#macro>


<#macro body>
    <div class="breadcrumbs">
        <div class="container_12">
            <div class="grid_12">
                 <a href="Default.aspx">主页</a><span></span><span class="current">留言板</span>
            </div><!-- .grid_12 -->
        </div><!-- .container_12 -->
    </div><!-- .breadcrumbs -->
    
    <section id="main">
        <div class="container_12">
            <div id="content" class="grid_9">
                <header>
                    <h1 class="page_title">留言列表</h1>
                </header>
                
		<#list pager.getList()! as entity>
		<article>
		    <div class="content_article"><p>${entity.getContent()!}</p></div><!-- .content_article -->
		    <div class="footer_article">
			<div class="number_c"><strong>3</strong> 评论</div>
			<strong>发布者的名字</strong>, <time datetime="2012-11-03">03.11.2012</time>
		    </div>
		</article>
		<hr style="margin-top:10px;margin-bottom:30px;border:solid 1px gray;">
		</#list>
                
		<div class="pagination">${pager.getPagerHtml()!}</div>


		<hr style="margin-top:100px;">
        <form class="add_comments" id="add_comments_blog" method="post" action="${basePath}/message/post">
		    <h4>发表留言</h4>

		    <div class="nickname">
			<strong>姓名</strong><sup>*</sup><br/>
			<input type="text" name="author" class="" value=""/>
		    </div><!-- .nickname -->

		    <div class="your_review">
			<strong>电子邮箱地址</strong><sup>*</sup><br/>
			<input type="email" name="email" class="" value=""/>
		    </div><!-- .your_review -->

		    <div class="clear"></div>

		    <div class="text_review">
			<strong>留言</strong><br/>
			<textarea name="content"></textarea><br/>
		    </div><!-- .text_review -->

		    <input type="submit" value="提交"/>
		</form><!-- #add_comments_blog -->
                
                <div class="clear"></div>
            </div><!-- #content -->
            
            
            <div class="clear"></div>
        </div><!-- .container_12 -->
    </section><!-- #main -->
    <div class="clear"></div>



</#macro>