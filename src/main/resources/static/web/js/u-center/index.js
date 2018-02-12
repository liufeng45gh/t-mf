function hideShowMemberInfo(selfShow){
    var data_send = {};
    data_send.selfShow = selfShow;
    data_send.random = Math.random();

    var request =$.ajax({
        type: 'post',
        url: '/u-center/self-show',
        data: data_send,
        dataType: 'json'
    });

    request.fail(function( jqXHR, textStatus ) {
         layer.msg("系统错误", {icon: 5});
    });

    request.done(function(data) {
         if(data.ok){
            layer.msg("修改成功!");
            setTimeout(function(){
              window.location.reload();
            },1000);
         }else{
            layer.msg(data.message);
         }
    });
}

function alertNotDevelop(){
    layer.msg("此功能还未开发完成!", {icon: 5});
}