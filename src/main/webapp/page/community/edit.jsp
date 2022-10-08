<%--
  Created by IntelliJ IDEA.
  User: Nostalgia
  Date: 2022/9/8
  Time: 0:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="../../layui-v2.7.6/layui/layui.js" charset="utf-8"></script>
    <link rel="stylesheet" href="../../layui-v2.7.6/layui/css/layui.css" media="all">
    <style type="text/css">
        #main-body{
            margin-top: 5%;
            padding-left:30% ;
        }
    </style>
</head>
<body>
<div id="main-body"  lay-filter="editForm">
    <form class="layui-form">

        <div class="layui-form-item">
            <label  class="layui-form-label">
                <span class="we-red">*</span>小区编号
            </label>
            <div class="layui-input-inline">
                <input type="text" name="number" id="number"  autocomplete="off" class="layui-input" value="<%= session.getAttribute("number") %>">
            </div>
        </div>

        <div class="layui-form-item">
            <label  class="layui-form-label">
                <span class="we-red">*</span>小区名称
            </label>
            <div class="layui-input-inline">
                <input type="text" name="name" id="name"   autocomplete="off" class="layui-input" value="<%= session.getAttribute("name") %>">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="we-red">*</span>小区地址
            </label>
            <div class="layui-input-inline">
                <input type="text" name="address" id="address" autocomplete="off" class="layui-input" value="<%= session.getAttribute("address") %>">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="we-red">*</span>总栋数
            </label>
            <div class="layui-input-inline">
                <input type="text" name="buildings" id="buildings" autocomplete="off" class="layui-input" value="<%= session.getAttribute("buildings") %>">
            </div>
        </div>
        <div class="layui-form-item">
            <label f class="layui-form-label">
                <span class="we-red">*</span>总户数
            </label>
            <div class="layui-input-inline">
                <input type="text" name="householders" id="householders" autocomplete="off" class="layui-input" value="<%= session.getAttribute("householders") %>">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">选择缩略图</label>
            <div class="layui-input-block">
                <div id="showImg" ><img src="<%= session.getAttribute("thumbnail") %>" width="80px" height="80px"></div>
                <button style="margin-top: 2px" type="button" class="layui-btn"  id="uploadFile" lay-verify="isupload">选择图片</button>
                <input  type="hidden" name="thumbnail" id="thumbnail"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label">
                <span class="we-red">*</span>物业名称
            </label>
            <div class="layui-input-inline">
                <input type="text" name="property" id="property"  autocomplete="off" class="layui-input" value="<%= session.getAttribute("property") %>">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="save" >立即提交</button>
            </div>
        </div>
    </form>
</div>
</body>

<script>
    layui.use([ 'jquery','form'], function() {
        var form = layui.form,
            layer = layui.layer,
            $ = layui.jquery;
        var upload = layui.upload;

        upload.render({
            elem: '#uploadFile' ,//绑定元素
            url: '../file/upload' ,//上传接口
            done: function(res){
                console.log(res.data)
                //上传完毕回调
                if(res.code === 0){
                    // 上传成功的地址可以在服务端写到客户端
                    //可以将上传之后的图片地址放在隐藏域里面，表单提交的时候一起提交到服务端保存图片的地址到数据库
                    $("#thumbnail").val(res.data)
                    layer.alert("上传成功");
                }
            }
            ,error: function(){
                //请求异常回调
            }
        });

        $("body").on("click", "#showImg", function (e) {
            layer.photos({photos: {"data": [{"src": e.target.src}]}});
        });

        form.on('submit(save)',function (data) {
            $.ajax({
                type: "post",
                url: "update",
                async:false,
                data: "number="+data.field.number + "&name="+data.field.name+"&address="+data.field.address + "&buildings="+data.field.buildings+"&householders="+data.field.householders+"&thumbnail="+data.field.thumbnail + "&property="+data.field.property,
                dataType:'json',
                success:function(obj){
                    alert("成功")
                    console.log(obj.code)
                    if(obj.code === 0){//成功
                        //刷新表格
                        window.parent.location.reload();
                    }

                    var iframeIndex = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(iframeIndex);
                },
                error:function () {
                    alert("错误")
                }
            });
        })
    })
</script>
</html>
