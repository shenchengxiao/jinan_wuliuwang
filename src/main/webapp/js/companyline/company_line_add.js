
$(function(){

    $('#btn_comp_line').on('click',function(){
        var validFlag = $('#comp_line_form').valid();
        if (validFlag) {
            addCompLineUser();
        }else{
            return false;
        }

    });

    //选中平台验证日期
    $('#aloginType').on('click',function(){
        if($("#aloginType").is(':checked')){
            $("#astopTime").prop("required", "true");
            $("#aloginType").val(2);
        }else{
            $("#astopTime").removeAttr("required");
        }

    });
    $('#iloginType').on('click',function(){
        if($("#iloginType").is(':checked')){
            $("#istopTime").prop("required", "true");
            $("#iloginType").val(1);
        }else{
            $("#istopTime").removeAttr("required");
        }

    });

    /**
     *  功能描述：添加用户验证
     */

    $('#comp_line_form').validate({
        errorElement:'span',
        errorClass:'error',
        focusInvalid:false,
        ignore:'',
        rules:{
            username:{
                required:true
            },
            password: {
                required: true
            }
        },
        messages:{

            username:{
                required:'请输入帐号'
            },
            password:{
                required:'请输入密码'
            }
        },
        invalidHandler:function(event,validator){
            $('.alert-success').hide();
            $('.alert-error').show();
        },
        highlight:function(element){
            $(element).closest('.help-inline').removeClass('ok');
            $(element).closest('.form-group').removeClass('success').addClass('error');
        },
        unhighlight:function(element){
            $(element).closest('.form-group').removeClass('error');
        },
        success:function(label){
            label.addClass('valid').addClass('help-inline ok').closest('.form-group').removeClass('error').addClass('success');
        },
        submitHandler:function(form){
            $('.alert-success').show();
            $('.alert-error').hide();
        }
    });


});

/**
 *  功能描述：添加企业版、专线版
 *  请求方式：POST
 *  请求地址：/api/user_manage/edit_user
 *  函数名称：addUserInfo
 */
function addCompLineUser(){
    $.ajax({
        url:whole_path+'/api/company_line/add',
        type:'POST',
        dataType:'json',
        data:$('#comp_line_form').serialize(),
        beforeSend:function(){
            $.progressBar({message:'<p>正在努力加载数据...</p>',modal:true,canCance:true});
        },
        success:function(data){
            if(data.status == 0){
                $.toast('操作成功',1000);
                setTimeout(function(){
                    window.location.href = 'company_line_list.jsp';
                },1000);
            }else {
                $.toast('操作失败,系统错误',1000);
            }
        },
        complete:function(){
            $.progressBar().close();
        },
        error:function(XMLHttpRequest,textStatus,errorThrown){
            $.toast('服务器未响应,请稍候重试',5000);
        }
    });
}

//校验用户是否已存在
$("#user_name_id").blur(function(){
    $.ajax({
        url:whole_path+'/api/company_line/verify',
        type:'GET',
        cache:false,
        dataType:'json',
        data:{
            'userType':$('#userTypeId option:selected').val(),
            'userName':$('#user_name_id').val()
        },
        beforeSend:function(){
            $.progressBar({message:'<p>正在努力加载数据...</p>',modal:true,canCance:true});
        },
        success:function(data){
            if(data.status == 0){
                if (data.data == true) {
                    var txt = "此用户已存在,请重新输入！";
                    window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.success);
                    $('#user_name_id').val('');
                }
            }else {
                $.toast('操作失败,系统错误',1000);
            }
        },
        complete:function(){
            $.progressBar().close();
        },
        error:function(XMLHttpRequest,textStatus,errorThrown){
            $.toast('服务器未响应,请稍候重试',5000);
        }
    });
})


