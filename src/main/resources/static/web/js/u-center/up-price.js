$(document).ready(function () {
    $("#btn-submit").click(function () {


        var timePrice = $("#timePrice-input").val();
        if (isEmpty(timePrice)) {
            layer.msg("单次价格不能为空", {icon: 5});
            return;
        }

        var nightPrice = $("#nightPrice-input").val();
        if (isEmpty(nightPrice)) {
            layer.msg("包夜价格不能为空", {icon: 5});
            return;
        }


        var dayPrice = $("#dayPrice-input").val();
        if (isEmpty(dayPrice)) {
            layer.msg("包天价格不能为空", {icon: 5});
            return;
        }




        var data_send = {};
        data_send.timePrice =  timePrice;
        data_send.nightPrice =  nightPrice;
        data_send.dayPrice =  dayPrice;
        data_send.random = Math.random();

        var request =$.ajax({
            type: 'post',
            url: '/u-center/price-update',
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
                layer.msg(data.message, {icon: 5});
             }
        });
    });
});