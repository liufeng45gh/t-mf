
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
    <meta content="yes" name="apple-mobile-web-app-capable"/>
    <meta content="yes" name="apple-touch-fullscreen"/>
    <meta content="telephone=no" name="format-detection"/>
    <meta content="black" name="apple-mobile-web-app-status-bar-style"/>
    <title>修改昵称</title>
    <link rel="stylesheet" href="/css/u-center.css?v=20170526"/>
    <script  src="/web/js/jquery-3.1.1.js"></script>
    <script  src="/web/js/common.js"></script>
    <script  type="text/javascript" src="/layer/layer.js"></script>
</head>
<body >
<!--禁止chrome自动填充-->

<header id="header" style="display:block;">
    <span class="icon icon-goback"></span>
    <span class="txt-header">修改昵称</span>
</header>
<section class="page">

    <div class="wrap loginPage">
        <div id="username_login" class="login-wrap login-wrap-active">
            <div class="input-container">
                <div class="fieldName">昵称</div>
                <input id="nick-input" class="acc-input txt-input "  value="${member.nickName}" placeholder="请输入昵称" />

            </div>
        </div>

        <div class="notice">&nbsp;</div>
        <div  id="btn-submit" class="btn btn-active" >提交修改</div>

        <a   class="btn btn-to-login" style="display:block;" href="/u-center/index.html">->返回主菜单</a>
    </div>
</section>
<script  src="/web/js/u-center/up-nick.js?v=1.0"></script>
</body>
</html>
