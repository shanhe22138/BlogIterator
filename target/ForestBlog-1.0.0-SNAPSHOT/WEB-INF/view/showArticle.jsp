<%@ page import="com.blog.entity.User" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        %>

<%
    User s_user = (User) session.getAttribute("user");
    String avatar = "/resource/img/profile_small.jpg", nickname = "请登录";
    int userId = -1;
    if(s_user != null) {
        avatar  = s_user.getUserAvatar();
        nickname = s_user.getUserNickname();
        userId = s_user.getUserId();
    }
%>

    <title>Blog | Article</title>

    <link href="<%=basePath%>/resource/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>/resource/font-awesome/css/font-awesome.css" rel="stylesheet">

    <!-- Toastr style -->
    <link href="<%=basePath%>/resource/css/plugins/toastr/toastr.min.css" rel="stylesheet">

    <link href="<%=basePath%>/resource/css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>/resource/css/style.css" rel="stylesheet">


</head>
<body>

    <%
    String welcomeStr;
    User user = (User) session.getAttribute("user");
    if(user == null) {
        welcomeStr = "登录/注册";
    } else {
        welcomeStr = user.getUserNickname();
    }
%>

<div id="wrapper">

    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <span>
                            <img alt="image" class="img-circle" src="/resource/img/profile_small.jpg" />
                        </span>
                        <a data-toggle="dropdown" class="dropdown-toggle">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold"><%=welcomeStr%></strong>
                             </span> <span class="text-muted text-xs block">更多选项<b class="caret"></b></span> </span> </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a href="profile.html">个人主页</a></li>
                            <li><a href="contacts.html">关注</a></li>
                            <li><a href="mailbox.html">粉丝</a></li>
                            <li class="divider"></li>
                            <li><a href="/logout">退出</a></li>
                        </ul>
                    </div>
                    <div class="logo-element">
                        Blog
                    </div>
                </li>

                <li>
                    <a href="layouts.html"><i class="fa fa-heart"></i> <span class="nav-label">我的收藏</span></a>
                </li>
                <li>
                    <a href="layouts.html"><i class="fa fa-paper-plane"></i> <span class="nav-label">我的发布</span></a>
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
                    <form role="search" class="navbar-form-custom" action="search_results.html">
                        <div class="form-group">
                            <input type="text" placeholder="Search for something..." class="form-control" name="top-search" id="top-search">
                        </div>
                    </form>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <%--                        <span class="m-r-sm text-muted welcome-message">Welcome to Blog</span>--%>
                        <a href="/login"><%=welcomeStr%></a>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="blog.html#">
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
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="blog.html#">
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
                        <a href="/article">
                            <i class="fa fa-pencil"></i>
                        </a>
                    </li>

                    <li>
                        <a href="/logout">
                            <i class="fa fa-sign-out"></i> 退出
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
                        <strong>文章详情</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">

            </div>
        </div>



    <div class="wrapper wrapper-content  animated fadeInRight article">
        <div class="row">
            <div class="col-lg-10 col-lg-offset-1">
                <div class="ibox">
                    <div class="ibox-content">
                        <div class="pull-right">
                            <button class="btn btn-white btn-xs" type="button">Model</button>
                            <button class="btn btn-white btn-xs" type="button">Publishing</button>
                            <button class="btn btn-white btn-xs" type="button">Modern</button>
                        </div>
                        <div class="text-center article-title">
                            <h1>
                                ${article.articleTitle}
                            </h1>
                            <span class="text-muted">
                                <i class="fa fa-clock-o"></i>
                                <fmt:formatDate value="${article.articleUpdateTime}" type="both"/>
                            </span>
                        </div>
                        <p>
                                ${article.articleContent}
                        </p>

                        <div class="row">
                            <div class="col-md-6">
                                <h5>Tags:</h5>
                                <c:forEach items="${article.tags}" var="tag">
                                    <button class="btn btn-primary btn-xs" type="button" href="/search/tag/${tag.tagId}">
                                            ${tag.tagName}
                                    </button>
                                </c:forEach>
                            </div>
                            <div class="col-md-6">
                                <div class="small text-right">
                                    <div> <i class="fa fa-comments-o"> </i> ${article.articleCommentCount} comments </div>
                                    <i class="fa fa-eye"> </i> ${article.articleViewCount} views
                                </div>
                            </div>
                        </div>

                        <hr>

                        <div class="row">
                            <div class="col-lg-12">

                                <h2>评论:</h2>
                                <c:if test="${!empty comments}">
                                    <c:forEach items="${comments}" var="comment">
