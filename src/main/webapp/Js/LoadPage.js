/**
 * Created by Elric on 2017/6/11.
 */
$(function () {
    //创建XMLHttpRequest对象
    var textRequest = new XMLHttpRequest();
    //请求的方式
    var Gmethod = "GET";
    //请求的地址
    var Texturl = "ajax";
    //初始化请求参数
    textRequest.open(Gmethod, Texturl, true);
    //发送请求
    textRequest.send(null);
    //获取请求的结果
    textRequest.onreadystatechange = function () {
        //如果响应请求
        if (textRequest.readyState == 4) {
            //如果响应成功
            if (textRequest.status == 200 || textRequest.status == 304) {
                var text = textRequest.responseText;
                var d = document.getElementsByTagName("div")[0];
                d.innerHTML = text;
            }
        }
    };
    var param = getParam("yourToken");
    getPic(param);
    function getParam(yourtoken){
        return hex_md5(yourtoken);
    }
    function getPic(tokenStr){
        var picRequest = new XMLHttpRequest();
        var picUrl = "getPic?token="+tokenStr;
        var pMethod = "POST";
        picRequest.open(pMethod,picUrl,true);
        picRequest.send(null);
        picRequest.onreadystatechange = function () {
            if (picRequest.readyState==4){
                if(picRequest.status==200||picRequest.status==302){
                    var picTag = picRequest.responseText;
                    var d2 = document.getElementsByTagName("div")[1];
                    d2.innerHTML = picTag;
                }
            }
        }
    }


});
