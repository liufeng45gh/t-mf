function startUploadMore() {
	var form = $("#more-add-form");
	var input = $("#up-new-file");
	if (input.val().indexOf('%') >= 0) {
		alert("图片文件名不正确");
		return;
	}
	if (!check_extension(input.val(), {
		"png" : 1,
		"jpg" : 1,
		"jpeg" : 1,
		"gif" : 1
	})) {
		alert("文件格式不正确，只支持png,jpg,jpeg,gif文件");
		return;
	}

	if (input.val() == "") {
		return;
	}

    input.attr("name", "file");

	var options = {
		url : '/cloud/upload',
		dataType : 'json',
		success : function(responseData, statusText, xhr, $form) {
			if (statusText == "success") {
				// console.log("upload file success!");
                submitMorePictureAdd(responseData.data);

			}
		}
	};

	form.ajaxSubmit(options);

}

function check_extension(filename, hash) {
	if (filename == null || filename.length == 0)
		return true;

	var ext = filename.substring(filename.lastIndexOf('.') + 1);
	ext = ext.toLowerCase();
	if (hash[ext]) {
		return true;
	}

	return false;
}

function submitMorePictureAdd(picture){
    var data_send = {};
    data_send.picture =  picture;
    data_send.random = Math.random();

    var request =$.ajax({
        type: 'post',
        url: '/u-center/more-picture-add',
        data: data_send,
        dataType: 'json'
    });

    request.fail(function( jqXHR, textStatus ) {
         layer.msg("系统错误", {icon: 5});
    });

    request.done(function(data) {
         if(data.ok){
              layer.msg("添加成功!");
              setTimeout(function(){
                window.location.reload();
              },1000);
         }else{
            layer.msg(data.message);
         }
    });
}

$(document).ready(function() {
	$(document).on("change", "#up-new-file", function() {
		startUploadMore();
	});
});