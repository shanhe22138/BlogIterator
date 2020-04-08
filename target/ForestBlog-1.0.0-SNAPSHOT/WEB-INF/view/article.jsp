<%@ page import="com.blog.entity.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Blog | 写文章</title>

    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>

    <link href="<%=basePath%>/resource/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>/resource/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="<%=basePath%>/resource/css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>/resource/css/plugins/bootstrap-markdown/bootstrap-markdown.min.css" rel="stylesheet">
    <link href="<%=basePath%>/resource/css/style.css" rel="stylesheet">

</head>

<body>

<%
    String welcomeStr;
    User user = (User) session.getAttribute("user");
    if(user == null) {
        welcomeStr = "登录/注册";
    } else {
        welcomeStr = user.getUserNickname() + ".";
    }
%>

<div id="wrapper">

    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="/resource/img/profile_small.jpg" />
                             </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="/home">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">David Williams</strong>
                             </span> <span class="text-muted text-xs block">Art Director <b class="caret"></b></span> </span> </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a href="/user/1">个人主页</a></li>
                            <li><a href="/attention">关注</a></li>
                            <li><a href="/fans">粉丝</a></li>
                            <li class="divider"></li>
                            <li><a href="/logout">退出</a></li>
                        </ul>
                    </div>
                    <div class="logo-element">
                        Blog
                    </div>
                </li>

                <li>
                    <a href="/user/collection"><i class="fa fa-heart"></i> <span class="nav-label">我的收藏</span></a>
                </li>
                <li>
                    <a href="/user/articles"><i class="fa fa-paper-plane"></i> <span class="nav-label">我的发布</span></a>
                </li>
                <li>
                    <a href="/article"><i class="fa fa-pencil"></i> <span class="nav-label">写文章</span></a>
                </li>

            </ul>

        </div>
    </nav>

    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                    <form role="search" class="navbar-form-custom" action="/top-search" method="post">
                        <div class="form-group">
                            <input type="text" placeholder="Search for something..." class="form-control" name="top_search" id="top-search">
                        </div>
                    </form>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
<%--                        <span class="m-r-sm text-muted welcome-message">Welcome to Blog</span>--%>
                        <a href="/login"><%=welcomeStr%></a>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="form_markdown.html#">
                            <i class="fa fa-envelope"></i>  <span class="label label-warning">16</span>
                        </a>
                        <ul class="dropdown-menu dropdown-messages">
                            <li>
                                <div class="dropdown-messages-box">
                                    <a href="profile.html" class="pull-left">
                                        <img alt="image" class="img-circle" src="img/a7.jpg">
                                    </a>
                                    <div class="media-body">
                                        <small class="pull-right">46h ago</small>
                                        <strong>Mike Loreipsum</strong> started following <strong>Monica Smith</strong>. <br>
                                        <small class="text-muted">3 days ago at 7:58 pm - 10.06.2014</small>
                                    </div>
                                </div>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="dropdown-messages-box">
                                    <a href="profile.html" class="pull-left">
                                        <img alt="image" class="img-circle" src="img/a4.jpg">
                                    </a>
                                    <div class="media-body ">
                                        <small class="pull-right text-navy">5h ago</small>
                                        <strong>Chris Johnatan Overtunk</strong> started following <strong>Monica Smith</strong>. <br>
                                        <small class="text-muted">Yesterday 1:21 pm - 11.06.2014</small>
                                    </div>
                                </div>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="dropdown-messages-box">
                                    <a href="profile.html" class="pull-left">
                                        <img alt="image" class="img-circle" src="img/profile.jpg">
                                    </a>
                                    <div class="media-body ">
                                        <small class="pull-right">23h ago</small>
                                        <strong>Monica Smith</strong> love <strong>Kim Smith</strong>. <br>
                                        <small class="text-muted">2 days ago at 2:30 am - 11.06.2014</small>
                                    </div>
                                </div>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a href="mailbox.html">
                                        <i class="fa fa-envelope"></i> <strong>Read All Messages</strong>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="form_markdown.html#">
                            <i class="fa fa-bell"></i>  <span class="label label-primary">8</span>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">
                            <li>
                                <a href="mailbox.html">
                                    <div>
                                        <i class="fa fa-envelope fa-fw"></i> You have 16 messages
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="profile.html">
                                    <div>
                                        <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                        <span class="pull-right text-muted small">12 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="grid_options.html">
                                    <div>
                                        <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a href="notifications.html">
                                        <strong>See All Alerts</strong>
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>


                    <li>
                        <a href="/logout">
                            <i class="fa fa-sign-out"></i> Logout
                        </a>
                    </li>
                </ul>

            </nav>
        </div>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>Blog</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="/home">主页</a>
                    </li>
                    
                    <li class="active">
                        <strong>写文章</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">

            </div>
        </div>
        <div class="wrapper wrapper-content">

            <div class="row">
                <div class="col-lg-12">
                    <form method="post" id="myForm" name="articleParam" action="/article/insert">
                        <div class="form-group">
                            <label for="title">标题</label>
                            <input type="text" class="form-control" id="title" name="articleTitle" required="required">
                        </div>
                        <div class="form-group">
                            <label for="text_content">内容</label>
                            <textarea id="text_content" name="articleContent" data-provide="markdown" rows="10"></textarea>
                        </div>
                        <div class="form-group">
                            <label for="tag">标签</label>
                            <input type="text" class="form-control" id="tag" required="required">
                        </div>
                        <button type="submit" id="submit" class="btn btn-default">发布</button>
                    </form>
                </div>
            </div>
            
        </div>
        <div class="footer">
            <div class="pull-right">
                10GB of <strong>250GB</strong> Free.
            </div>
            <div>
                <strong>Copyright</strong> Example Company &copy; 2014-2015
            </div>
        </div>

    </div>
