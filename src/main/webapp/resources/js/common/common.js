/**
 * 更改验证码
 * @param img
 */
function changeVerifyCode(img) {
    img.src = "../Kaptcha?" + Math.floor(Math.random() * 100);
}

/**
 * 从url中获取指定key对应的value值
 * @param key
 * @return {string}
 */
function getQueryString(key){
    var reg = new RegExp("(^|&)" + key + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r != null){
        return decodeURIComponent(r[2]);
    }
    return '';
}