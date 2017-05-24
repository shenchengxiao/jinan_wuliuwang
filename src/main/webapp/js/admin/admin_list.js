$(function(){
    getAdminList();

    $("#add_admin_id").on('click',function () {
        //清空数据
        $('input[name=userName]').val('');
        $('input[name=passWord]').val('');
        $('#myModal').modal('show');
    });

    $('#btn_add_admin').on('click',function(){
        //非空验证
        var flag = $('#add_admin_form').valid();
        if(flag){
            addAdminInfo();
            $('#myModal').modal('hide');
        }else{
            return false;
        }
    });

    /**
     *  功能描述：添加用户验证
     */

    $('#add_admin_form').validate({
        errorElement:'span',
        errorClass:'error',
        focusInvalid:false,
        ignore:'',
        rules:{
            userName:{
                required:true
            },
            passWord: {
                required: true
            }
        },
        messages:{

            userName:{
                required:'请输入帐号'
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
 *  功能描述：获取用户列表信息
 *  请求方式：GET
 *  请求地址：/api/user_manage/list
 *  函数名称：getUserList
 */

function getAdminList(){
    $.ajax({
        url: whole_path+'/api/web/list',
        type: 'GET',
        dataType: 'json',
        cache:false,
        data: $('#admin_list_form').serialize(),
        beforeSend:function(data){
            $.progressBar({message:'<p>正在努力加载数据...</p>',modal:true,canCancel:true});
        },
        success:function(data){
            if(data.status == 0) {
                var json = data.data;
                var list = json.result;
                var temp = "";
                var operation,modify_status = '';
                if (list != null && list.length>0){
                    $.each(list, function (index, item) {
                        var beUsed = item.beUsed;
                        switch (beUsed){
                            case 0:
                                beUsed = '禁用'
                                break;
                            case 1:
                                beUsed = '启用'
                                break;
                        }
                        if (item.beUsed == 0){
                            modify_status =  ' <a href="#" onclick="modifyBeused('+item.id+',1)" class="btn-sm btn-primary btn-rounded">启用</a>  ';
                        }else {
                            modify_status =  ' <a href="#" onclick="modifyBeused('+item.id+',0)" class="btn-sm btn-default btn-rounded">禁用</a>  ';
                        }
                        operation = ' <a href="company_line_edit.jsp?id='+item.quId+'" class="btn-sm btn-info btn-rounded">编辑</a>  '+ modify_status;

                        temp += '<tr>'
                            + '<td data-title="帐号">' + item.userName + '</td>'
                            + '<td data-title="是否启用">' + beUsed + '</td>'
                            + '<td data-title="创建时间">' + item.createTime + '</td>'
                            + '<td data-title="操作">' + operation + '</td>'
                            + '</tr>';
                    })
                    $('#admin_list tbody').html(temp);
                    $("[data-toggle='modal']").tooltip();
                    page('#pagination', json.pagecount, json.pageindex, json.pagesize, getAdminList, '#pageNum');

                }else{
                    $.toast("没有查到数据",3000);
                    $('#admin_list tbody').html('');
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
 * 添加修改
 */
function addAdminInfo() {
    $.ajax({
        url: whole_path+'/api/web/add',
        type: 'POST',
        dataType: 'json',
        data: $('#add_admin_form').serialize(),
        beforeSend:function(data){
            $.progressBar({message:'<p>正在努力加载数据...</p>',modal:true,canCancel:true});
        },
        success:function(data){
            if(data.status == 0) {
               $.toast("操作成功",1000);
                window.location.reload();
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

function modifyBeused(id,beUsed) {
    $.ajax({
        url: whole_path+'/api/web/modify_status',
        type: 'POST',
        dataType: 'json',
        data: {
            'id':id,
            'beUsed':beUsed
        },
        beforeSend:function(data){
            $.progressBar({message:'<p>正在努力加载数据...</p>',modal:true,canCancel:true});
        },
        success:function(data){
            if(data.status == 0) {
                $.toast("操作成功",1000);
                window.location.reload();
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



