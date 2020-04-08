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
    <rapid:block name="title">

        <title>Blog | Home</title>
    </rapid:block>



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
    <!--  左侧导航栏  -->
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

        <!--  上方导航栏  -->
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
                    <rapid:block name="dir">
                        <li class="active">
                            <strong>全部文章</strong>
                        </li>
                    </rapid:block>

                </ol>
            </div>
            <div class="col-lg-2">

            </div>
        </div>


        <rapid:block name="content">
            <div class="wrapper wrapper-content  animated fadeInRight blog">
                <div class="row">
                    <div class="col-lg-6">
                        <c:if test="${!empty pageInfo.list}">
                            <c:forEach items="${pageInfo.list}" var="a">
                                <div class="ibox">
                                    <div class="ibox-content">
                                        <a href="/article/${a.articleId}" class="btn-link">
                                            <h2>${a.articleTitle}</h2>
                                        </a>
                                        <div>
                                            <strong>${a.user.userNickname}</strong>
                                            <span class="text-muted">
                                                <i class="fa fa-clock-o"></i>
                                                <fmt:formatDate value="${a.articleUpdateTime}" type="both"/>
                                            </span>
                                        </div>
                                        <p>${a.articleSummary}</p>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <h5>Tags:</h5>
                                                <c:if test="${!empty a.tags}">
                                                    <c:forEach items="${a.tags}" var="tag">
                                                        <button class="btn  btn-white btn-xs" type="button">${tag.tagName}</button>
                                                    </c:forEach>
                                                </c:if>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="small text-right">
                                                    <div>
                                                        <div>
                                                            <i class="fa fa-comments-o"> </i> ${a.articleCommentCount} comments
                                                        </div>
                                                        <i class="fa fa-eye"> </i> ${a.articleViewCount} views
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>


                <nav aria-label="Page navigation">
                    <ul class="pagination" id="page">
                    </ul>
                </nav>
            </div>
        </rapid:block>

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
<rapid:block name="script">
    <script src="<%=basePath%>/resource/js/jquery-2.1.1.js"></script>
    <script src="<%=basePath%>/resource/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>/resource/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="<%=basePath%>/resource/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="<%=basePath%>/resource/js/inspinia.js"></script>
    <script src="<%=basePath%>/resource/js/plugins/pace/pace.min.js"></script>

    <script type="text/javascript">
        const ul = document.querySelector("#page");
        let curPage = ${pageInfo.pageNum};
        let star = curPage - 2 > 1 ? curPage-2 : 1;
        let end = star + 4 > ${pageInfo.pages} ? ${pageInfo.pages} : star+4;
        let html = "";
        let start_flag = ${pageInfo.isLastPage};
        if(! start_flag) {
            html += '<li><a href="/home?pageNum=${pageInfo.prePage}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>'
        }
        for(let i = star; i <= end; i++) {
            if(i == curPage) {
                html += '<li class="active"><a href="/home?pageNum='+i+'">'+i+'</a></li>';
            } else {
                html += '<li><a href="/home?pageNum='+i+'">'+i+'</a></li>';
            }
        }
        let end_flag = ${pageInfo.isLastPage};
        if(! end_flag) {
            html += '<li><a href="/home?pageNum=${pageInfo.nextPage}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>';
        }
        ul.innerHTML = html;
    </script>
</rapid:block>




</body>
</html>
