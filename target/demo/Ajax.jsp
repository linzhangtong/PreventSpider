<%--
  Created by IntelliJ IDEA.
  User: Elric
  Date: 2017/3/6
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax</title>
    <script>
        //封装并返回Ajax对象
        function getXhr() {
            var xhr = null;
            if(window.XMLHttpRequest){
                //非IE浏览器
                xhr = new XMLHttpRequest();
            }else{
                xhr = new ActiveXObject('Microsoft.XMLHttp');
            }
            return xhr;
        }
        function check_user() {
            //获取Ajax对象
            var xhr =getXhr();
            //获得uname文本中的值
            var uname = document.getElementById("uname").value;
            //发送请求
            xhr.open("get","check_user?uname="+uname,true);
            alert(uname);
            xhr.onreadystatechange = function () {
                //从服务器中成功返回
                if(xhr.readyState==4){
                    if(xhr.status==200){
                        //从服务器返回文本数据
                        var txt = xhr.responseText;
                        //将消息显示在uname文本的右边
                        document.getElementById("uname_msg").innerHTML=txt;
                    }else{
                        document.getElementById("uname_msg").innerHTML="验证出错";
                    }
                }
            };
            xhr.send(null);
        }
    </script>
</head>
<body>
<body>
<form action="" method="post">
    用户名:<input type="text" name="uname" id="uname"/>
    <span id="uname_msg"></span><br/>
    密 码:<input type="password" name="pwd"/><br/>
    <input type="button" value="提交" onclick="check_user()">
</form>
</body>
</body>
</html>
