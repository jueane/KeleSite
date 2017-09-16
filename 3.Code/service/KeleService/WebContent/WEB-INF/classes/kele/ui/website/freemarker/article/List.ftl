<#include	 "../layout.ftl">

<#macro head>

</#macro>


<#macro body>
    <div>
            <section id="main">
                <div class="container_12">
                    <div id="content" class="grid_9" style="width:100%">
                        <header>
                            <h1 class="page_title">新闻中心</h1>
                        </header>
                        <#list pager.getList()! as entity>
                        <article class="post">
                            <h2><a href="article/details?id=${entity.getId()}">${entity.getTitle()} </a></h2>
                            <div class="content_article">
                                <p> 点击更多查看</p>
                                <a href="article/details?id=${entity.getId()}" class="more">更多</a>
                            </div>
                        </article>
                        </#list>
                    </div>

                    <div class="pagination">${pager.getPagerHtml()!}</div>

                    <div class="clear"></div>
                </div>
                <!-- #content -->
            
            
            </section>
            <!-- #main -->
        </div>


</#macro>