function deletePicture(picId){
    layer.confirm('确定要删除吗？', {
      btn: ['取消','确定'] //按钮
    }, function(){
      layer.closeAll();
    }, function(){
      deletePictureSubmit(picId);
    });
}

function deletePictureSubmit(picId){
    var data_send = {};
    data_send.id = picId;
    data_send.random = Math.random();

    var request =$.ajax({
        type: 'post',
        url: '/u-center/picture-delete',
        data: data_send,
        dataType: 'json'
    });

    request.fail(function( jqXHR, textStatus ) {
         layer.msg("系统错误", {icon: 5});
    });

    request.done(function(data) {
         if(data.ok){
            layer.msg("删除成功!");
            setTimeout(function(){
              window.location.reload();
            },1000);
         }else{
            layer.msg(data.message);
         }
    });
}