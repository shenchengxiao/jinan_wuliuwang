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
});



/**
 *  功能描述：获取企业专线用户列表
 *  请求方式：GET
 *  请求地址：/api/company_line/list
 *  函数名称：getUserList
 */

function getUserList(){
    $.ajax({
        url: whole_path+'/api/company_line/list',
        type: 'GET',
        dataType: 'json',
        cache:false,
        data: $('#user_list_form').serialize(),
        beforeSend:function(data){
            $.progressBar({message:'<p>正在努力加载数据...</p>',modal:true,canCancel:true});
        },
        success:function(data){
            if(data.status == 0) {
                var json = data.data;
                var list = json.result;
                var temp = "";
                var operation,unbind,modifyTime = '';
                if (list != null && list.length>0){
                    $.each(list, function (index, item) {
                        var user_type = item.userType;
                        switch (user_type){
                            case 1:
                                user_type = '企业版'
                                break;
                            case 2:
                                user_type = '专线版'
                                break;
                        }

                        unbind = ' <a href="#" class="btn-sm btn-warning btn-rounded" data-toggle="modal" data-target="#unbind_id"  onclick="user_unbind('+item.quId+')">解绑</a> ';
                        modifyTime = ' <a href="#" class="btn-sm btn-danger btn-rounded" data-toggle="modal" data-target="#modify_date"  onclick="modify_date('+item.quId+')">修改时间</a>';
                        operation = ' <a href="company_line_edit.jsp?id='+item.quId+'" class="btn-sm btn-info btn-rounded">编辑</a> <a href="company_line_detail.jsp?id='+item.quId+'" class="btn-sm btn-primary btn-rounded">查看</a> '+unbind+modifyTime;

                        temp += '<tr>'
                            + '<td data-title="帐号">' + item.userName + '</td>'
                            + '<td data-title="注册时间">' + item.registerTime + '</td>'
                            + '<td data-title="用户姓名">' + item.customeName + '</td>'
                            + '<td data-title="联系电话">' + item.phoneNumber + '</td>'
                            + '<td data-title="用户类型">' + user_type + '</td>'
                            + '<td data-title="操作">' + operation + '</td>'
                            + '</tr>';
                    })
                    $('#company_line_list tbody').html(temp);
                    page('#pagination', json.pagecount, json.pageindex, json.pagesize, getUserList, '#pageNum');

                }else{
                    $.toast("没有查到数据",3000);
                    $('#company_line_list tbody').html('');
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
 *  功能描述：获取解绑数据列表
 *  请求方式：GET
 *  请求地址：/api/cuser/limitlist
 *  函数名称：user_unbind
 */
function user_unbind(quid) {
    $.ajax({
        url: whole_path+'/api/cuser/limitlist',
        type: 'GET',
        dataType: 'json',
        cache:false,
        data: {quserId:quid},
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

                        if (item.hardware != null && item.hardware != ''){
                            operation = '<a class="btn-sm btn-warning btn-rounded" href="#" onclick="modify_unbind('+item.limitId+');">解绑</a>';
                        }else {
                            operation = '<a class="btn-sm btn-info btn-rounded" >已解绑</a>';
                        }

                        if(item.loginTypeId == 1){
                            loginType = 'iOS';
                        }else{
                            loginType = 'Android';
                        }

                        temp += '<tr class="gradeA">'
                            + '<td data-title="登录类型">' + loginType + '</td>'
                            + '<td data-title="操作">' + operation + '</td>'
                            + '</tr>';
                    })
                    $('#user_limit_unbind_list tbody').html(temp);
                }else{
                    $.toast("暂无解绑的数据",3000);
                    $('#user_limit_unbind_list tbody').html('');
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

function modify_unbind(id){
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
                    window.location.href = 'company_line_list.jsp';
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
function modify_date(id){
    $.ajax({
        url: whole_path+'/api/cuser/limitlist',
        type: 'GET',
        dataType: 'json',
        cache:false,
        data: {quserId:id
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
                    $.each(list, function (index, item) {
                        operation = '<a class="btn-sm btn-danger btn-rounded" href="#" onclick="submit_date('+item.limitId+','+index+');">提交</a>';

                        if(item.loginTypeId == 1){
                            loginType = 'iOS';
                        }else{
                            loginType = 'Android';
                        }

                        temp += '<tr class="gradeA">'
                            + '<td data-title="登录类型">' + loginType + '</td>'
                            + '<td data-title="到期时间"><input id="stopTime'+index+'" name="istopTime" class="laydate-icon form-control layer-date" onclick="laydate()" value="'+timeFormat(item.stopTime)+'"></td>'
                            + '<td data-title="操作">' + operation + '</td>'
                            + '</tr>';
                    })
                    $('#modify_date_list tbody').html(temp);
                }else{
                    $.toast("没有查到数据",3000);
                    $('#modify_date_list tbody').html('');
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


function submit_date(id,index){
    var stopTime = $("#stopTime"+index).val();
    $.ajax({
        url:whole_path+ '/api/cuser/modify_limit',
        type: 'POST',
        dataType: 'json',
        data: {
            'limitId':id,
            'stopTime':stopTime
        },
        beforeSend:function(){
            $.progressBar({message:'<p>正在努力加载数据...</p>',modal:false,canCancel:true});
        },
        success:function(data){
            if(data.status == 0){
                $.toast('操作成功',3000);
                setTimeout(function(){
                    window.location.href = 'company_line_list.jsp';
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

