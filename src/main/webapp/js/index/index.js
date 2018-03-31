/**
 * Created by Administrator on 2018/2/9.
 */
check();
function check(){
    var a = JSON.parse(sessionStorage.getItem('storeId'))
    if( a == null){
        window.location.href = 'login.html'
    }
}

function outlog(){
    sessionStorage.removeItem('storeId')

}