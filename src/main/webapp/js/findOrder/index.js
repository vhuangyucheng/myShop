/**
 * Created by Administrator on 2018/2/8.
 */
index(1, '', 0)

function index(pageNum, orderSn, orderState) {
    var beginTime = $('#beginTime').val();
    var endTime = $('#endTime').val();
    // console.log(beginTime,endTime)
    var data = {
        header: {
            token: "1212",
            reqOrg: "1212",
            pageNum: pageNum,
            pageSize: 5
        },
        body: {
            storeId: JSON.parse(sessionStorage.getItem('storeId')),
            orderSn: orderSn,
            orderState: orderState,
            beginTime: beginTime,
            endTime: endTime
        }
    };
    $.ajax({
        url: '/order/findOrder',
        type: 'POST', //GET
        async: true,    //或false,是否异步
        data: JSON.stringify(data),
        timeout: 5000,    //超时时间
        dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
        contentType: 'application/json',
        beforeSend: function (xhr) {
        },
        success: function (data, textStatus, jqXHR) {
            sessionStorage.setItem('orderPages', JSON.stringify(data.pagination.pages))
            sessionStorage.setItem('orderPageNum', JSON.stringify(pageNum))
            var html = template("test", data);
            $(".myContent").html(html);
            $("#total").html(data.pagination.total)
            $("#pageNum1").html(pageNum)
            $("#pages").html(data.pagination.pages)

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

function addGoods() {
    window.location.href = 'addGoods.html'
}

function firstButton() {                                        //首页按钮
    var orderSn = $("#searchName").val()
    index(1, orderSn)//直接给他跳到第一页
}

function preButton() {                                                              //上一页按钮
    var orderSn = $("#searchName").val()
    var orderPageNum = JSON.parse(sessionStorage.getItem('orderPageNum'))     //拿出来我们之前存的当前页(pageNum
    if (orderPageNum - 1 == 0) {                                                 //如果当前页是第一页，就让用户不要翻了
        alert("已经是第一页")
    } else {
        index(orderPageNum - 1, orderSn)                                                 //如果不是第一页，就调用index(pageNum-)表示查询上一个数据
    }
}

function nextButton() {                                                           //下一页按钮
    var orderSn = $("#searchName").val()
    var orderPages = JSON.parse(sessionStorage.getItem('orderPages'))       //拿出来我们存的页数（pages
    var orderPageNum = JSON.parse(sessionStorage.getItem('orderPageNum'))   //拿出来我们存的当前页（pageNum
    if (orderPages == orderPageNum) {                                       //如果 当前页 就是  页数，就让用户不要翻了
        alert("已经是最后一页")
    } else {
        index(orderPageNum + 1, orderSn)                                                //如果不是， 就调用index(pageNum + 1)表示获得下一页的数据
    }
}

function lastButton() {                                                         //最后一页按钮
    var orderSn = $("#searchName").val()
    var orderPages = JSON.parse(sessionStorage.getItem('orderPages'))     //拿出来我们存的页数（pages
    index(orderPages, orderSn)                                                         //直接给他跳到第最后一页
}

template.defaults.imports.timestamp = function (timestamp) {
    var date = new Date(timestamp);
    var y = 1900 + date.getYear();
    var m = "0" + (date.getMonth() + 1);
    var d = "0" + date.getDate();
    return y + "-" + m.substring(m.length - 2, m.length) + "-" + d.substring(d.length - 2, d.length);
};


function search() {
    // console.log(1)
    var orderSn = $("#searchName").val()
    index(1, orderSn, 0)
}

function daiFaHuo() {
    var orderSn = $("#searchName").val()
    index(1, orderSn, 0)
}

function daiFuKuan() {
    var orderSn = $("#searchName").val()
    index(1, orderSn, 1)
}

function yiFaHuo() {
    var orderSn = $("#searchName").val()
    index(1, orderSn, 2)
}

function yiWanCheng() {
    var orderSn = $("#searchName").val()
    index(1, orderSn, 3)
}

function tuiKuan() {
    var orderSn = $("#searchName").val()
    index(1, orderSn, 5)
}

function yiGuanBi() {
    var orderSn = $("#searchName").val()
    index(1, orderSn, 4)
}

function updateOrder(orderId) {
    // alert(orderId)
    var data = {
        header: {
            token: "1212",
            reqOrg: "1212"
        },
        body: {
            orderId:orderId,
            orderState:2
        }
    };
    $.ajax({
        url: '/order/updateOrder',
        type: 'POST', //GET
        async: true,    //或false,是否异步
        data: JSON.stringify(data),
        timeout: 5000,    //超时时间
        dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
        contentType: 'application/json',
        beforeSend: function (xhr) {
        },
        success: function (data, textStatus, jqXHR) {
            alert("操作成功")
            index(1, '', 0)
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