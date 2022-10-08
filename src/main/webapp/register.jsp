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
            height: 450px;
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
        <legend>用户注册</legend>
    </fieldset>
    <div class="layui-form-item">
        <label class="layui-form-label">身份证号码</label>
        <div class="layui-input-inline">
            <input  id ="idNumber" type="text" name="idNumber" required lay-verify="required" placeholder="请输入账号"
                    autocomplete="off" class="layui-input">
        </div>
    </div>
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
            <input id="pwd" type="password" name="pwd" required lay-verify="required" placeholder="请输入密码"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">确认密码</label>
        <div class="layui-input-inline">
            <input id="password1" type="password" name="password1" required lay-verify="required" placeholder="请输入密码"
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
                <button id="register" type="button" class="layui-btn">立即注册</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
        <br>
        <a style="margin-left: 100px" href="login.jsp" class="font-set">已有账号立即登录！！！</a>
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
                $("#register").on('click',function () {
                    var idNumber= $("#idNumber").val()
                    var username = $("#username").val()
                    var pwd = $("#pwd").val()
                    console.log(pwd)
                    var password1 = $("#password1").val();
                    if (pwd==password1){
                        $.ajax({
                            type: "post",
                            url: "user/register",
                            data: "idNumber=" + idNumber +"&username=" + username + "&pwd=" + pwd,
                            dataType: 'json',
                            success: function (result) {
                                if (result.code === 0) {
                                    window.location.replace("login.jsp");
                                }
                            },//响应成功后的回调函数
                            error: function () {
                                alert()
                            },
                        })
                    }else {
                        alert("密码前后不一致")
                        window.location
                    }

                })
            }
        })



    })

</script>
</body>
</html>