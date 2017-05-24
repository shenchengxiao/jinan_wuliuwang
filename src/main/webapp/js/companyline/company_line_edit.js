$(function () {
    getCompanyLineDetail();

    $('#btn_comp_line_edit').on('click',function(){
        var validFlag = $('#comp_line_edit_form').valid();
        if (validFlag) {
            editCompLineUser();
        }else{
            return false;
        }

    });


    /**
     *  功能描述：添加用户验证
     */

    $('#comp_line_edit_form').validate({
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


function getCompanyLineDetail() {
    var id = getUrlParam('id');
    $.ajax({
        url:whole_path+'/api/company_line/detail',
        type:'GET',
        dataType:'json',
        data:{id:id},
        beforeSend:function(){
            $.progressBar({message:'<p>正在努力加载数据...</p>',modal:true,canCance:true});
        },
        success:function(data){
            if(data.status == 0){
                var json = data.data;
                $('#user_id').val(json.quId);
                $('input[name=username]').val(json.username);
                $('input[name=password]').val(json.password);
                $('input[name=certName]').val(json.certName);
                $('input[name=phone]').val(json.phone);
                $('input[name=certNumber]').val(json.certNumber);
                $('input[name=certAddress]').val(json.certAddress);
                $('input[name=compName]').val(json.compName);
                $('input[name=compAddress]').val(json.compAddress);
                $('input[name=compPhone]').val(json.compPhone);
                $('#compIntroduction').text(json.compIntroduction);
                $('input[name=zlineCity]').val(json.zlineCity);
                $('#remark').text(json.remark);
                $('#userTypeId').val(json.userTypeId).selected;
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

function editCompLineUser(){
    $.ajax({
        url:whole_path+'/api/company_line/add',
        type:'POST',
        dataType:'json',
        data:$('#comp_line_edit_form').serialize(),
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