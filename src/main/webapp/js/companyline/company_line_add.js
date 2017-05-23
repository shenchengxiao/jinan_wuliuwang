
$(function(){

    $('#btn_comp_line').on('click',function(){
        var validFlag = $('#comp_line_form').valid();
        if (validFlag) {
            addCompLineUser();
        }else{
            return false;
        }

    });

    //用户编号监听事件
    $('#userName').bind('input propertychange', function() {
        $('#userNum').val($(this).val());
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
            },
            phone:{
                required: true
            },
            certNumber:{
                required: true
            }
        },
        messages:{

            username:{
                required:'请输入帐号'
            },
            password:{
                required:'请输入密码'
            },
            phone:{
                required:'请输入手机号码'
            },
            certNumber:{
                required:'请输入身份证号'
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
$("#userName").blur(function(){
    $.ajax({
        url:manage_path+'/api/user_manage/verify',
        type:'GET',
        cache:false,
        dataType:'json',
        data:{userName:$('#userName').val()},
        beforeSend:function(){
            $.progressBar({message:'<p>正在努力加载数据...</p>',modal:true,canCance:true});
        },
        success:function(data){
            if(data.status == 0){
                if (data.data.length > 0) {
                    var txt = "此用户已存在,请重新输入！";
                    window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.success);
                    $('#userName').val('');
                    $('#userNum').val('');
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


