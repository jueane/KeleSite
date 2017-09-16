<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ArticleDetail.aspx.cs"  %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
    <title></title>
    <!-- #include file = "style.html" -->
</head>
<body>
    <!-- #include file = "header.html" -->
    <div class="breadcrumbs">
        <div class="container_12">
            <div class="grid_12">
                 <a href="Default.aspx">主页</a><span></span><a href="#">新闻</a><span></span><span class="current">是最真实的艺术涵养</span>
            </div><!-- .grid_12 -->
        </div><!-- .container_12 -->
    </div><!-- .breadcrumbs -->
    
    <section id="main">
        <div class="container_12">
            <div id="content" class="grid_9">
                <header>
                    <h1 class="page_title">是最真实的艺术涵养</h1>
                </header>
                
		<article>
		    <div class="content_article">
			<p>将台湾专业音乐学校的视唱听写乐理课，带给一群真心热爱音乐的小孩。他们不为考级也不为考试……，那是为什么？为的是最真实的艺术涵养 </p>
                    </div><!-- .content_article -->
		    <div class="footer_article">
			<div class="number_c"><strong>3</strong> 评论</div>
			<strong>发布者的名字</strong>, <time datetime="2012-11-03">03.11.2012</time>
		    </div>
		</article>
                
                <div class="comments_blog">
		    <h4>评论</h4>
		    <ul class="comments">
			<li>
			    <div class="avatar"><img src="img/content/avatar.png" alt="Avatar"/></div>
			    <div class="autor"><strong>评论者的名字</strong></div>, <time datetime="2012-11-03">03.11.2012</time>
			    <p>评论内容1.</p>
			</li>

			<li>
			    <div class="avatar"><img src="img/content/avatar.png" alt="Avatar"/></div>
			    <div class="autor"><strong>评论者的名字</strong></div>, <time datetime="2012-11-03">03.11.2012</time>
			    <p>评论内容2.</p>
			</li>
            <li>
			    <div class="avatar"><img src="img/content/avatar.png" alt="Avatar"/></div>
			    <div class="autor"><strong>评论者的名字</strong></div>, <time datetime="2012-11-03">03.11.2012</time>
			    <p>评论内容3.</p>
			</li>
		    </ul><!-- .comments -->
		</div><!-- .comments_blog -->
                
        <form class="add_comments" id="add_comments_blog">
		    <h4>发表评论</h4>

		    <div class="nickname">
			<strong>姓名</strong><sup>*</sup><br/>
			<input type="text" name="" class="" value=""/>
		    </div><!-- .nickname -->

		    <div class="your_review">
			<strong>E邮箱地址</strong><sup>*</sup><br/>
			<input type="email" name="" class="" value=""/>
		    </div><!-- .your_review -->

		    <div class="clear"></div>

		    <div class="text_review">
			<strong>评论</strong><br/>
			<textarea name="text"></textarea><br/>
		    </div><!-- .text_review -->

		    <input type="submit" value="提交"/>
		</form><!-- #add_comments_blog -->
                
                <div class="clear"></div>
            </div><!-- #content -->
            
            
            <div class="clear"></div>
        </div><!-- .container_12 -->
    </section><!-- #main -->
    <div class="clear"></div>
       
     <!-- #include file = "footer.html" -->
</body>
</html>
