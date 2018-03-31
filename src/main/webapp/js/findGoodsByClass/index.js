/**
 * Created by Administrator on 2018/2/8.
 */
index(1, '', null)

function index(pageNum, goodsName, goodsState) {

    var data = {
        header: {
            token: "1212",
            reqOrg: "1212",
            pageNum: pageNum,
            pageSize: 5
        },
        body: {
            storeId: JSON.parse(sessionStorage.getItem('storeId')),
            gcId:JSON.parse(sessionStorage.getItem('goodsClassId'))
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


function firstButton() {                                        //首页按钮
    var goodsName = $("#searchName").val()
    var goodsState = JSON.parse(sessionStorage.getItem('goodsState'))     //拿
    index(1, goodsName,goodsState)//直接给他跳到第一页
}

function preButton() {                                                              //上一页按钮
    var goodsName = $("#searchName").val()
    var goodsPageNum = JSON.parse(sessionStorage.getItem('goodsPageNum'))
    var goodsState = JSON.parse(sessionStorage.getItem('goodsState'))  //拿出来我们之前存的当前页(pageNum
    if (goodsPageNum - 1 == 0) {                                                 //如果当前页是第一页，就让用户不要翻了
        alert("已经是第一页")
    } else {
        index(goodsPageNum - 1, goodsName,goodsState)                                                 //如果不是第一页，就调用index(pageNum-)表示查询上一个数据
    }
}

function nextButton() {                                                           //下一页按钮
    var goodsName = $("#searchName").val()
    var goodsPages = JSON.parse(sessionStorage.getItem('goodsPages'))       //拿出来我们存的页数（pages
    var goodsPageNum = JSON.parse(sessionStorage.getItem('goodsPageNum'))
    var goodsState = JSON.parse(sessionStorage.getItem('goodsState'))//拿出来我们存的当前页（pageNum
    if (goodsPages == goodsPageNum) {                                       //如果 当前页 就是  页数，就让用户不要翻了
        alert("已经是最后一页")
    } else {
        index(goodsPageNum + 1, goodsName,goodsState)                                                //如果不是， 就调用index(pageNum + 1)表示获得下一页的数据
    }
}

function lastButton() {                                                         //最后一页按钮
    var goodsName = $("#searchName").val()
    var goodsPages = JSON.parse(sessionStorage.getItem('goodsPages'))
    var goodsState = JSON.parse(sessionStorage.getItem('goodsState'))//拿出来我们存的页数（pages
    index(goodsPages, goodsName,goodsState)                                                         //直接给他跳到第最后一页
}

template.defaults.imports.timestamp = function (timestamp) {
    var date = new Date(timestamp);
    var y = 1900 + date.getYear();
    var m = "0" + (date.getMonth() + 1);
    var d = "0" + date.getDate();
    return y + "-" + m.substring(m.length - 2, m.length) + "-" + d.substring(d.length - 2, d.length);
};

function back() {
    window.location.href = 'findGoodsClass.html'
}


