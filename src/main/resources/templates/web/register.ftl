
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
    <meta content="yes" name="apple-mobile-web-app-capable"/>
    <meta content="yes" name="apple-touch-fullscreen"/>
    <meta content="telephone=no" name="format-detection"/>
    <meta content="black" name="apple-mobile-web-app-status-bar-style"/>
    <title>注册</title>
    <link rel="stylesheet" href="/css/login.css?v=20170526"/>
    <script  src="/web/js/jquery-3.1.1.js"></script>
    <script  src="/web/js/common.js"></script>
    <script  type="text/javascript" src="/layer/layer.js"></script>
</head>
<body >
<!--禁止chrome自动填充-->

<header id="header" style="display:block;">
    <span class="icon icon-goback"></span>
    <span class="txt-header">注册/找回密码</span>
</header>
<section class="page">

    <div class="wrap loginPage">
        <div id="username_login" class="login-wrap login-wrap-active">
            <div class="input-container">
                <div class="fieldName">手机号</div>
                <input id="phone-input" class="acc-input txt-input " type="text" value="" placeholder="请输入手机号" />
                <select class="acc-select" id="acc-select">
                    <option value="+66">泰国</option>
                    <option value="+86">中国</option>
                </select>
            </div>
            <div id="input-code" class="input-container" >
                <div class="fieldName">图片验证码</div>
                <input id="img-check-input" class="acc-input txt-input" placeholder="请输入图片验证码"   />
                <div class="img-box" onclick="changeCaptcha();"><img id="captchaImg" src="/captcha-image" /></div>
                <!--
                <span class="light_gray" style="margin-left:45px;">看不清？<a class="link" href="javascript:changeCaptcha();">换一张</a></span>
                -->
                <i class="icon icon-clear"></i>
            </div>
            <div class="input-container">
                <div class="fieldName">短信验证码</div>
                <input id="phone-check-input" class="acc-input  txt-input "  placeholder="请输入短信验证码" />
                <div class="acc-btn" id="send-code-btn">发送验证码</div>
                <div class="acc-btn btn-message" style="display: none;" id="btn-message"></div>
            </div>
            <div class="input-container">
                <div class="fieldName">密码</div>
                <input id="pass-input" type="password" class="acc-input txt-input J_ping" placeholder="请输入6-12位密码"  />
                <i class="icon icon-clear"></i>
            </div>

        </div>

       

        <div class="notice">&nbsp;</div>
        <div  id="btn-submit" class="btn btn-active" >提交注册/找回密码</div>

        <a   class="btn btn-to-login" style="display:block;" href="/login">已有账号->去登录</a>


        
        
    </div>
</section>
<script  src="/web/js/register.js?v=1.0"></script>
<script>
function changeCaptcha(){
	document.getElementById("captchaImg").src="/captcha-image?"+Math.random();
}
</script>
</body>
</html>
