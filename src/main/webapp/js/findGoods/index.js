/**
 * Created by Administrator on 2018/2/8.
 */
index(1, '', null, null)

function index(pageNum, goodsName, goodsState,paiXu) {
    var goodsTime
    var goodsSale
    if(paiXu == 'goodsTime'){
        goodsTime= 1
    }
    if(paiXu == 'goodsSale'){
        goodsSale=1
    }
    var data = {
        header: {
            token: "1212",
            reqOrg: "1212",
            pageNum: pageNum,
            pageSize: 5
        },
        body: {
            storeId: JSON.parse(sessionStorage.getItem('storeId')),
            goodsName: goodsName,
            goodsState: goodsState,
            goodsTime:goodsTime,
            goodsSale:goodsSale

        }
    };
    $.ajax({
        url: '/goods/findGoods',
        type: 'POST', //GET
        async: true,    //或false,是否异步
        data: JSON.stringify(data),
        timeout: 5000,    //超时时间
        dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
        contentType: 'application/json',
        beforeSend: function (xhr) {
        },
        success: function (data, textStatus, jqXHR) {
            sessionStorage.setItem('goodsPages', JSON.stringify(data.pagination.pages))
            sessionStorage.setItem('goodsPageNum', JSON.stringify(pageNum))
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

function deleteGoods(goodsId) {
    alert("1")
    var data = {
        header: {
            token: "1212",
            reqOrg: "1212"
        },
        body: {
            goodsId: goodsId
        }
    };
    $.ajax({
        url: '/goods/deleteGoods',
        type: 'POST', //GET
        async: true,    //或false,是否异步
        data: JSON.stringify(data),
        timeout: 5000,    //超时时间
        dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
        contentType: 'application/json',
        beforeSend: function (xhr) {
        },
        success: function (data, textStatus, jqXHR) {
            alert('删除成功')
            index(1)
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

function firstButton() {                                        //首页按钮
    var goodsName = $("#searchName").val()
    var goodsState = JSON.parse(sessionStorage.getItem('goodsState'))
    var paiXu = JSON.parse(sessionStorage.getItem('paiXu')) //拿
    index(1, goodsName,goodsState,paiXu)//直接给他跳到第一页
}

function preButton() {                                                              //上一页按钮
    var goodsName = $("#searchName").val()
    var goodsPageNum = JSON.parse(sessionStorage.getItem('goodsPageNum'))
    var goodsState = JSON.parse(sessionStorage.getItem('goodsState'))
    var paiXu = JSON.parse(sessionStorage.getItem('paiXu'))//拿出来我们之前存的当前页(pageNum
    if (goodsPageNum - 1 == 0) {                                                 //如果当前页是第一页，就让用户不要翻了
        alert("已经是第一页")
    } else {
        index(goodsPageNum - 1, goodsName,goodsState,paiXu)                                                 //如果不是第一页，就调用index(pageNum-)表示查询上一个数据
    }
}

function nextButton() {                                                           //下一页按钮
    var goodsName = $("#searchName").val()
    var goodsPages = JSON.parse(sessionStorage.getItem('goodsPages'))       //拿出来我们存的页数（pages
    var goodsPageNum = JSON.parse(sessionStorage.getItem('goodsPageNum'))
    var goodsState = JSON.parse(sessionStorage.getItem('goodsState'))
    var paiXu = JSON.parse(sessionStorage.getItem('paiXu'))//拿出来我们存的当前页（pageNum
    if (goodsPages == goodsPageNum) {                                       //如果 当前页 就是  页数，就让用户不要翻了
        alert("已经是最后一页")
    } else {
        index(goodsPageNum + 1, goodsName,goodsState,paiXu)                                                //如果不是， 就调用index(pageNum + 1)表示获得下一页的数据
    }
}

function lastButton() {                                                         //最后一页按钮
    var goodsName = $("#searchName").val()
    var goodsPages = JSON.parse(sessionStorage.getItem('goodsPages'))
    var goodsState = JSON.parse(sessionStorage.getItem('goodsState'))
    var paiXu = JSON.parse(sessionStorage.getItem('paiXu'))//拿出来我们存的页数（pages
    index(goodsPages, goodsName,goodsState,paiXu)                                                         //直接给他跳到第最后一页
}

template.defaults.imports.timestamp = function (timestamp) {
    var date = new Date(timestamp);
    var y = 1900 + date.getYear();
    var m = "0" + (date.getMonth() + 1);
    var d = "0" + date.getDate();
    return y + "-" + m.substring(m.length - 2, m.length) + "-" + d.substring(d.length - 2, d.length);
};

function updateGoods(goodsId) {
    sessionStorage.setItem("goodsId", JSON.stringify(goodsId))
    window.location.href = 'updateGoods.html'
}

function foo2(a, b) {
    console.log(a, b);
}

function search() {
    // console.log(1)
    var goodsName = $("#searchName").val()
    var paiXu = JSON.parse(sessionStorage.getItem('paiXu'))
    var goodsState = JSON.parse(sessionStorage.getItem('goodsState'))
    index(1, goodsName, goodsState,paiXu)
}

function quanBu() {
    var goodsName = $("#searchName").val()
    var paiXu = JSON.parse(sessionStorage.getItem('paiXu'))
    index(1, goodsName, null, paiXu)
}
function chuShouZhong() {
    var goodsName = $("#searchName").val()
    sessionStorage.setItem('goodsState', JSON.stringify(0))
    var paiXu = JSON.parse(sessionStorage.getItem('paiXu'))
    index(1, goodsName, 0, paiXu)
}
function yiShouWan() {
    var goodsName = $("#searchName").val()
    sessionStorage.setItem('goodsState', JSON.stringify(1))
    var paiXu = JSON.parse(sessionStorage.getItem('paiXu'))
    index(1, goodsName, 1,paiXu)
}
function yiXiaJia() {
    var goodsName = $("#searchName").val()
    sessionStorage.setItem('goodsState', JSON.stringify(2))
    var paiXu = JSON.parse(sessionStorage.getItem('paiXu'))
    index(1, goodsName, 2,paiXu)
}

function shangJia(goodsId) {
    var data = {
        header: {
            token: "1212",
            reqOrg: "1212"
        },
        body: {
            goodsState:0,
            goodsId:goodsId
        }
    };
    $.ajax({
        url: '/goods/updateGoods',
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
            index(1, '', null)
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

function xiaJia(goodsId) {
    var data = {
        header: {
            token: "1212",
            reqOrg: "1212"
        },
        body: {
            goodsState:2,
            goodsId:goodsId
        }
    };
    $.ajax({
        url: '/goods/updateGoods',
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
            index(1, '', null)
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
//增加库存方法一：先获得商品id
function zengJiaKuCun1(goodsId) {
    sessionStorage.setItem("goodsId", JSON.stringify(goodsId))
}
//增加库存方法二：提交数据库
function zengJiaKuCun2() {
    var goodsStorage = $("#kuCunNum").val()
    // console.log(goodsStorage)
    var goodsId = JSON.parse(sessionStorage.getItem('goodsId'))
    var data = {
        header: {
            token: "1212",
            reqOrg: "1212"
        },
        body: {
            goodsState:0,
            goodsId:goodsId,
            goodsStorage:goodsStorage
        }
    };
    $.ajax({
        url: '/goods/updateGoods',
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
            index(1, '', null)
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

//安装创建时间排序
function createTime() {
    sessionStorage.setItem('paiXu', JSON.stringify("goodsTime"))
    var goodsName = $("#searchName").val()
    var goodsState = JSON.parse(sessionStorage.getItem('goodsState'))
    index(1, goodsName, goodsState, 'goodsTime')
}

//安装创建销量排序
function sale() {
    sessionStorage.setItem('paiXu', JSON.stringify("goodsSale"))
    var goodsName = $("#searchName").val()
    var goodsState = JSON.parse(sessionStorage.getItem('goodsState'))
    index(1, goodsName, goodsState, 'goodsSale')
}