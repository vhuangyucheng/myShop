index()
function updateGoods() {
    var goodsName = $('#goodsName').val();
    var goodsPrice = $('#goodsPrice').val();
    var gcId = $("input[name='gcId']:checked").val();
    var goodsStorage = $('#goodsStorage').val();
    var goodsState = $("input[name='goodsState']:checked").val()
    var goodsJingle = $('#goodsJingle').val();
    // console.log(goodsName,goodsPrice,gcId,goodsStorage,goodsState,goodsJingle)
    // if (goodsName == '' || goodsPrice == '' || gcId == '' || goodsStorage == '' || goodsState == '' ||
    //     goodsJingle == '') {
    //     alert('有信息尚未填写好')
    //     return;
    // }
    var data = {
        header: {
            token: "1212",
            reqOrg: "1212"
        },
        body: {
            goodsId: JSON.parse(sessionStorage.getItem('goodsId')),
            goodsName: goodsName,
            goodsPrice: goodsPrice,
            gcId: gcId,
            goodsStorage: goodsStorage,
            goodsState: goodsState,
            goodsJingle: goodsJingle,
        }
    };
    // console.log(JSON.parse(sessionStorage.getItem('goodsId')))
    $.ajax({
        url: '/goods/updateGoods ',
        type: 'POST', //GET
        async: true,    //或false,是否异步
        data: JSON.stringify(data),
        timeout: 5000,    //超时时间
        dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
        contentType: 'application/json',
        beforeSend: function (xhr) {
        },
        success: function (data, textStatus, jqXHR) {
            alert('提交成功')
            window.location.href = 'findGoods.html'
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
        url: '/goodsClass/findGoodsClass ',
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
            index2()
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
function back() {
    window.location.href = 'findGoods.html'
}

function index2() {
    var data2 = {
        header: {
            token: "1212",
            reqOrg: "1212"
        },
        body: {
            goodsId: JSON.parse(sessionStorage.getItem('goodsId'))
        }
    };
    $.ajax({
        url: '/goods/getGoods ',
        type: 'POST', //GET
        async: true,    //或false,是否异步
        data: JSON.stringify(data2),
        timeout: 5000,    //超时时间
        dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
        contentType: 'application/json',
        beforeSend: function (xhr) {
        },
        success: function (data, textStatus, jqXHR) {
            var html = template("test2", data.data);
            $(".myContent2").html(html);
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
    if (timestamp == 0) {
        return "出售中"
    } else if (timestamp == 1) {
        return "已售完"
    }
    else {
        return "以下架"
    }
};