<%--                                        ${comment.articleId}<br>--%>
<%--                                        ${comment.userId}<br>--%>
<%--                                        ${comment.userId}<br>--%>
<%--                                        ${comment.user.userNickname}<br>--%>
<%--                                        ${comment.user.userAvatar}<br>--%>
<%--                                        ${comment.commentCreateTime}<br>--%>
                                        <div class="col-lg-12">
                                            <!--  头像+id+time  -->
                                            <div class="social-avatar">
                                                <a href="/user/${comment.userId}" class="pull-left">
                                                    <img alt="image" src="${comment.user.userAvatar}">
                                                </a>
                                                <div class="media-body">
                                                    <a href="/user/${comment.userId}">
                                                            ${comment.user.userNickname}
                                                    </a>
                                                    <small class="text-muted">
                                                        <fmt:formatDate value="${comment.commentCreateTime}" type="both"/>
                                                    </small>
                                                </div>
                                            </div>
                                            <!--  content  -->
                                            <div class="social-body">
                                                <p>
                                                    <c:if test="${comment.commentTargetId != 0}">
                                                        回复：<a href="/user/${comment.commentTargetId}">@${comment.commentTargetName}</a> &nbsp;
                                                    </c:if>
                                                        ${comment.commentContent}
                                                </p>
                                            </div>
                                            <!--  功能按钮-回复/查看回复  -->
                                            <div>
                                                <div class="small text-right">
                                                    <ul class="list-unstyled list-inline">
                                                        <c:if test="${comment.userId == sessionScope.user.userId}">
                                                            <li>
                                                                <button onclick="removeComment(${comment.commentId})"
                                                                        class="btn btn-sm btn-primary m-t-n-xs">
                                                                    删除
                                                                </button>
                                                            </li>
                                                        </c:if>
                                                        <c:if test="${comment.commented}">
                                                            <li>
                                                                <a class="btn btn-sm btn-primary m-t-n-xs"
                                                                   href="/article/comment/viewReplay/${article.articleId}/${comment.commentPid == 0 ? comment.commentId:comment.commentPid}">
                                                                    查看回复
                                                                </a>
                                                            </li>
                                                        </c:if>
                                                        <li>
                                                            <button type="button" class="btn btn-sm btn-primary m-t-n-xs" onclick="hide(${comment.commentId})">
                                                                回复
                                                            </button>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <!--  撕逼用回复评论  -->
                                            <div class="col-lg-12">
                                                <div id="${comment.commentId}" class="col-lg-10 pull-right" style="display: none;">
                                                <div class="social-avatar">
                                                    <a href="/user/<%=userId%>" class="pull-left">
                                                        <img alt="image" src="<%=avatar%>">
                                                    </a>
                                                    <div class="media-body">
                                                        <a href="/user/<%=userId%>">
                                                            <%=nickname%>
                                                        </a>
                                                        <small class="text-muted">Now</small>
                                                    </div>
                                                </div>

                                                <div class="chat-form">
                                                    <form role="form" action="" method="post" name="comment">
                                                        <div class="form-group">
                                                            <br>
                                                            <textarea id="content_${comment.commentId}"
                                                                      class="form-control" placeholder="回复："
                                                                      required="required"></textarea>
                                                        </div>
                                                        <div class="text-right">
                                                            <button onclick="submit_1(${comment.commentId},
                                                                                            ${comment.commentPid == 0 ? comment.commentId:comment.commentPid},
                                                                                                '${comment.user.userNickname}')"
                                                                    type="button" class="btn btn-sm btn-primary m-t-n-xs">
                                                                <strong>发表评论</strong>
                                                            </button>
                                                        </div>
                                                    </form>
                                                </div>

                                            </div>
                                            </div>

                                        </div>
<%--                                        <hr>--%>
                                    </c:forEach>
                                </c:if>
                            </div>
                        </div>
                        <hr>
                        <div class="">
                            <div class="social-avatar">
                                <a href="/user/<%=userId%>" class="pull-left">
                                    <img alt="image" src="<%=avatar%>">
                                </a>
                                <div class="media-body">
                                    <a href="/user/<%=userId%>">
                                        <%=nickname%>
                                    </a>
                                    <small class="text-muted">Now</small>
                                </div>
                            </div>
                            <div class="chat-form">
                                <form role="form">
                                    <div class="form-group">
                                        <br>
                                        <textarea id="content_0" class="form-control" placeholder="回复：" required="required"></textarea>
                                    </div>
                                    <div class="text-right">
                                        <button onclick="submit_1(0, 0)" type="button" class="btn btn-sm btn-primary m-t-n-xs"><strong>发表评论</strong></button>
                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>


    </div>

        <div class="footer">
            <div class="pull-right">
                敏捷作业 made by <strong>shanhe</strong>
            </div>
            <div>
                <strong>Copyright</strong> NJU_shanhe &copy; 2020
            </div>
        </div>

    </div>
</div>

    <!-- Mainly scripts -->

        <script src="<%=basePath%>/resource/js/jquery-2.1.1.js"></script>
<%--        <script src="<%=basePath%>/resource/js/bootstrap.min.js"></script>--%>
        <script src="<%=basePath%>/resource/js/plugins/metisMenu/jquery.metisMenu.js"></script>
        <script src="<%=basePath%>/resource/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>


        <!-- Custom and plugin javascript -->
        <script src="<%=basePath%>/resource/js/inspinia.js"></script>
        <script src="<%=basePath%>/resource/js/plugins/pace/pace.min.js"></script>
    <script src="<%=basePath%>/resource/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function hide(a) {
            if(document.getElementById(a).style.display != 'none') {
                document.getElementById(a).style.display = 'none';
            } else {
                document.getElementById(a).style.display = '';
            }
        }

        function removeComment(commentId) {
            $.ajax({
                async: false,
                url: "/comment/remove",
                type: "GET",
                data:{
                    "commentId" : commentId
                },
                dataType: "json",
                success: function () {
                    window.location.reload();
                },
                error: function() {
                    alert("服务器异常");
                }
            })
        }

        function submit_1(commentTargetId, commentPid, commentTargetName) {
            let userId = <%=userId%>
            if(userId === -1) {
                alert("请登录后再评论");
            } else{
                let commentContent = document.getElementById('content_' + commentTargetId).value;
                $.ajax({
                    async:false,
                    url:"/comment/save",
                    type: "POST",
                    data:{
                        "articleId" : ${article.articleId},
                        "commentContent" : commentContent,
                        "commentTargetId" : commentTargetId,
                        "commentPid" : commentPid,
                        "commentTargetName" : commentTargetName,
                    },
                    dataType: "json",
                    success:function (data) {
                        window.location.reload();
                    },
                    error: function() {
                        alert("服务器异常");
                    }
                })
            }

        }

    </script>



</body>
</html>
