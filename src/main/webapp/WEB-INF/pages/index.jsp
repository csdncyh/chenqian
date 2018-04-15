<%--
  Created by IntelliJ IDEA.
  User: cyh
  Date: 2018/4/12
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
    String path = request.getContextPath();
    request.setAttribute("path", path);
%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
    <style>
        .carousel-inner img {
            width: 100%;
            height: 100%;
        }
        div{
            border: 1px red solid;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row" style="font-size:17px;">
        <nav class="navbar navbar-expand-md bg-dark navbar-dark col-md-12" style="">
            <a class="navbar-brand" href="#">晨签</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="${path}/index">主页</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${path}/forum">论坛</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${path}/rank">签到排行榜</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${path}/shop">积分购</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="javascript:gouser()">个人中心</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">关于</a>
                    </li>
                </ul>
            </div>
        </nav>


    </div>


    <div style="height: 10px;"></div>

    <div class="row">
        <div class="carousel-inner">
            <div id="demo" class="carousel slide" data-ride="carousel">
                <!-- 指示符 -->
                <ul class="carousel-indicators">
                    <li data-target="#demo" data-slide-to="0" class="active"></li>
                    <li data-target="#demo" data-slide-to="1"></li>
                    <li data-target="#demo" data-slide-to="2"></li>
                </ul>
                <!-- 轮播图片 -->
                <div class="carousel-inner">
                    <c:forEach items="${ciBaInfos}" varStatus="status" var="ciBaInfo">

                        <c:if test="${status.index == 0}">
                            <div class="carousel-item active">
                                <img name="lunbo" src="${ciBaInfo.picture2}">
                                <div class="carousel-caption">
                                    <p style="font-size: 17px">${ciBaInfo.content}</p>
                                    <p style="font-size: 17px">${ciBaInfo.note}</p>
                                </div>
                            </div>
                        </c:if>

                        <c:if test="${status.index != 0}">
                            <div class="carousel-item">
                                <img  name="lunbo"  src="${ciBaInfo.picture2}">
                                <div class="carousel-caption">
                                    <p style="font-size: 17px">${ciBaInfo.content}</p>
                                    <p style="font-size: 17px">${ciBaInfo.note}</p>
                                </div>
                            </div>
                        </c:if>

                    </c:forEach>
                </div>

                <!-- 左右切换按钮 -->
                <a class="carousel-control-prev" href="#demo" data-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </a>
                <a class="carousel-control-next" href="#demo" data-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </a>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4">
            <h3>签到榜</h3>
                <c:forEach items="${signinTodayAll}" varStatus="status" var="signinToday">
                    <p>${signinToday.uid}, ${signinToday.time}, ${signinToday.mydesc}</p>
                </c:forEach>
            <p>查看更多</p>
        </div>
        <div class="col-md-8">
            <h3>最近更新</h3>
            <c:forEach items="${articleAll}" varStatus="status" var="v">
                <p>${v.uid}, ${signinToday.time}, ${signinToday.mydesc}</p>
            </c:forEach>

            <div class="container" style="padding-left: 0px; padding-right: 0px;">
                <h5>他们刚刚加入</h5>
                <c:forEach items="${signinTodayAll}" varStatus="status" var="signinToday">
                    <p>${signinToday.uid}, ${signinToday.time}, ${signinToday.mydesc}</p>
                </c:forEach>
            </div>
        </div>
    </div>

    <div class="row">
        <h5>页脚</h5>
    </div>
</div>

</body>

<script>
    $(function(){
        $('img[name="lunbo"]').css("height","440px");
    })

    function gouser(){
        $.ajax({
            type: 'post',
            url: '${path}/my/',
            success: function (msg) {
                if (msg.code == "0"){ //没有用户，去登陆
                    window.location.href="${path}/user";
                }else if(msg.code == "1"){
                    window.location.href="${path}/my/myHome";
                }
            }
        })
    }
</script>

</html>