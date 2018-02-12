<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
    <meta content="yes" name="apple-mobile-web-app-capable"/>
    <meta content="yes" name="apple-touch-fullscreen"/>
    <meta content="telephone=no" name="format-detection"/>
    <meta content="black" name="apple-mobile-web-app-status-bar-style"/>
    <title>用户中心</title>
    <link rel="stylesheet" href="/css/u-center.css?v=1.0"/>
    <script  src="/web/js/jquery-3.1.1.js"></script>
    <script  src="/web/js/common.js"></script>
    <script  type="text/javascript" src="/layer/layer.js"></script>
</head>
<body >
<!--禁止chrome自动填充-->

<header id="header" style="display:block;">
    <span class="icon icon-goback"></span>
    <span class="txt-header">用户中心-主菜单</span>
</header>
<section class="page">
    <div class="wrap loginPage">
        <div class="notice">尊敬的会员: ${member.nickName}</div>

        <a   class="btn btn-to-login" style="display:block;" href="/u-center/nick-update">昵称修改</a>
        <a   class="btn btn-to-login" style="display:block;" href="/u-center/info-update">个人资料修改</a>
        <a   class="btn btn-to-login" style="display:block;" href="/u-center/description-update">描述与特色修改</a>
        <a   class="btn btn-to-login" style="display:block;" href="/u-center/picture-update">照片修改</a>
        <a   class="btn btn-to-login" style="display:block;" href="#" onclick="alertNotDevelop();return false;">视频修改</a>
        <a   class="btn btn-to-login" style="display:block;" href="/u-center/price-update">价格修改</a>
        <#if member.selfShow?default(1) = 1>
        <a   class="btn btn-to-login" style="display:block;" href="#" onclick="hideShowMemberInfo(0);return false;">屏蔽个人信息</a>
        <#else>
        <a   class="btn btn-warn" style="display:block;" href="#" onclick="hideShowMemberInfo(1);return false;">显示个人信息</a>
        </#if>

        <a   class="btn btn-login-out" style="display:block;" href="/logout">退出登录</a>
    </div>
</section>
<script  src="/web/js/u-center/index.js?v=1.0"></script>
</body>
</html>
