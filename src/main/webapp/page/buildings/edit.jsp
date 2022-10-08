<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
<%--    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>--%>
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
<div id="main-body">
    <form class="layui-form">

        <input type="hidden" name="id" id="id"  autocomplete="off" class="layui-input">
        <div class="layui-form-item">
            <label  class="layui-form-label">
                <span class="we-red">*</span>所属小区
            </label>
            <div class="layui-input-inline">
                <select name="communityName" lay-filter="communityName" id="communityName" lay-search="">
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label  class="layui-form-label">
                <span class="we-red">*</span>楼栋名称
            </label>
            <div class="layui-input-inline">
                <input type="text" name="buildingName" id="buildingName"  autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="we-red">*</span>小区编码
            </label>
            <div class="layui-input-inline">
                <input type="text" readonly="readonly" name="communityNumber" id="communityNumber" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="we-red">*</span>总户数
            </label>
            <div class="layui-input-inline">
                <input type="text" name="households" id="households" autocomplete="off" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <label  class="layui-form-label">
                <span class="we-red">*</span>描述
            </label>
            <div class="layui-input-inline">
                <input  type="text" name="depict" id="depict" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="save" >立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary" id="closeBtn" >重置</button>
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

        $.ajax({
            type:'post',
            url:'../communityInformation/list',
            dataType:'json',
            success:function(data){
                //遍历
                var OptionStr = "";
                $.each(data,function(index,item){
                    OptionStr += "<option value='"+item.name+"'>"+item.name+"</option>"
                })

                $("#communityName").html(OptionStr);


                // form.render('select');//渲染整个表单 只是渲染表单中的某个组件，我们这里渲染select
                $("#id").val("${buildings.id}");
                $("#communityName").val("${buildings.communityName}");
                $("#communityNumber").val("${buildings.communityNumber}");
                $("#buildingName").val("${buildings.buildingName}");
                $("#households").val("${buildings.households}");
                $("#depict").val("${buildings.depict}");

                form.render();
            }
        })


        form.on('select',function () {
            var name=$("#communityName").val()
            $.ajax({
                type:'post',
                url:'../communityNumber/list',
                data:"name="+name,
                dataType:'json',
                success:function(data){
                    $("#communityNumber").val(data.number);

                }
            })

        })


        form.on('submit(save)',function (data) {
            $.ajax({
                type: "post",
                url: "update",
                async:false,
                data: "id="+data.field.id+"&communityName="+data.field.communityName + "&communityNumber="+data.field.communityNumber+"&buildingName="+data.field.buildingName + "&households="+data.field.households+"&depict="+data.field.depict,
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
