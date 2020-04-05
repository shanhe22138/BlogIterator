<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<%--    <meta charset="utf-8">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Blog | Login</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>

    <link href="<%=basePath%>/resource/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>/resource/font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="<%=basePath%>/resource/css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>/resource/css/style.css" rel="stylesheet">
</head>
<body class="gray-bg">
<%
    String name = "";
    String password = "";
    Cookie[] cookies = request.getCookies();
    if(cookies != null) {
        for (Cookie c :
                cookies) {
           if("name".equals(c.getName())) {
               name = c.getValue();
           } else if ("password".equals(c.getName())) {
               password = c.getValue();
           }
        }
    }
%>

<div class="middle-box text-center loginscreen animated fadeInDown">
    <div>
        <div>

            <h1 class="logo-name">Blog</h1>

        </div>
        <h3>Welcome to Blog</h3>
        <p>这是2019-2020年度敏捷开发的大作业，登陆验证使用Shiro，前后端分离式开发，前端框架为Bootstrap，后端框架为SSM
            <!--Continually expanded and constantly improved Inspinia Admin Them (IN+)-->
        </p>
        <p>Login in. To see it in action.</p>
        <form class="m-t" id="loginForm">
            <div class="form-group">
                <input type="email" class="form-control" placeholder="Username" name="user" value="<%=name%>" required="required">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="Password" name="password" <%=password%> required="required">
            </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox" value="1" name="rememberMe"> 记住密码
                </label>
            </div>
            <button type="button" id="submit" class="btn btn-primary block full-width m-b">登陆</button>

            <a href="login.html#"><small>忘记密码?</small></a>
            <p class="text-muted text-center"><small>没有账号?</small></p>
            <a class="btn btn-sm btn-white btn-block" href="/register">注册</a>
        </form>
        <p class="m-t"> <small>Blog we app framework base on Bootstrap 3 &copy; 2020</small> </p>
    </div>
</div>

<%--<script src="/js/jquery.min.js"></script>--%>
<!-- Mainly scripts -->
<script src="<%=basePath%>/resource/js/jquery-2.1.1.js"></script>
<script src="<%=basePath%>/resource/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $("#submit").click(function() {
        $.ajax({
            async:false,
            url:"/loginVerify",
            type:"POST",
            data:$("#loginForm").serialize(),
            dataType:"json",
            success:function (data) {
                if(data.code == 1) {
                    alert(data.msg);
                    location.href="/home";
                } else {
                    alert(data.msg);
                    location.href="/login";
                }
            },
            error:function () {
                alert("数据获取失败");
            }
        })
    })
</script>

</body>
</html>