</div>



<!-- Mainly scripts -->
<script src="<%=basePath%>/resource/js/jquery-2.1.1.js"></script>
<script src="<%=basePath%>/resource/js/bootstrap.min.js"></script>
<script src="<%=basePath%>/resource/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="<%=basePath%>/resource/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="<%=basePath%>/resource/js/inspinia.js"></script>
<script src="<%=basePath%>/resource/js/plugins/pace/pace.min.js"></script>

<!-- Bootstrap markdown -->
<script src="<%=basePath%>/resource/js/plugins/bootstrap-markdown/bootstrap-markdown.js"></script>
<script src="<%=basePath%>/resource/js/plugins/bootstrap-markdown/markdown.js"></script>
<script type="text/javascript">
    $("#text_content").markdown({autofocus:false,savable:true})

</script>


</body>

</html>


<%--<form class="layui-form"  method="post" id="myForm" name="articleParam" action="/article/insert">--%>

<%--        <div class="layui-form-item">--%>
<%--            <label class="layui-form-label">标题 <span style="color: #FF5722; ">*</span></label>--%>
<%--            <div class="layui-input-block">--%>
<%--                <input type="text" name="articleTitle" lay-verify="title" id="title" autocomplete="off" placeholder="请输入标题" class="layui-input">--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <div class="layui-form-item layui-form-text">--%>
<%--            <label class="layui-form-label">内容 <span style="color: #FF5722; ">*</span></label>--%>
<%--            <div class="layui-input-block">--%>
<%--                <textarea class="layui-textarea layui-hide" name="articleContent" lay-verify="content" id="content"></textarea>--%>
<%--            </div>--%>

<%--        </div>--%>


<%--        <div class="layui-form-item" pane="">--%>
<%--            <label class="layui-form-label">标签</label>--%>
<%--            <div class="layui-input-block">--%>
<%--                <input type="text" />--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <div class="layui-form-item">--%>
<%--            <div class="layui-input-block">--%>
<%--                <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>--%>
<%--                <button type="reset" class="layui-btn layui-btn-primary" onclick="getCateIds()">重置</button>--%>
<%--            </div>--%>
<%--        </div>--%>


<%--</form>--%>








