var postUploadUrl  = getAppPath()+"/api/web/upload/submit";
function uploadFile(fileid,callBack){
	var fileTarget = "#" + fileid;
	//var errorTarget = "#" + errorid;
	var file = $(fileTarget).val();
	if (file != null && file != '') {
		//$(errorTarget).html("上传中，请稍后");
		$.ajaxFileUpload({
			url : postUploadUrl,
			secureuri : false,
			fileElementId : fileid,
			dataType : 'json',
			success : function(data, textStatus) {
				if (data.code == 500) {
					alert(data.message);
				}else{
					$.globalEval(callBack(data.fileInfo));
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				//alert(errorThrown);
			}
		});
	}else{
		alert("请选择上传文件");
	}
}