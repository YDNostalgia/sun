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
            <label class="layui-form-label">
                <span class="we-red">*</span>房产名称
            </label>
            <div class="layui-input-inline">
                <input type="text" name="realState" id="realState" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="we-red">*</span>户主名称
            </label>
            <div class="layui-input-inline">
                <input type="text" name="memberName" id="memberName" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">户主照片</label>
            <div class="layui-input-block">
                <div id="showImg" ><img src="${personnel.photo}" width="80px" height="80px"></div>
                <button type="button" class="layui-btn"  id="uploadFile" lay-verify="isupload">选择文件</button>
                <input  type="hidden" name="photo" id="photo"  autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label  class="layui-form-label">
                <span class="we-red">*</span>身份证号
            </label>
            <div class="layui-input-inline">
                <input  type="text" name="idCard" id="idCard" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label  class="layui-form-label">
                <span class="we-red">*</span>联系方式
            </label>
            <div class="layui-input-inline">
                <input type="text" name="contact" id="contact" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label  class="layui-form-label">
                <span class="we-red">*</span>工作
            </label>
            <div class="layui-input-inline">
                <input  type="text" name="work" id="work" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label">
                <span class="we-red">*</span>出生日期
            </label>
            <div class="layui-input-inline">
                <input  type="text" name="birthdate" id="birthdate" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label  class="layui-form-label">
                <span class="we-red">*</span>性别
            </label>
            <div class="layui-input-line">
                <input type="radio" name="sex" id="sex" value="男" title="男" checked>
                <input type="radio" name="sex" id="sex" value="女" title="女" >
                <input type="radio" name="sex" id="sex" value="中性" title="中性">
            </div>
        </div>

        <div class="layui-form-item">
            <label  class="layui-form-label">
                <span class="we-red">*</span>成员类型
            </label>
            <div class="layui-input-inline">
                <input  type="text" name="memberType" id="memberType" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="we-red">*</span>备注
            </label>
            <div class="layui-input-inline">
                <input type="text" name="note" id="note" autocomplete="off" class="layui-input">
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

        var upload = layui.upload;
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#birthdate' //指定元素
        });

        upload.render({
            elem: '#uploadFile' ,//绑定元素
            url: '../file/upload' ,//上传接口
            done: function(res){
                console.log(res.data)
                //上传完毕回调
                if(res.code === 0){
                    // 上传成功的地址可以在服务端写到客户端
                    //可以将上传之后的图片地址放在隐藏域里面，表单提交的时候一起提交到服务端保存图片的地址到数据库
                    $("#photo").val(res.data)
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

                $("#id").val("${personnel.id}");
                $("#communityName").val("${personnel.communityName}");
                $("#realState").val("${personnel.realState}");
                $("#memberName").val("${personnel.memberName}");
                $("#photo").val("${personnel.photo}");
                $("#idCard").val("${personnel.idCard}");
                $("#contact").val("${personnel.contact}");
                $("#work").val("${personnel.work}");
                $("#birthdate").val("${personnel.birthdate}");
                $("#sex").val("${personnel.sex}");
                $("#memberType").val("${personnel.memberType}");
                $("#note").val("${personnel.note}");
                form.render();
            }
        })


        form.on('submit(save)',function (data) {
            console.log(data.field.sex)
            $.ajax({
                type: "post",
                url: "update",
                async:false,
                data: "id="+data.field.id +"&communityName="+data.field.communityName + "&realState="+data.field.realState+"&memberName="+data.field.memberName + "&photo="+data.field.photo+"&idCard="+data.field.idCard+"&contact="+data.field.contact+"&work="+data.field.work+"&birthdate="+data.field.birthdate+"&sex="+data.field.sex+"&memberType="+data.field.memberType+"&note="+data.field.note,
                dataType:'json',
                success:function(obj){
                    alert("成功")
                    if(obj.code === 0){//成功
                        //刷新表格
                        window.parent.location.reload();
                    }

                    var iframeIndex = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(iframeIndex);
                },
                error:function () {
                    alert("错误")
                    window.parent.location.reload();
                }
            });
        })
    })
</script>
</html>
