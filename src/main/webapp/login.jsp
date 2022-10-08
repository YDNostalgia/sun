<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登录界面</title>

    <link rel="stylesheet" href="layui-v2.7.6/layui/css/layui.css" media="all">

    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>

    <style type="text/css">
        .layui-layout-login {
            width: 350px;
            height: 300px;
            margin: 10% auto 0 auto;
            box-shadow: 2px 1px 10px 10px #eeeeee;
            border-radius: 8px;
            z-index: 10;
        }
    </style>
</head>
<body background="images/sun.png">
<div class="text" style="font-size:50px;font-weight:bold;margin-top:55px;height:10px;text-align:center;">阳光智慧社区</div>
<form class="layui-form layui-layout layui-layout-login" >
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>用户登录</legend>
    </fieldset>
    <div class="layui-form-item">
        <label class="layui-form-label">账号</label>
        <div class="layui-input-inline">
            <input  id ="username" type="text" name="username" required lay-verify="required" placeholder="请输入账号"
                    autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input id="password" type="password" name="password" required lay-verify="required" placeholder="请输入密码"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">滑动验证</label>
        <div class="layui-input-inline">
            <div id="slider"></div>
        </div>
    </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <div class="layui-btn-group">
                <button id="login" type="button" class="layui-btn">立即登录</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
        <br>
        <a style="margin-left: 130px" href="register.jsp" class="font-set" >立即注册</a>
    </div>
</form>
<script src="layui-v2.7.6/layui/layui.js" charset="utf-8"></script>
<script>
    layui.config({
        base: 'dist/sliderVerify/'　
    }).use(['sliderVerify', 'jquery','form'], function() {
        // var form = layui.form
        var $ = layui.jquery
        var sliderVerify = layui.sliderVerify
        var slider = sliderVerify.render({
            elem: '#slider',

            onOk: function(){//当验证通过回调
                layer.msg("滑块验证通过");
                $("#login").on('click',function () {
                    var username = $("#username").val()
                    var password = $("#password").val();
                    $.ajax({
                        type: "post",
                        url: "user/login",
                        data: "username="+username + "&pwd="+password,
                        dataType:'json',
                        success: function (result) {
                            console.log(result)
                            if (result.code === 0) {
                                alert(result.msg);
                                window.location.replace("index.html");}
                            else
                            { alert("用户名或密码错误或该用户被暂停使用");
                                window.location.replace("login.jsp");
                            }
                        },//响应成功后的回调函数
                        error: function () {
                            alert()
                        },//表示如果请求响应出现错误，会执行的回调函数
                    });
                })
            }
        })



    })

</script>
</body>
</html>