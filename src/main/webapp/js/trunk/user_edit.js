
$(function(){

    getUserDetail();

    $('#save_from').on('click',function(){
        var validFlag = $('#add_user_info_form').valid();
        if (validFlag) {
            editUserInfo();
        }else{
            return false;
        }

    });
    
    $('#cancel').on('click',function(){
        location.href = whole_path+"/view/trunk/user_list.jsp";

      });

    //用户编号监听事件
    /*$('#userName').bind('input propertychange', function() {
        $('#userNum').val($(this).val());
    });*/

    //自定义校验规则
    // $.validator.addMethod("isMobile", function(value, element) {
    //     var length = value.length;
    //     var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
    //     return this.optional(element) || (length == 11 && mobile.test(value));
    // }, "请正确填写您的手机号码");

    /**
     *  功能描述：添加用户验证
     */

    $('#add_user_info_form').validate({
        errorElement:'span',
        errorClass:'error',
        focusInvalid:false,
        ignore:'',
        rules:{
        	username:{
        		required:true
            },
            password:{
                required: true,
                rangelength:[6,18]
            },
            stopTime:{
            	required: true
            }
        },
        messages:{
        	username:{
                required:'请输入账号'
            },
            password:{
                required:'请输入用户密码',
                rangelength:'用户密码不能小于6个字符'
            },
            stopTime:{
                required:'请输入到期时间'
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
 *  功能描述：修改用户
 *  请求方式：POST
 *  请求地址：/api/cuser/add
 *  函数名称：addUserInfo
 */
function editUserInfo(){
	$.ajax({
        url:whole_path+'/api/cuser/add',
        type:'POST',
        dataType:'json',
        data:$('#add_user_info_form').serialize(),
        beforeSend:function(){
            $.progressBar({message:'<p>正在努力加载数据...</p>',modal:true,canCance:true});
        },
        success:function(data){
            if(data.status == 0){
                $.toast('操作成功',1000);
                setTimeout(function(){
                	$('#cancel').click();
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


/**
 *  功能描述：获取详情
 *  请求方式：GET
 *  请求地址：/api/cuser/verify
 *  函数名称：getUserDetail
 *  参数：id:ID
 */

function getUserDetail(){
    var id=getUrlParam("id");
    $.ajax({
        url:whole_path+'/api/cuser/verify',
        type:'GET',
        cache:false,
        dataType:'json',
        data:{
        	cuId:id
        },
        beforeSend:function(){
            $.progressBar({message:'<p>正在努力加载数据...</p>',modal:true,canCance:true});
        },
        success:function(data){
            if(data.status == 0){
                var json = data.data;
                if(json.length>0){
                	json = json[0];
                	$('input[name=id]').val(json.cuId);
                    $('input[name=username]').val(json.username);
                    $('input[name=password]').val(json.password);
                    $('input[name=certName]').val(json.certName);
                    $('input[name=carPhone]').val(json.carPhone);
                    $('input[name=carLength]').val(json.carLength);
                    $('input[name=carWeight]').val(json.carWeight);
                    $('input[name=carNumber1]').val(json.carNumber1);
                    $('input[name=carNumber2]').val(json.carNumber2);
                    $('input[name=carType]').val(json.carType);
                    $('#carStatues option').each(function () {
                        if ($(this).val() == json.carStatues) {
                            $(this).attr('selected', true);
                            $('#carStatues').trigger('change');
                        }
                    });
                   
                }
                
                
            }
        },
        complete:function(){
            $.progressBar().close();
        },
        error:function(XMLHttpRequest,textStatus,errorThrown){
            $.toast('服务器未响应，请稍候重试',5000);
        }
    });
}



//校验用户是否已存在
$("#userName").blur(function(){
    $.ajax({
        url:whole_path+'/api/user_manage/verify',
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

function timeFormat(timestamp) {
  return (new Date(timestamp)).Format('yyyy-MM-dd');
}
