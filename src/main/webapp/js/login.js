
$(function(){
    // 点击按钮提交
    $("#btn_submit_login").click(function(){
        var flag = $('#user_login_form').valid();
        if(flag){
            login();
        }else{
            return false;
        }
    });
    //enter提交
    $(document).keydown(function(event){
        if(event.keyCode==13){
            $("#btn_submit_login").click();
        }
    });


    /**
     *  功能描述：表单验证
     **/


    $('#user_login_form').validate({
        errorElement:'span',
        errorClass:'help-inline',
        focusInvalid:false,
        ignore:'',
        rules:{
            userName:{
                required:true
            },
            passWord:{
                required:true
            }
        },
        messages:{
            userName:{
                required:'请输入用户名'
            },
            passWord:{
                required:'请输入密码'
            }
        },
        invalidHandler:function(event,validator){
            $('.alert-success').hide();
            $('.alert-error').show();
        },
        highlight:function(element){
            $(element).closest('.help-inline').removeClass('ok');
            $(element).closest('.control-group').removeClass('success').addClass('error');
        },
        unhighlight:function(element){
            $(element).closest('.control-group').removeClass('error');
        },
        success:function(label){
            label.addClass('valid').addClass('help-inline ok').closest('.control-group').removeClass('error').addClass('success');
        },
        submitHandler:function(form){
            $('.alert-success').show();
            $('.alert-error').hide();
        }
    });
});

// 提交登录
function login(){

    $.ajax({
        url:whole_path+'/api/web/login',
        type: 'POST',
        dataType: 'json',
        data:$('#user_login_form').serialize(),
        beforeSend:function(data){
            $.progressBar({message:'<p>正在努力加载数据...</p>',modal:true,canCancel:true});
        },
        success:function(data) {
            if(data.status == 0){
                window.location.href =whole_path+'/main.jsp';
            }else{
                $.toast(data.msg,3000);
            }
        },
        complete:function(){
            $.progressBar().close();
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            $.toast('服务器未响应,请稍候重试',5000);
        }
    });
};




