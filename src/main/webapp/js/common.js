$(function () {
    $("#login_user_name").html(login_name);

    $("#logout").click(logout); //退出登录
});
var login_name;
/**
 * 初始化对象
 */
(function(){
    //初始化params
    var params = {};
    var q = location.search.substr(1) || '';
    q.split('&').forEach(function(kv){
        var ss = kv.split('=');
        if(ss.length>1) {
            params[ss[0].trim()] = /\d+/.test(ss[1]) ? parseInt(ss[1]) : encodeURI(ss[1]);
        }
    });

    //初始化cookies
    var cookies = {};
    var c = document.cookie || '';
    c.split(';').forEach(function(kv){
        var ss = kv.split('=');
        if(ss.length>1){
            cookies[ss[0].trim()] = ss[1];
        }
    });

    //初始化当前用户信息
    var user = {uid:0,uname:'',isAuthenticated:false};
    if (cookies.USERINFO && cookies.USERINFO.length>0) {
        try {
            var auth = JSON.parse(decodeURIComponent(cookies.USERINFO));
            user.uid = auth.id;
            user.uname = auth.name;
            login_name = auth.name;
            user.isAuthenticated = auth.id > 0 && auth.name.length > 0;
        }catch(e){
            console.log('用户信息解析异常!');
        }
    }
    //未登录,跳转登录页
    if(!user.isAuthenticated && location.href.indexOf('/login.jsp')<0 && location.href.indexOf('/main.jsp')>0){
        location.href="login.jsp";
    } else if (!user.isAuthenticated && location.href.indexOf('/login.jsp')<0){
        location.href="../../login.jsp";
    }
})();

/**
 * 退出登录
 */
function  logout(){
    $.ajax({
        url: whole_path+'/api/web/logout',
        type: 'get',
        dataType: 'json',
        success: function (data) {
            sessionStorage.clear();
            window.location.href =whole_path+ '/login.jsp';
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        }
    });
}

//对Date的扩展，将 Date 转化为指定格式的String
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
//例子：
//(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
//(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
Date.prototype.Format = function (fmt) { //author: meizz
var o = {
   "M+": this.getMonth() + 1,                 //月份
   "d+": this.getDate(),                    //日
   "h+": this.getHours(),                   //小时
   "m+": this.getMinutes(),                 //分
   "s+": this.getSeconds(),                 //秒
   "q+": Math.floor((this.getMonth() + 3) / 3), //季度
   "S": this.getMilliseconds()             //毫秒
};
if (/(y+)/.test(fmt))
   fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
for (var k in o)
   if (new RegExp("(" + k + ")").test(fmt))
       fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
return fmt;
};


/**
* 时间格式
* @param timestamp
* @returns {*}
*/
function timestampFormat(timestamp) {
  return (new Date(timestamp)).Format('yyyy-MM-dd hh:mm:ss');
}


/**
 * 设置分页
 */
function page(pageId, totalPage, pageNo, pageSize, func, pageNum) {
    $(pageNum).val(pageNo);
    if (parseFloat(totalPage) > 1) {
        $(pageId).jqPaginator({
            totalPages: totalPage,
            visiblePages: pageSize,
            currentPage: pageNo,
            first: '<li class="first"><a href="javascript:;">首页</a></li>',
            prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
            next: '<li class="next"><a href="javascript:;">下一页</a></li>',
            page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
            last: '<li class="last"><a href="javascript:;">尾页</a></li>',
            onPageChange: function (num, type) {
                if (type == 'init') {
                    return;
                }
                $(pageNum).val(num);
                func();
            }
        });
    } else {
        if ($(pageId).html().length > 1) {
            $(pageId).jqPaginator("destroy");
        }
    }
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
var whole_path=getRootPath();