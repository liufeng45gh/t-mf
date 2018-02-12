$(document).ready(function () {
    $("#btn-submit").click(function () {
        var description = $("#desc-input").val();
        if (isEmpty(description)) {
            layer.msg("描述不能为空", {icon: 5});
            return;
        }

        var feature = $("#feature-input").val();
        if (isEmpty(feature)) {
            layer.msg("特色不能为空", {icon: 5});
            return;
        }

        var data_send = {};
        data_send.description =  description;
        data_send.feature =  feature;
        data_send.random = Math.random();

        var request =$.ajax({
            type: 'post',
            url: '/u-center/description-update',
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