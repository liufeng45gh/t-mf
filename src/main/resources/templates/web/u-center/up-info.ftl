
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
    <meta content="yes" name="apple-mobile-web-app-capable"/>
    <meta content="yes" name="apple-touch-fullscreen"/>
    <meta content="telephone=no" name="format-detection"/>
    <meta content="black" name="apple-mobile-web-app-status-bar-style"/>
    <title>编辑会员资料</title>
    <link rel="stylesheet" href="/css/u-center.css?v=20170526"/>
    <script  src="/web/js/jquery-3.1.1.js"></script>
    <script src="/web/js/jquery-1.10.2.js"></script>
    <script src="/web/js/jquery-migrate-1.2.1.js"></script>
    <script  src="/web/js/common.js"></script>
    <script  type="text/javascript" src="/layer/layer.js"></script>
    <link rel="stylesheet" type="text/css" href="/timepicker/css/jquery-ui.css" />
    <script type="text/javascript" src="/timepicker/js/jquery-ui.js"></script>
    <script type="text/javascript" src="/timepicker/js/jquery-ui-slide.min.js"></script>
    <script type="text/javascript" src="/timepicker/js/jquery-ui-timepicker-addon.js"></script>
</head>
<body >
<!--禁止chrome自动填充-->

<header id="header" style="display:block;">
    <span class="icon icon-goback"></span>
    <span class="txt-header">编辑会员资料</span>
</header>
<section class="page">

    <div class="wrap loginPage">
        <div class="login-wrap login-wrap-active">
            <div class="input-container">
                <div class="fieldName">生日*</div>
                <input id="birth-input" class="acc-input txt-input "  value="${(member.birthday?string("yyyy-MM-dd"))!}" placeholder="请输入生日" readonly="readonly"/>

            </div>
        </div>

        <div  class="login-wrap login-wrap-active">
            <div class="input-container">
                <div class="fieldName">国籍*</div>
                <input id="nationality-input" class="acc-input txt-input "  value="${(member.nationality)!}" placeholder="请输入国籍" />
            </div>
        </div>

        <div  class="login-wrap login-wrap-active">
            <div class="input-container">
                <div class="fieldName">身高*</div>
                <input id="height-input" class="acc-input txt-input "  value="${(member.height)!}" placeholder="请输入身高" />
            </div>
        </div>

        <div  class="login-wrap login-wrap-active">
            <div class="input-container">
                <div class="fieldName">胸围*</div>
                <input id="bust-input" class="acc-input txt-input "  value="${(member.bust)!}" placeholder="请输入胸围" />
            </div>
        </div>

        <div  class="login-wrap login-wrap-active">
            <div class="input-container">
                <div class="fieldName">体重*</div>
                <input id="weight-input" class="acc-input txt-input "  value="${(member.weight)!}" placeholder="请输入体重" />
            </div>
        </div>

        <div  class="login-wrap login-wrap-active">
            <div class="input-container">
                <div class="fieldName">所在城市*</div>
                <input id="city-input" class="acc-input txt-input "  value="${(member.city)!}" placeholder="请输入所在城市" />
            </div>
        </div>

        <div  class="login-wrap login-wrap-active">
            <div class="input-container">
                <div class="fieldName">语言*</div>
                <input id="language-input" class="acc-input txt-input "  value="${(member.language)!}" placeholder="请输入语言" />
            </div>
        </div>

        <div  class="login-wrap login-wrap-active">
            <div class="input-container">
                <div class="fieldName">line</div>
                <input id="line-input" class="acc-input txt-input "  value="${(member.line)!}" placeholder="请输入line" />
            </div>
        </div>

        <div  class="login-wrap login-wrap-active">
            <div class="input-container">
                <div class="fieldName">facebook</div>
                <input id="facebook-input" class="acc-input txt-input "  value="${(member.facebook)!}" placeholder="请输入facebook" />
            </div>
        </div>

        <div  class="login-wrap login-wrap-active">
            <div class="input-container">
                <div class="fieldName">邮箱</div>
                <input id="email-input" class="acc-input txt-input "  value="${(member.email)!}" placeholder="请输入邮箱" />
            </div>
        </div>





        <div class="notice">&nbsp;</div>
        <div  id="btn-submit" class="btn btn-active" >提交修改</div>

        <a   class="btn btn-to-login" style="display:block;" href="/u-center/index.html">->返回主菜单</a>
    </div>
</section>
<script  src="/web/js/u-center/up-info.js?v=1.0"></script>
<script>
$(document).ready(function () {
    $('#birth-input').datetimepicker({
         timepicker: false,
         showHour: false,
         showMinute: false,
         showSecond: false,
         timeFormat: ''
    });
});
</script>
</body>
</html>
