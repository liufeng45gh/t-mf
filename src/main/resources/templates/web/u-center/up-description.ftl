
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
    <meta content="yes" name="apple-mobile-web-app-capable"/>
    <meta content="yes" name="apple-touch-fullscreen"/>
    <meta content="telephone=no" name="format-detection"/>
    <meta content="black" name="apple-mobile-web-app-status-bar-style"/>
    <title>修改描述与特色</title>
    <link rel="stylesheet" href="/css/u-center.css?v=20170526"/>
    <script  src="/web/js/jquery-3.1.1.js"></script>
    <script  src="/web/js/common.js"></script>
    <script  type="text/javascript" src="/layer/layer.js"></script>
</head>
<body >
<!--禁止chrome自动填充-->

<header id="header" style="display:block;">
    <span class="icon icon-goback"></span>
    <span class="txt-header">修改描述与特色</span>
</header>
<section class="page">

    <div class="wrap loginPage">
        <div  class="login-wrap login-wrap-active">
            <div class="area-container">
                <div class="fieldName">描述</div>
                <textarea id="desc-input" class="desc-area">${member.description!}</textarea>
            </div>
        </div>

        <div  class="login-wrap login-wrap-active">
            <div class="area-container">
                <div class="fieldName">特色</div>
                <textarea id="feature-input" class="feature-area">${member.feature!}</textarea>
            </div>
        </div>

        <div class="notice">&nbsp;</div>
        <div  id="btn-submit" class="btn btn-active" >提交修改</div>

        <a   class="btn btn-to-login" style="display:block;" href="/u-center/index.html">->返回主菜单</a>
    </div>
</section>
<script  src="/web/js/u-center/up-description.js?v=1.0"></script>
</body>
</html>
