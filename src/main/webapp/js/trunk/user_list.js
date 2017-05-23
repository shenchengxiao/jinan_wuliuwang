$(function(){
    getUserList();//先执行一次获取列表信息；
    
    $('#btn_search').on('click',function(){
        $("#pageNum").val(1);
        getUserList();//获取列表信息；
    });
    
    $(document).keydown(function(event){
        if(event.keyCode==13){
            $("#btn_search").click();
        }
    });

    //提交修改日期信息
    $('#btn_reset_expireDate').on('click',function(){
        //非空验证
        var flag = $('#reset_expireDate_form').valid();//true false
        if(flag){
            resetUserInfo();
            $('#resetExpireDateModal').modal('hide');//modle层隐藏
        }else{
            return false;
        }
    });


    //解绑
    $('#btn_unbind').on('click',function(){
        //判断是否选中用户且只能选择一个用户
        if(idsArr == null || idsArr.length == 0 ){
            alert("请先选择一个用户");
        }else if (idsArr.length > 1){
            alert("暂不支持批量修改");
        }else {
            for(var i=0;i<idsArr.length;i++) {
                var id = idsArr[i];
                userUnbind(id);
            }
        }
    });

    /**
     * 校验重置密码参数
     */
    $('#reset_password_form').validate({
        errorElement:'span',
        errorClass:'help-inline',
        focusInvalid:false,
        ignore:'',
        rules:{
            password:{
                required: true
            },
            passwordVerify:{
                required: true,
                equalTo: "#reset_password"
            }
        },
        messages:{
            password:{
                required:'请输入新密码'
            },
            passwordVerify:{
                required:'请输入确认密码',
                equalTo: "两次输入密码不一致"
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


    /**
     *  功能描述：验证
     */

    $('#send_usermessagee_form').validate({
        errorElement:'span',
        errorClass:'help-inline',
        focusInvalid:false,
        ignore:'',
        rules:{
            content:{
                required: true
            },
            mType:{
		    	required: true
		    }
        },
        messages:{
        	content:{
                required:'请输入消息内容'
            },
            mType:{
	        	required:'请选择消息类型'
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


//清空modal里面的参数
function clearModal(){
	$('textarea[name=content]').val('');

    $('#myModalLabel').text('发送消息通知');

    //清空修改密码参数
    $('#reset_password').val('');
    $('#reset_passwordVerify').val('');



}

/**
 *  功能描述：获取用户列表信息
 *  请求方式：GET
 *  请求地址：/api/cuser/list
 *  函数名称：getUserList
 */

function getUserList(){
    $.ajax({
        url: manage_path+'/api/cuser/list',
        type: 'GET',
        dataType: 'json',
        cache:false,
        data: $('#cuser_form').serialize(),
        beforeSend:function(data){
            $.progressBar({message:'<p>正在努力加载数据...</p>',modal:true,canCancel:true});
        },
        success:function(data){
            if(data.status == 0) {
                var json = data.data;
                var list = json.result;
                var temp = "";
                if (list != null && list.length>0){
                    var operation, upDown = ''; //操作按钮
                    $.each(list, function (index, item) {

                        var Deleted ='<a href="user_detail.jsp?id='+item.id+'" class="btn mini purple" data-toggle="tooltip" data-placement="top" title="查看" ><i class="icon-tasks"></i></a>&nbsp;'

                        var push ='<a href="user_push.jsp?id='+item.id+'" class="btn yellow mini" data-toggle="tooltip" data-placement="top" title="发布" ><i class="icon-hand-right"></i></a>&nbsp;'

                        var citylist ='<a href="city_list.jsp?id='+item.id+'" class="btn blue mini" data-toggle="tooltip" data-placement="top" title="定制城市" ><i class="icon-globe"></i></a>&nbsp;'
                        
                        operation = '<a href="detail_user.jsp?id='+item.cuId+'">查看</a>&nbsp;&nbsp;&nbsp;'
                        +'<a href="edit_user.jsp?id='+item.cuId+'">编辑</a>&nbsp;&nbsp;&nbsp;'
                        +'<a href="user_edit.jsp?id='+item.cuId+'">解绑</a>&nbsp;&nbsp;&nbsp;'
                        +'<a href="user_edit.jsp?id='+item.cuId+'">修改使用时间</a>';

                        temp += '<tr class="gradeA">'
                            + '<td data-title="账号">' + item.username + '</td>'
                            + '<td data-title="注册时间">' + timestampFormat(item.registerTime) + '</td>'
                            + '<td data-title="姓名">' + item.certName + '</td>'
                            + '<td data-title="电话">' + item.carPhone + '</td>'
                            + '<td data-title="开户人">' + item.adminName + '</td>'
                            + '<td data-title="操作">' + operation + '</td>'
                            + '</tr>';
                    })
                    $('#cuser_list tbody').html(temp);
                    $("[data-toggle='popover']").popover();
                    //操作按钮hover显示详情
                    $("[data-toggle='tooltip']").tooltip();
                    $("[data-toggle='modal']").tooltip();
                    // 数据分页  #pageNum 为页面隐藏 <input type="hidden" name="pageNum" id="pageNum" value="1"  >
                    // 当没有条件查询时，必须也要加默认的第一页#pageNum  value = 1
                    page('#pagination', json.pagecount, json.pageindex, json.pagesize, getUserList, '#pageNum');

                }else{
                    $.toast("没有查到数据",3000);
                    $('#cuser_list tbody').html('');
                    if($('#pagination').html().length > 0){
                        $('#pagination').jqPaginator('destroy');
                    }
                }
            }
        },
        complete:function(){
            $.progressBar().close();
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
            $.toast('服务器未响应,请稍候重试',5000);
        }
    })
}




/**
 *  功能描述：启用、禁用
 *  请求方式：POST
 *  请求地址：/api/user_manage/modify_status
 *  函数名称：modifyStatus
 *  参数：id:banner主键ID; beUsed:启用禁用;
 */

function modifyStatus(id,beUsed){
    $.ajax({
        url:manage_path+ '/api/user_manage/modify_status',
        type: 'POST',
        dataType: 'json',
        data: {
            'id':id,
            'status':beUsed
        },
        beforeSend:function(){
            $.progressBar({message:'<p>正在努力加载数据...</p>',modal:false,canCancel:true});
        },
        success:function(data){
            if(data.status == 0){
                $.toast('操作成功',3000);
                setTimeout(function(){
                    window.location.href = 'user_list.jsp';
                },500)
            }else{
                $.toast(data.msg,3000);
            }

        },
        complete:function(){
            $.progressBar().close();
        },
        error:function(XMLHttpRequest,textStatus,errorThrown){
            $.toast('服务器未响应,请稍候重试',5000);
        }
    })

}



/**
 *  功能描述：获取用户密码信息
 *  请求方式：GET
 *  请求地址：/api/user_manage/detail
 *  函数名称：getUserDetail
 *  参数：id:ID
 */

function getUserDetail(id){
    $.ajax({
        url:manage_path+'/api/user_manage/detail',
        type:'GET',
        cache:false,
        dataType:'json',
        data:{
            id:id
        },
        beforeSend:function(){
            $.progressBar({message:'<p>正在努力加载数据...</p>',modal:true,canCance:true});
        },
        success:function(data){
            if(data.status == 0){
                var json = data.data;

                $('#reset_id').val(json.id);
                $('#reset_userName').val(json.userName);

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



/**
 *  功能描述：获取用户到期时间信息
 *  请求方式：GET
 *  请求地址：/api/user_manage/detail
 *  函数名称：getExpireDate
 *  参数：id:ID
 */

function getExpireDate(id){
    $.ajax({
        url:manage_path+'/api/user_manage/detail',
        type:'GET',
        cache:false,
        dataType:'json',
        data:{
            id:id
        },
        beforeSend:function(){
            $.progressBar({message:'<p>正在努力加载数据...</p>',modal:true,canCance:true});
        },
        success:function(data){
            if(data.status == 0){
                var json = data.data;

                $('#resetExpireDate_id').val(json.id);
                $('#reset_expireDate').val(json.userName);
                $('input[name=startTime]').val(timestampFormat(json.startTime));
                $('input[name=endTime]').val(timestampFormat(json.endTime));

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


/**
 *  功能描述：重置用户信息
 *  请求方式：POST
 *  请求地址：/api/user_manage/reset
 *  函数名称：resetUserInfo
 */
function resetUserInfo() {
    var passVal = $('#reset_password').val();
    var data;
    if (passVal != null && passVal != ""){
        data = $('#reset_password_form').serialize();
    }else {
        data = $('#reset_expireDate_form').serialize()
    }

    $.ajax({
        url:manage_path+'/api/user_manage/reset',
        type:'POST',
        dataType:'json',
        data: data,
        beforeSend:function(){
            $.progressBar({message:'<p>正在努力加载数据...</p>',modal:true,canCance:true});
        },
        success:function(data){
            if(data.status == 0){
                $.toast('操作成功',1000);
                setTimeout(function(){
                    window.location.href = 'user_list.jsp';
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
 *  功能描述：用户设备解绑
 *  请求方式：POST
 *  请求地址：/api/user_manage/reset
 *  函数名称：resetUserInfo
 */
function userUnbind(id) {
    $.ajax({
        url:manage_path+'/api/binding/unbind',
        type:'POST',
        dataType:'json',
        data: {userId:id},
        beforeSend:function(){
            $.progressBar({message:'<p>正在努力加载数据...</p>',modal:true,canCance:true});
        },
        success:function(data){
            if(data.status == 0){
                $.toast('操作成功',1000);
                setTimeout(function(){
                    window.location.href = 'user_list.jsp';
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

//获取项目路径
function getRootPath()
{
    var pathName = window.location.pathname.substring(1);

    var webName = pathName == '' ? '' : pathName.substring(0,pathName.indexOf('/'));

    var path = window.location.protocol + '//' + window.location.host + '/'+ webName ;

    return path;

}
//定义路径全局变量
var manage_path=getRootPath();
