
$(function(){

    getUserDetail();

    $('#cancel').on('click',function(){
        location.href = whole_path+"/view/trunk/user_list.jsp";

    });

});


/**
 *  功能描述：获取详情
 *  请求方式：GET
 *  请求地址：/api/company_line/detail
 *  函数名称：getUserDetail
 *  参数：id:ID
 */

function getUserDetail(){
    var id=getUrlParam("id");
    $.ajax({
        url:whole_path+'/api/company_line/detail',
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
                $('span[name=username]').html(json.username);
                $('span[name=password]').html(json.password);
                $('span[name=phone]').html(json.phone);
                $('span[name=registerTime]').html(timeFormat(json.registerTime));
                $('span[name=certName]').html(json.certName);
                $('span[name=certNumber]').html(json.certNumber);
                $('span[name=certAddress]').html(json.certAddress);
                $('span[name=compName]').html(json.compName);
                $('span[name=compAddress]').html(json.compAddress);
                $('span[name=compPhone]').html(json.compPhone);
                $('span[name=zlineCity]').html(json.zlineCity);

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


