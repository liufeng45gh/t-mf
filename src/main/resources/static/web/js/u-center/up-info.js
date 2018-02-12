$(document).ready(function () {
    $("#btn-submit").click(function () {
        var birthday = $("#birth-input").val().trim();
        if (isEmpty(birthday)) {
            layer.msg("生日不能为空", {icon: 5, offset: [$(window).height()/2-50+'px', $(window).width()/2-100+'px']});
            return;
        }

        var nationality = $("#nationality-input").val();
        if (isEmpty(nationality)) {
            layer.msg("国籍不能为空", {icon: 5, offset: [$(window).height()/2-50+'px', $(window).width()/2-100+'px']});
            return;
        }

        var height = $("#height-input").val();
        if (isEmpty(height)) {
            layer.msg("身高不能为空", {icon: 5, offset: [$(window).height()/2-50+'px', $(window).width()/2-100+'px']});
            return;
        }

        var bust = $("#bust-input").val();
        if (isEmpty(bust)) {
            layer.msg("胸围不能为空", {icon: 5, offset: [$(window).height()/2-50+'px', $(window).width()/2-100+'px']});
            return;
        }


        var weight = $("#weight-input").val();
        if (isEmpty(weight)) {
            layer.msg("体重不能为空", {icon: 5, offset: [$(window).height()/2-50+'px', $(window).width()/2-100+'px']});
            return;
        }

        var city = $("#city-input").val();
        if (isEmpty(city)) {
            layer.msg("城市不能为空", {icon: 5, offset: [$(window).height()/2-50+'px', $(window).width()/2-100+'px']});
            return;
        }

        var language = $("#language-input").val();
        if (isEmpty(language)) {
            layer.msg("语言不能为空", {icon: 5, offset: [$(window).height()/2-50+'px', $(window).width()/2-100+'px']});
            return;
        }




        var data_send = {};
        data_send.birthday =  birthday;
        data_send.nationality =  nationality;
        data_send.height =  height;
        data_send.bust =  bust;
        data_send.weight =  weight;
        data_send.city =  city;
        data_send.language =  language;
        data_send.line = $("#line-input").val();
        data_send.facebook = $("#facebook-input").val();
        data_send.email = $("#email-input").val();
        data_send.random = Math.random();

        var request =$.ajax({
            type: 'post',
            url: '/u-center/info-update',
            data: data_send,
            dataType: 'json'
        });

        request.fail(function( jqXHR, textStatus ) {
             layer.msg("系统错误", {icon: 5, offset: [$(window).height()/2-50+'px', $(window).width()/2-100+'px']});
        });

        request.done(function(data) {
             if(data.ok){
                  layer.msg("修改成功!",{ offset: [$(window).height()/2-50+'px', $(window).width()/2-50+'px']});
             }else{
                layer.msg(data.message, {icon: 5, offset: [$(window).height()/2-50+'px', $(window).width()/2-100+'px']});
             }
        });
    });
});