
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
    <meta content="yes" name="apple-mobile-web-app-capable"/>
    <meta content="yes" name="apple-touch-fullscreen"/>
    <meta content="telephone=no" name="format-detection"/>
    <meta content="black" name="apple-mobile-web-app-status-bar-style"/>
    <title>修改价格</title>
    <link rel="stylesheet" href="/css/u-center.css?v=20170526"/>
    <script  src="/web/js/jquery-3.1.1.js"></script>
    <script src="/web/js/jquery-1.10.2.js"></script>
    <script src="/web/js/jquery-migrate-1.2.1.js"></script>
    <script  src="/web/js/common.js"></script>
    <script  type="text/javascript" src="/layer/layer.js"></script>
</head>
<body >
<!--禁止chrome自动填充-->

<header id="header" style="display:block;">
    <span class="icon icon-goback"></span>
    <span class="txt-header">编辑价格</span>
</header>
<section class="page">

    <div class="wrap loginPage">



        <div  class="login-wrap login-wrap-active">
            <div class="input-container">
                <div class="fieldName">单次价格*</div>
                <input id="timePrice-input" class="acc-input txt-input "  value="${(member.timePrice)!}" placeholder="请输入单次价格" />
            </div>
        </div>

        <div  class="login-wrap login-wrap-active">
            <div class="input-container">
                <div class="fieldName">包夜价格*</div>
                <input id="nightPrice-input" class="acc-input txt-input "  value="${(member.nightPrice)!}" placeholder="请输入包夜价格" />
            </div>
        </div>

        <div  class="login-wrap login-wrap-active">
            <div class="input-container">
                <div class="fieldName">包天价格*</div>
                <input id="dayPrice-input" class="acc-input txt-input "  value="${(member.dayPrice)!}" placeholder="请输入包天价格" />
            </div>
        </div>
        <div class="notice">&nbsp;</div>
        <div  id="btn-submit" class="btn btn-active" >提交修改</div>

        <a   class="btn btn-to-login" style="display:block;" href="/u-center/index.html">->返回主菜单</a>
    </div>
</section>
<script  src="/web/js/u-center/up-price.js?v=1.1"></script>

</body>
</html>
