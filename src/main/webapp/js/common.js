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
        location.href="../login.jsp";
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