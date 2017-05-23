<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script src="${ctx }/js/lib/uploadify/jquery.uploadify.js"></script>
<link rel="stylesheet" href="${ctx }/js/lib/uploadify/uploadify.css">
<script>
    $(function () {
        $('#uploadFileWin').window('close');
        $('#file_upload').uploadify({
            'swf': appPath + '/js/lib/uploadify/uploadify.swf',      //FLash文件路径
            'cancelImg': appPath + '/js/lib/uploadify/uploadify-cancel.png',
            'buttonText': '浏  览',                        //按钮文本
            'uploader': appPath + '/flow/api/fileUpload/submit', //处理ASHX页面
            'auto': false,                                 //选择文件后是否自动上传，默认为true
            'multi': false,                                 //是否为多选，默认为true
            'removeCompleted': true,                       //是否完成后移除序列，默认为true
            'queueID': 'fileQueue',                        //页面上作为文件上传队列的元素的ID
            'queueSizeLimit': 1,                          //允许上传的文件数量上限.默认是999
            'fileSizeLimit': '1MB',                       //单个文件大小，0为无限制，可接受KB,MB,GB等单位的字符串值
            'fileTypeDesc': 'Image Files',                 //文件描述
            'fileTypeExts': '*.gif; *.jpg; *.png; *.bmp',  //上传的文件后缀过滤器
            'onUploadSuccess': function (event, data) {    //所有队列完成后事件
                console.log(data);
                console.log(event);
                callBackSuccess(data);
                alert("上传完毕！");
            },
            'onFallback':function(){
                alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
            },
            'onCancel': function (event, queueId, fileObj, data) {
                //delete this.queueData.files[queueId];
                //alert(errorObj.type + "：" + errorObj.info);
            },
            'onUploadError': function (event, queueId, fileObj, errorObj) {
                //alert(errorObj.type + "：" + errorObj.info);
            },
            'overrideEvents': ['onSelectError', 'onDialogClose'],
            'onSelectError': function (file, errorCode, errorMsg) {
                switch (errorCode) {
                    case -110:
                        alert("文件 [" + file.name + "] 大小超出系统限制的" + $('#file_upload').uploadify('settings', 'fileSizeLimit') + "大小！");
                        break;
                    case -120:
                        alert("文件 ["+file.name+"] 大小异常！");
                        break;
                    case -130:
                        alert("文件 ["+file.name+"] 类型不正确！");
                        break;
                }
            }
        });
    });
    function openUploadFileWin(callBack,args) {
        $('#uploadFileWin').window({
            title: "上传文件",
            modal: true,
            shadow: true,
            collapsible: false,
            minimizable: false,
            maximizable: false
        });
        $('#uploadFileWin').window('move', {top: 80});
        $('#uploadFileWin').window('open');
        callBack.call(this,args);
    }
    function startUploadFile(){
        $('#file_upload').uploadify('upload','*');
    }
</script>
<div id="uploadFileWin" class="easyui-window" style="width:500px;height:200px;padding:10px;">
    <form id="form1" enctype="multipart/form-data">
        <div>
            <input type="file" name="file_upload" id="file_upload" />
            <input type="button" class="btn btn-success" id="uploadify-button" onclick="startUploadFile();" value="上传" />
        </div>
        <div id="fileQueue" class="fileQueue"></div>
    </form>
</div>