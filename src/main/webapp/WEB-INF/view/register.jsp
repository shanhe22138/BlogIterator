<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--[if IE 8]>
<html xmlns="http://www.w3.org/1999/xhtml" class="ie8" lang="zh-CN">
<![endif]-->
<!--[if !(IE 8) ]><!-->
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<!--<![endif]-->
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

    <title> Blog | 注册</title>

    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>

    <link href="<%=basePath%>/resource/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>/resource/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="<%=basePath%>/resource/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="<%=basePath%>/resource/css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>/resource/css/style.css" rel="stylesheet">

</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen   animated fadeInDown">
    <div>
        <div>

            <h1 class="logo-name">Blog</h1>

        </div>
        <h3>Register to Blog</h3>
        <p>Create account to see it in action.</p>
        <form class="m-t" role="form" id="registerForm" name="registerForm">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Nickname" name="nickname" required="">
            </div>
            <div class="form-group">
                <input id="user" class="form-control" placeholder="Email" name="uname" required="required">
            </div>
            <div class="form-group">
                <input id="pwd" type="password" class="form-control" placeholder="Password" name="password" required="required">
            </div>
            <div class="form-group">
                <input id="rePwd" type="password" class="form-control" placeholder="Password" required="required">
            </div>
            <div class="form-group">
                <div class="checkbox i-checks"><label> <input type="checkbox"><i></i> 接受条款和政策 </label></div>
            </div>
            <button type="button" id="submit" class="btn btn-primary block full-width m-b">注册</button>

            <p class="text-muted text-center"><small>已有账号？</small></p>
            <a class="btn btn-sm btn-white btn-block" href="/login">登陆</a>
        </form>
        <p class="m-t"> <small>Blog we app framework base on Bootstrap 3 &copy; 2020</small> </p>
    </div>
</div>

<!-- Mainly scripts -->
<script src="<%=basePath%>/resource/js/jquery-2.1.1.js"></script>
<script src="<%=basePath%>/resource/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $("#submit").click(function() {
        var pwd = $("#pwd").val();
        var repwd = $("#rePwd").val();

        if(repwd != pwd) {
            alert("两次密码不一样，请重新输入！");
        } else {
            $.ajax({
                async:false,
                url:"/registerVerify",
                type:"POST",
                data:$("#registerForm").serialize(),
                dataType:"json",
                success:function(data) {
                    if(data.code == 1) {
                        alert(data.msg);
                        window.location.href="/login";
                    } else {
                        alert(data.msg);
                        window.location.href="/register";
                    }
                },
                error: function () {
                    alert("数据获取异常！");
                }
            })
        }
    })
</script>
<!-- iCheck -->
<script src="<%=basePath%>/resource/js/plugins/iCheck/icheck.min.js"></script>
<script>
    $(document).ready(function(){
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });

</script>

</body>
</html>