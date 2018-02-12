$(document).ready(function () {
    $("#btn-submit").click(function () {
        var nick = $("#nick-input").val();
        if (isEmpty(nick)) {
            layer.msg("昵称不能为空", {icon: 5});
            return;
        }

        var data_send = {};
        data_send.nickName =  nick;
        data_send.random = Math.random();

        var request =$.ajax({
            type: 'post',
            url: '/u-center/nick-update',
            data: data_send,
            dataType: 'json'
        });

        request.fail(function( jqXHR, textStatus ) {
             layer.msg("系统错误", {icon: 5});
        });

        request.done(function(data) {
             if(data.ok){
                  layer.msg("修改成功!");
             }else{
                layer.msg(data.message);
             }
        });
    });
});