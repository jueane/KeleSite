<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="News.aspx.cs"  %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
    <title>新闻中心</title>
    <!-- #include file = "style.html" -->
</head>
<body>
    <!-- #include file = "header.html" -->
    <form id="form1" runat="server">
        <div>
            <section id="main">
                <div class="container_12">
                    <div id="content" class="grid_9" style="width:100%">
                        <header>
                            <h1 class="page_title">新闻中心</h1>
                        </header>

                        <article class="post">
                            <h2><a href="ArticleDetail.aspx">爱有模样吗?</a></h2>
                            <div class="content_article">
                                <p> 爱是...用 "心"感"受",音乐教学之路,我是何等幸运,遇上一群有缘的孩子,大家以歌声笑声筑梦,遇上一群有理念的家长,大家一起以笑容为孩子努力.
                                    因为有你们 ,我将会继续为孩子唱歌 ,唱孩子的歌,因为有你们 ,我将会继续为孩子读书 ,读孩子的书,因为有你们 ,我们将携手继续为"爱"妆点新的模样....
                                </p>
                                <a href="ArticleDetail.aspx" class="more">更多</a>
                            </div>
                            <!-- .content_article -->
                            <div class="footer_article">
                                <div class="number_c"><strong>1</strong> 评论</div>
                                <strong>发布人名</strong>, <time datetime="2012-11-03">03.11.2012</time>  
                            </div>
                        </article>
                        <article class="post">
                            <h2><a href="ArticleDetail.aspx">是最真实的艺术涵养</a></h2>
                            <div class="content_article">
                                <p> 将台湾专业音乐学校的视唱听写乐理课，带给一群真心热爱音乐的小孩。他们不为考级也不为考试……，那是为什么？为的是最真实的艺术涵养
                                </p>
                                <a href="ArticleDetail.aspx" class="more">更多</a>
                            </div>
                            <!-- .content_article -->
                            <div class="footer_article">
                                <div class="number_c"><strong>11</strong> 评论</div>
                                <strong>发布人名</strong>, <time datetime="2012-11-03">03.11.2012</time>  
                            </div>
                        </article>
                        <article class="post">
                            <h2><a href="ArticleDetail.aspx">学习演奏者的表演风范</a></h2>
                            <div class="content_article">
                                <p> 学习乐器，学习音乐知识，学习演奏者的表演风范!
                                </p>
                                <a href="ArticleDetail.aspx" class="more">更多</a>
                            </div>
                            <!-- .content_article -->
                            <div class="footer_article">
                                <div class="number_c"><strong>5</strong> 评论</div>
                                <strong>发布人名</strong>, <time datetime="2012-11-03">03.11.2012</time>  
                            </div>
                        </article>
                    </div>


                    <div class="pagination">
                        <ul>
                            <li class="prev"><span>&#8592;</span></li>
                            <li class="curent"><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li><span>...</span></li>
                            <li><a href="#">100</a></li>
                            <li class="next"><a href="#">&#8594;</a></li>
                        </ul>
                    </div>

                    <div class="clear"></div>
                </div>
                <!-- #content -->
            
            
            </section>
            <!-- #main -->
        </div>
    </form>
    <!-- #include file = "footer.html" -->
</body>
</html>

