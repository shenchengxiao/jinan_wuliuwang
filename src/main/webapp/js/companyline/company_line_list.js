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
 *  功能描述：获取用户列表信息
 *  请求方式：GET
 *  请求地址：/api/user_manage/list
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
                        unbind = ' <a href="#" class="btn-sm btn-warning btn-rounded"  onclick="modifyStatus_stick('+item.id+','+item.adType+',1)">解绑</a> ';
                        modifyTime = ' <a href="#" class="btn-sm btn-danger btn-rounded"  onclick="modifyStatus_stick('+item.id+','+item.adType+',1)">修改时间</a> ';
                        operation = ' <a href="#" class="btn-sm btn-info btn-rounded"  onclick="modifyStatus_stick('+item.id+','+item.adType+',1)">编辑</a> <a href="javascript:;" id="btn_edit" class="btn-sm btn-primary btn-rounded" data-toggle="tooltip" data-placement="top" title="编辑" onclick="editBanner('+item.id+','+item.adType+')">查看</a> '+ unbind+modifyTime;

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



