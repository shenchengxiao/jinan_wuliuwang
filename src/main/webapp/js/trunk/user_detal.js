
$(function(){

    getUserDetail();
    
    $('#cancel').on('click',function(){
        location.href = whole_path+"/view/trunk/user_list.jsp";

      });

});


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
                    $('span[name=username]').html(json.username);
                    $('span[name=password]').html(json.password);
                    $('span[name=certName]').html(json.certName);
                    $('span[name=carPhone]').html(json.carPhone);
                    $('span[name=carLength]').html(json.carLength);
                    $('span[name=carWeight]').html(json.carWeight);
                    $('span[name=carNumber1]').html(json.carNumber1);
                    $('span[name=carNumber2]').html(json.carNumber2);
                    $('span[name=carType]').html(json.carType);
                    if(json.carStatues == 0){
                    	$('span[name=carStatues]').html("空车");
                    }else if(json.carStatues == 1){
                    	$('span[name=carStatues]').html("满载");
                    }
                   
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
