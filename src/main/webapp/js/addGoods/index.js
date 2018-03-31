index()
function addGoods(){
    var goodsName = $('#goodsName').val();
    var goodsPrice = $('#goodsPrice').val();
    var gcId = $("input[name='gcId']:checked").val();
    var goodsStorage = $('#goodsStorage').val();
    var goodsState = $("input[name='goodsState']:checked").val()
    var goodsJingle = $('#goodsJingle').val();
    // console.log(goodsName,goodsPrice,gcId,goodsStorage,goodsState,goodsJingle)
    if(goodsName == '' || goodsPrice == '' || gcId == '' || goodsStorage == '' || goodsState == '' ||
        goodsJingle == '' ){
        alert('有信息尚未填写好')
        return ;
    }
    var data = {
        header:{
            token:"1212",
            reqOrg:"1212"
        },
        body:{
            goodsName : goodsName,
            goodsPrice : goodsPrice,
            gcId : gcId,
            goodsStorage : goodsStorage,
            goodsState : goodsState,
            goodsJingle : goodsJingle,
            storeId:JSON.parse(sessionStorage.getItem('storeId'))
        }
    };
    $.ajax({
        url: '/goods/addGoods ',
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
        header:{
            token:"1212",
            reqOrg:"1212"
        },
        body:{
            storeId:JSON.parse(sessionStorage.getItem('storeId'))
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
function back(){
    window.location.href = 'findGoods.html'
}