/**
 * Created by Administrator on 2018/3/29.
 */
function index() {

}

function updatePassword() {
    var password1 = $("#password1").val()
    var password2 = $("#password2").val()
    var password3 = $("#password3").val()
    // console.log(password1,password2,password3)
    if(password1 == '' || password2 == '' || password3 == '' ){
        alert('有信息尚未填写好')
        return ;
    }
    if(password2 != password3){
        alert('新密码两次输入不正确')
        return ;
    }
    var data = {
        header: {
            token: "1212",
            reqOrg: "1212"
        },
        body: {
            storeId: JSON.parse(sessionStorage.getItem('storeId')),
            storePassword:password1,
            newPassword:password2
        }
    };
    $.ajax({
        url: '/shop/updatePassword',
        type: 'POST', //GET
        async: true,    //或false,是否异步
        data: JSON.stringify(data),
        timeout: 5000,    //超时时间
        dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
        contentType: 'application/json',
        beforeSend: function (xhr) {
        },
        success: function (data, textStatus, jqXHR) {
            if(data.code=='0'){
                alert('成功')
            }else{
                alert('密码错误')
            }
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