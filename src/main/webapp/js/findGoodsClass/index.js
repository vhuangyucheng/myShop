/**
 * Created by Administrator on 2018/2/8.
 */
index(1)

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
        url: '/goodsClass/findGoodsClass',
        type: 'POST', //GET
        async: true,    //或false,是否异步
        data: JSON.stringify(data),
        timeout: 5000,    //超时时间
        dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
        contentType: 'application/json',
        beforeSend: function (xhr) {
        },
        success: function (data, textStatus, jqXHR) {
            var html = template("test", data);
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

function findGoodsByClass(goodsClassId) {
    sessionStorage.setItem("goodsClassId", JSON.stringify(goodsClassId))
    window.location.href = 'findGoodsByClass.html'
}

