<%--
  Created by IntelliJ IDEA.
  User: cyh
  Date: 2018/4/13
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%
    String path = request.getContextPath();
    request.setAttribute("path", path);
%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入bootstrap -->
    <link rel="stylesheet" href="${path}/static/css/bootstrap.min.css" />
    <!-- 引入JQuery  bootstrap.js-->
    <script type="text/javascript" src="${path}/static/js/jquery-3.2.1.min.js" ></script>
    <script type="text/javascript" src="${path}/static/js/bootstrap.min.js" ></script>
    <!--进度条-->
    <script src="https://cdn.bootcss.com/bootstrap-progressbar/0.9.0/bootstrap-progressbar.js"></script>
    <style>
        /*div{*/
            /*border: 1px red solid;*/
        /*}*/
        #maindiv {
            background:#000;
            opacity:0.6;
            border-radius:15px;
        }
        body{
            background: url(${backImg}) no-repeat;
            background-size:100% 100%;
            background-attachment:fixed;
            color: white;
        }
        .inputfont{
            color: black;
        }
    </style>
</head>
<body>
<div class="container">
    <div id="maindiv" class="col-md-6 col-md-offset-3" style="margin-top: 120px;" >
        <div class="row">
            <a href="#" id="userloginBtn" class="btn btn-block">用户登录</a>
        </div>
        <div class="row" id="box-userlogin" style="">
                <div class="col-md-1"></div>
            <div class="col-md-9">
                <form id="userLoginForm" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">用户名:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control inputfont" id="loginUsername" name="loginUsername"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">密码:</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control inputfont" id="loginPassword" name="loginPassword" placeholder="请输入密码"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">验证码</label>
                        <div class="col-sm-9">
                            1234
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label"></label>
                        <div class="col-sm-9">
                            <input type="button" id="userLoginBtn" class="btn btn-block btn-info" value="登录">
                        </div>
                    </div>
                </form>
            </div>

        </div>

        <div class="row" style="color: white">
            <a href="#" id="regBtn" class="btn btn-block" >注册</a>
        </div>
        <div class="row" id="box-reg" style="height: 400px; display: none;">
             <div class="col-md-1"></div>
            <div class="col-md-9">
                <form id="regForm" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">用户名:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control inputfont" name="username"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">密码:</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control inputfont" name="password" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">重复密码:</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control inputfont" name="passwordCheck" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">邮箱:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control inputfont" name="email" placeholder="用于验证"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label"><a href="#">协议</a></label>
                        <div class="col-sm-9">
                            <input type="checkbox" class="inputfont"/>同意
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label"></label>
                        <div class="col-sm-9">
                            <input type="button" id="regSubmit" class="btn btn-block btn-info" data-toggle="modal" data-target="#myModal" value="注册">
                        </div>
                    </div>
                </form>
            </div>


        </div>

        <div class="row">
            <a href="#" id="forgetBtn" class="btn btn-block">忘记密码</a>
        </div>
        <div class="row" id="box-forget" style="height: 400px; display: none;">
            忘记密码框
        </div>

        <div class="row">
            晨签logo
        </div>

    </div>
</div>




<div class="modal fade" id="myModal" backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <div class="progress">
                    <div class="progress-bar progress-bar-info" id="jdbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="60"
                         style="width:0%"></div>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


</body>

<script>

    $(function(){
        $('#myModal').modal({
            keyboard: true,
            backdrop:false,
            show:false
        })
        var myVar;

        //盒子的伸缩
        $('#maindiv').on('click','a',function(){
            switch(this.id){
                case 'userloginBtn':
                    $('#box-reg, #box-forget, #box-admin').slideUp('hide');
                    if ($('#box-userlogin').is(':hidden')){
                        $('#box-userlogin').slideDown('show');
                    }else{
                        $('#box-userlogin').slideUp('hide');
                    }
                    break;
                case 'regBtn':
                    $('#box-userlogin, #box-forget, #box-admin').slideUp('hide');
                    if ($('#box-reg').is(':hidden')){
                        $('#box-reg').slideDown('show');
                    }else{
                        $('#box-reg').slideUp('hide');
                    }
                    break;
                case 'forgetBtn':
                    $('#box-userlogin, #box-reg, #box-admin').slideUp('hide');
                    if ($('#box-forget').is(':hidden')){
                        $('#box-forget').slideDown('show');
                    }else{
                        $('#box-forget').slideUp('hide');
                    }
                    break;
            }
        });

        //注册事件
        $('#regSubmit').on('click', function(event) {
            data = $('#regForm').serialize();
            <!--进度条-->
            $('#myModal').modal("show");
            myVar = setInterval(function(){
                var num = parseInt($('#jdbar').css("width"));
                console.log(num);
                parseInt($('#jdbar').css("width",num+7+"%"))
                if (num > 100){
                    clearInterval(myVar);
                }
            }, 100);
            $.ajax({
                type:'post',
                url:'${path}/user/reg',
                data:data,
                success:function (msg) {
                    if (msg.code == "1"){
                        //window.location.href = "${path}/login/home";
                        $('#myModal').modal("hide");
                        $('#userloginBtn').click();
                        $('#loginUsername').val($('input[name="username"]').val());
                        $('#loginPassword').val($('input[name="password"]').val());
                    }else{
                        $('#myModal').modal("hide");
                        alert(msg.message);
                    }
                }
            })
            event.stopPropagation();
        });

        /**
         * 用户登录提交
         */
        $('#userLoginBtn').on('click',function () {
            data ={
                'username':$('#loginUsername').val(),
                'password':$('#loginPassword').val()
            };
            $.ajax({
                type:'post',
                url:'${path}/user/login',
                data:data,
                success:function (msg) {
                    if (msg.code == "1"){
                        window.location.href = "${path}/index";
                    }else{
                        alert(msg.message);
                    }
                }
            })
            event.stopPropagation();
        });


        <%--$('#adminLogin').on('click',function () {--%>
            <%--var username = $.trim($("#adminName").val());--%>
            <%--var password = $.trim($("#adminPass").val());--%>
            <%--data = {'username':username,--%>
                <%--'password':password};--%>
            <%--$.ajax({--%>
                <%--type:'post',--%>
                <%--url:'${path}/login/adminlogin',--%>
                <%--data:data,--%>
                <%--success:function (msg) {--%>
                    <%--if (msg == "success"){--%>
                        <%--window.location.href = "${path}/login/adminMain";--%>
                    <%--}else if(msg == "fail"){--%>
                        <%--alert("登录失败")--%>
                    <%--}--%>
                <%--}--%>
            <%--})--%>
        <%--});--%>
    });

</script>

</html>
