/**
 * Created by Administrator on 2018/3/29.
 */

index()
function index() {

    var data = {
        header: {
            token: "1212",
            reqOrg: "1212"
        },
        body: {
            storeId: JSON.parse(sessionStorage.getItem('storeId'))
        }
    };
    $.ajax({
        url: '/shop/getShopByMac',
        type: 'POST', //GET
        async: true,    //或false,是否异步
        data: JSON.stringify(data),
        timeout: 5000,    //超时时间
        dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
        contentType: 'application/json',
        beforeSend: function (xhr) {
        },
        success: function (data, textStatus, jqXHR) {
            var html = template("test", data.data);
            $(".myContent").html(html);
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

template.defaults.imports.timestamp = function (timestamp) {
    if(timestamp == 0){
        return "正常营业"
    }else{
        return "已经打烊"
    }
};

function openShop(gradeId) {
    var temp;
    if(gradeId==0){
        temp=1
    }else{
        temp=0
    }
    var data = {
        header: {
            token: "1212",
            reqOrg: "1212"
        },
        body: {
            storeId: JSON.parse(sessionStorage.getItem('storeId')),
            gradeId:temp

        }
    };
    $.ajax({
        url: '/shop/openShop',
        type: 'POST', //GET
        async: true,    //或false,是否异步
        data: JSON.stringify(data),
        timeout: 5000,    //超时时间
        dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
        contentType: 'application/json',
        beforeSend: function (xhr) {
        },
        success: function (data, textStatus, jqXHR) {
            window.location.href = 'getShop.html'

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