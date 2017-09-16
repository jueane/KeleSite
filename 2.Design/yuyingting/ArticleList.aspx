<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ArticleList.aspx.cs"  %>


<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
    <title>视频一角</title>
    <!-- #include file = "style.html" -->
</head>
<body>
    <!-- #include file = "header.html" -->
    
        <div>
            <section id="main">
                <div class="container_12">
                    <div id="content" class="grid_9" style="width:100%">
                        <header>
                            <h1 class="page_title">课程介绍</h1>
                        </header>
                        <article class="post">
                            <h2><a href="Vidio.aspx">胡瑛婷幼儿音乐中心视频</a></h2>
                            <div class="content_article">
                                <p> 点击更多查看</p>
                                <a href="Vidio.aspx" class="more">更多</a>
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
    <!-- #include file = "footer.html" -->
</body>
</html>


