$(document).ready(function () {
    $("#btn-submit").click(function () {
        var phone = $("#phone-input").val();
        if (isEmpty(phone)) {
            layer.msg("手机号码不能为空", {icon: 5});
            return;
        }
        if (!validMobileFormat(phone)) {
            layer.msg("手机号码校验错误", {icon: 5});
            return;
        }

        var imgCode = $("#img-check-input").val();
        if (isEmpty(imgCode)||imgCode.length != 4) {
            layer.msg("图片验证码输入有误", {icon: 5});
            return;
        }

        var password = $("#pass-input").val();
        if (isEmpty(password)||password.length < 6) {
            layer.msg("密码长度不能小于6位", {icon: 5});
            return;
        }
        var data_send = {};
        data_send.phone = $("#acc-select").val() + phone;
        data_send.password = password;
        data_send.imgCode = imgCode;
        data_send.random = Math.random();


        var request =$.ajax({
            type: 'post',
            url: '/login',
            data: data_send,
            dataType: 'json'
        });

        request.fail(function( jqXHR, textStatus ) {
             layer.msg("系统错误", {icon: 5});
        });

        request.done(function(data) {
             if(data.ok){
                  delCookie("token");
                  setSessionCookie("token",data.data.token);
                  layer.msg("登录成功!");
                  setTimeout(function(){
                    window.location.href = "/u-center/index.html";
                  },1000);

             }else{
                layer.msg(data.message);
             }
        });
    });
});