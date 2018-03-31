/**
 * Created by Administrator on 2018/2/9.
 */

function index(){
    var username = $('#username').val();
    var password = $('#password').val();
    if(username == '' || password == '' ){
        alert('有信息尚未填写好')
        return;
    }
    console.log(username, password);
    var data = {
        header:{
            token:"1212",
            reqOrg:"1212"
        },
        body :{
            storeUsername : username,
            storePassword : password
        }
    }
    $.ajax({
        url: '/shop/checkShop',
        type: 'POST', //GET
        async: true,    //或false,是否异步
        data: JSON.stringify(data),
        timeout: 5000,    //超时时间
        dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
        contentType: 'application/json',
        beforeSend: function (xhr) {
        },
        success: function (data, textStatus, jqXHR) {
            if(data.code ==1){
                alert("账号密码错误")
                return;
            }
            sessionStorage.setItem('storeId', JSON.stringify(data.data.storeId))
            window.location.href = 'index.html'
        },
        error: function (xhr, textStatus) {
            console.log('错误')
            console.log(xhr)
            console.log(textStatus)
        },
        complete: function () {
        }
    })
}