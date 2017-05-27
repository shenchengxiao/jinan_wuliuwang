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

function modifyStatus_stick(userId){
	getUserLimit(userId);
}

/**
 * 解绑列表
 * @param userId
 */
function getUserLimit(userId){
    $.ajax({
        url: whole_path+'/api/cuser/limitlist',
        type: 'GET',
        dataType: 'json',
        cache:false,
        data: {quserId:userId,enabled:1},
        beforeSend:function(data){
            $.progressBar({message:'<p>正在努力加载数据...</p>',modal:true,canCancel:true});
        },
        success:function(data){
            if(data.status == 0) {
                var json = data.data;
                var list = json;
                var temp = "";
                if (list != null && list.length>0){
                    var operation = ''; //操作按钮
                    var loginType = '';
                    $.each(list, function (index, item) {

                        operation = '<a class="btn-sm btn-warning btn-rounded" href="#" onclick="modifyStatus('+item.limitId+');">解绑</a>';

                        if(item.loginTypeId == 1){
                        	loginType = 'IOS';
                        }else{
                        	loginType = 'Android';
                        }
                        
                        temp += '<tr class="gradeA">'
                            + '<td data-title="登录类型">' + loginType + '</td>'
                            + '<td data-title="到期时间">' + timeFormat(item.stopTime) + '</td>'
                            + '<td data-title="操作">' + operation + '</td>'
                            + '</tr>';
                    })
                    $('#limit_list tbody').html(temp);
                    //page('#pagination', json.pagecount, json.pageindex, json.pagesize, getUserList, '#pageNum');

                }else{
                    $.toast("没有查到数据",3000);
                    $('#limit_list tbody').html('');
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
 * 提交修改时间
 * @param id
 * @param index
 */
function updateLimit(id,index){
	var enabled = $("input[name='enabled"+index+"']:checked").val();
	var stopTime = $("#stopTime"+index).val();
	if(enabled == undefined){
		enabled=0;
	}
	$.ajax({
        url:whole_path+ '/api/cuser/modify_limit',
        type: 'POST',
        dataType: 'json',
        data: {
            'limitId':id,
            'enabled':enabled,
            'stopTime':stopTime
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
 * 修改时间列表
 * @param userId
 */
function getUserLimit1(userId){
    $.ajax({
        url: whole_path+'/api/cuser/limitlist',
        type: 'GET',
        dataType: 'json',
        cache:false,
        data: {quserId:userId
        	},
        beforeSend:function(data){
            $.progressBar({message:'<p>正在努力加载数据...</p>',modal:true,canCancel:true});
        },
        success:function(data){
            if(data.status == 0) {
                var json = data.data;
                var list = json;
                var temp = "";
                if (list != null && list.length>0){
                    var operation = ''; //操作按钮
                    var loginType = '';
                    var checked = '';
                    var enabled;
                    var bs;
                    $.each(list, function (index, item) {

                        operation = '<a class="btn-sm btn-danger btn-rounded" href="#" onclick="updateLimit('+item.limitId+','+index+');">提交</a>';

                        if(item.loginTypeId == 1){
                        	if(item.enabled == 1){
                        		enabled = '<input type="radio" name="enabled'+index+'" value="1" checked>是<input type="radio" name="enabled'+index+'" value="0">否';
                        		
                        	}else{
                        		enabled = '<input type="radio" name="enabled'+index+'" value="1">是<input type="radio" name="enabled'+index+'" value="0">否';
                        	}
                        	loginType = 'IOS';
                        }else if(item.loginTypeId == 2){
                        	if(item.enabled == 1){
                        		enabled = '<input type="radio" name="enabled'+index+'" value="1" checked>是<input type="radio" name="enabled'+index+'" value="0">否';
                        	}else{
                        		enabled = '<input type="radio" name="enabled'+index+'" value="1">是<input type="radio" name="enabled'+index+'" value="0">否';
                        	}
                        	loginType = 'Android';
                        }
                        var stopTime = item.stopTime;
                        if(item.stopTime == null){
                        	stopTime = new Date().getTime();
                        }
                        temp += '<tr class="gradeA">'
                            + '<td data-title="登录类型">' + loginType + '</td>'
                            + '<td data-title="允许登录">'+enabled+'</td>'
                            + '<td data-title="到期时间"><input id="stopTime'+index+'" placeholder="请输入IOS到期时间" name="istopTime" class="laydate-icon form-control layer-date" onclick="laydate()" value="'+timeFormat(stopTime)+'"></td>'
                            + '<td data-title="操作">' + operation + '</td>'
                            + '</tr>';
                    })
                    $('#update_time_list tbody').html(temp);
                    //page('#pagination', json.pagecount, json.pageindex, json.pagesize, getUserList, '#pageNum');

                }else{
                    $.toast("没有查到数据",3000);
                    $('#update_time_list tbody').html('');
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
 *  功能描述：获取用户列表信息
 *  请求方式：GET
 *  请求地址：/api/cuser/list
 *  函数名称：getUserList
 */

function getUserList(){
    $.ajax({
        url: whole_path+'/api/cuser/list',
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
                        
                        operation = '<a class="btn-sm btn-primary btn-rounded" href="detail_user.jsp?id='+item.cuId+'">查看</a>&nbsp;&nbsp;&nbsp;'
                        +'<a class="btn-sm btn-info btn-rounded" href="edit_user.jsp?id='+item.cuId+'">编辑</a>&nbsp;&nbsp;&nbsp;'
                        +'<a class="btn-sm btn-warning btn-rounded" data-toggle="modal" data-target="#unbundle" href="#" onclick="modifyStatus_stick('+item.cuId+');">解绑</a>&nbsp;&nbsp;&nbsp;'
                        +'<a class="btn-sm btn-danger btn-rounded" data-toggle="modal" data-target="#updateTime" href="#" onclick="getUserLimit1('+item.cuId+')">修改时间</a>';

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
 *  功能描述：解绑
 *  请求方式：POST
 *  请求地址：/api/cuser/modify_status
 *  函数名称：modifyStatus
 */

function modifyStatus(id){
    $.ajax({
        url:whole_path+ '/api/cuser/modify_status',
        type: 'POST',
        dataType: 'json',
        data: {
            'limitId':id
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
