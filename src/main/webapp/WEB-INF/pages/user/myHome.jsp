<%--
  Created by IntelliJ IDEA.
  User: cyh
  Date: 2018/4/13
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: cyh
  Date: 2018/4/12
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
        body{
            background: #00d95a;
            color: black;
        }
        .carousel-inner img {
            width: 100%;
            height: 100%;
        }
        div{
            border: 1px red solid;
            padding-left: 0px;
            padding-right: 0px;
            overflow:hidden;
            font-size: 16px;
        }
        a{
            color: white;
            text-decoration:none;
        }
    </style>
</head>
<body style="height: 100%">
<div class="container" style="height: 100%;">
    <div class="row" style="font-size: 17px">
        <nav class="navbar navbar-expand-md bg-dark navbar-dark col-md-12" style="background: #FFFFFF;">
            <a class="navbar-brand" href="#">晨签</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="${path}/index">主页</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${path}/forum">论坛</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">签到排行榜</a>
                    </li>
                    <li  class="nav-item">
                        <a class="nav-link" href="#">积分购</a>
                    </li>
                    <li class="active"  class="nav-item">
                        <form id="gouserForm">
                            <input name="backImg" hidden="hidden" value="${ciBaInfos.get(0).picture2}"/>
                        </form>
                        <a  class="nav-link" href="javascript:gouser()">个人中心</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">关于</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>


    <div style="height: 10px;"></div>

    <div class="row" style="padding-bottom: 0px;background:url(${path}/static/img/a.jpg) no-repeat left top;background-size:100% 100%;">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <div class="row" style="text-align:center; ">
                <div class="col-md-12" style="height: 30px"></div>
                <div class="col-md-12">
                    <img class="rounded-circle" alt="circle" src="${path}/static/img/a2.jpg" style="width:100px;height: 100px;">
                </div>
                <div class="col-md-12">
                    <div class="col-md-12"  style="height: 10px;"></div>
                    <div class="col-md-12" style="font-size: 14px; color: white">
                        ${user.username}
                    </div>
                    <div class="col-md-12" style="font-size: 14px; color: white">
                        ${user.talk}
                    </div>
                    <c:if test="${user == null}">
                        <div class="col-md-12" style="font-size: 14px; color: white">
                            <a class="btn btn-info">关注</a>
                            <a class="btn btn-info">私信</a>
                        </div>
                    </c:if>
                    <div class="col-md-12" style="height: 30px"></div>
                </div>
            </div>
        </div>

    </div>


    <div style="height: 10px;"></div>

    <div class="row">
        <div class="col-md-3" style="padding-left: 0px">
            <div class="row">
                <div class="col-md-12" style="font-size: 19px">
                    <sapn class="col-md-3"></sapn>
                    <span class="col-md-3 badge badge-primary"><a href="#">${relationfollowers.size()}<br>关注</a> </span>
                    <span class="col-md-3 badge badge-warning"><a href="#">${relationIdols.size()}<br> 粉丝</a></span>
                    <span class="col-md-3 badge badge-success"><a href="#">${articles.size()}<br> 帖子数</a></span>
                </div>
            </div>

            <div class="row" style="height: 25px;"></div>

            <div class="row">
                <div class="col-md-12">
                    <h3>个人资料</h3>
                    <p>学校</p>
                    <p>csdn:</p>
                    <p>github:</p>
                    <p>qq</p>
                </div>
            </div>

            <div style="height: 25px"></div>

            <div class="row">
                <div class="col-md-12">
                    <h3>我的晨签</h3>
                    <c:forEach items="${signinTodays}" var="v" varStatus="status">
                        <p>${status.count},
                                <fmt:formatDate pattern="yyyy-MM-dd HH:m:s"
                                                value="${v.time}" />
                            :${v.mydesc}<p>
                        <c:if test="${status.index == 6}">
                            <a href="#" style="color: black">更多签到情况</a>
                        </c:if>
                    </c:forEach>
                </div>
            </div>

            <div style="height: 25px"></div>

            <div class="row">
                <div class="col-md-12">
                    <h3>我发布的帖子</h3>
                    <c:forEach items="${articles}" var="v" varStatus="status">
                        <p>${v.title},,,${v.content}<p>
                        <c:if test="${status.index == 6}">
                           <a href="#" style="color: black">更多帖子</a>
                        </c:if>
                    </c:forEach>
                </div>
            </div>

        </div>
        <div class="col-md-9">
            <%--你好像从来都没有早起过。。。--%>
            <div class="col-md-12" style="font-size: 20px">
                滚动个性签名
            </div>

            <div style="height: 25px"></div>

            <div class="col-md-12">
                哈哈<br><br><br><br><br><br>
            </div>

                <div style="height: 25px"></div>

            <div class="col-md-12">
                早起<br><br><br><br><br><br>
            </div>
        </div>
    </div>

    <div class="row">
        <h5>页脚</h5>
    </div>
    <div id="top" >回顶部</div>
</div>

</body>

<script>
    $(function(){
        $('img[name="lunbo"]').css("height","440px");

        $("#top").click(function() {
            $("html,body").animate({scrollTop:0}, 500);
        });
    })

    function gouser(){
        data = {'backImg':$('input[name="backImg"]').val()};
        $.ajax({
            type: 'post',
            url: '${path}/my/',
            data: data,
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