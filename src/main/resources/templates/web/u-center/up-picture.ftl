
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" />
    <meta content="yes" name="apple-mobile-web-app-capable"/>
    <meta content="yes" name="apple-touch-fullscreen"/>
    <meta content="telephone=no" name="format-detection"/>
    <meta content="black" name="apple-mobile-web-app-status-bar-style"/>
    <title>修改图片</title>
    <link rel="stylesheet" href="/css/u-center.css?v=1.1"/>
    <script  src="/web/js/jquery-3.1.1.js"></script>
    <script  src="/web/js/common.js"></script>
    <script  type="text/javascript" src="/layer/layer.js"></script>
    <script type="text/javascript" charset="UTF-8" src="/cms/script/jquery.form-3.45.js"></script>
</head>
<body >
<!--禁止chrome自动填充-->

<header id="header" style="display:block;">
    <span class="icon icon-goback"></span>
    <span class="txt-header">修改图片</span>
</header>
<section class="page">

    <div class="wrap loginPage">
        <div  class="login-wrap login-wrap-active">
            <div class="area-container">
                <div class="fieldName">封面图</div>
                <form  method="post" id="hfc-form">
                    <div class="logo_outer">
                        <input type="file" class="addLogoInput" id="up_file" style="width:100%;"/>
                        <img width="100%" height="100%" src="${member.picture?default("/images/up-icon.jpg")}" id="logo_cover"/>
                    </div>
                </form>
            </div>
        </div>

        <div  class="login-wrap login-wrap-active">
            <div class="area-container">
                <div class="fieldName">更多图片</div>
                <#list pictureList as picture>
                <div class="more-img-con">
                   <img src="${picture.pictureUrl}"/>
                    <div class="img-delete-btn" onclick="deletePicture(${picture.id});">删除</div>
                </div>
                </#list>
            </div>
        </div>

        <div class="notice">&nbsp;</div>
        <form  method="post" id="more-add-form">
            <div  id="btn-add-img" class="btn btn-add-img" >
                <input type="file" class="file-full" id="up-new-file" style="width:100%;"/>
                <div class="button-full">添加更多新图</div>
            </div>
        </form>

        <a   class="btn btn-to-login" style="display:block;margin-top: 0.3rem;" href="/u-center/index.html">->返回主菜单</a>
    </div>
</section>
<script  src="/web/js/u-center/up-picture.js?v=1.0"></script>
<script type="text/javascript" charset="UTF-8" src="/web/js/u-center/main-picture-select.js?v=1.0"></script>
<script type="text/javascript" charset="UTF-8" src="/web/js/u-center/more-picture-add.js?v=1.1"></script>
</body>
</html>
