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
    <title>晨签论坛</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/wangeditor/release/wangEditor.min.js"></script>

    <style>
        body{
            /*background: #00d95a;*/
            color: black;
        }
        .carousel-inner img {
            width: 100%;
            height: 100%;
        }
        div{
            /*border: 1px red solid;*/
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
                    <li class="active nav-item">
                        <a class="nav-link" href="#">论坛</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">签到排行榜</a>
                    </li>
                    <li  class="nav-item">
                        <a class="nav-link" href="#">积分购</a>
                    </li>
                    <li class="nav-item">
                        <a  class="nav-link" href="javascript:gouser()">个人中心</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">关于</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>

    <div class="row" style="height: 30px"></div>

    <div class="row">
       <div class="col-md-6">
           <button type="button" class="btn btn-info btn-sm">
               技术交流<span class="badge badge-info">4</span>
           </button>&nbsp;
           <button type="button" class="btn btn-info btn-sm">
               资源分享<span class="badge badge-info">4</span>
           </button>&nbsp;
           <button type="button" class="btn btn-info btn-sm">
               晒照片<span class="badge badge-info">4</span>
           </button>&nbsp;
       </div>
    </div>

    <div class="row">
        <table class="table table-bordered">
            <thead>
            <tr>
                   <th>筛选代码</th>
                     <th>筛选代码</th>
                     <th>作者/时间</th>
                    <th>回复/查看</th>
                    <th>最后发表时间</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${articleAll}" varStatus="status" var="v">
                    <tr>
                        <td colspan="2">${v.title}</td>
                        <td>
                            <fmt:formatDate pattern="yyyy-MM-dd HH:m:s" value="${v.date}" />
                        </td>
                        <td>${v.uid}</td>
                        <td>12-31</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="row">
        <div class="col-md-6" style="text-align: right">
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </ul>
            </nav>
        </div>
    </div>

    <input id="userInput" hidden="hidden" value="${user}" />
    <c:if test="${user != null}">
        <div class="row">
            <div class="col-md-12">
                <div id="editor">
                    <p>发表一篇帖子吧~</p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-10"></div>
            <div class="col-md-2">
                &nbsp;&nbsp;&nbsp;&nbsp;
                <button class="btn btn-info" id="sendArticle">发表</button>
            </div>
        </div>
    </c:if>

    <c:if test="${user == null}">
        <div class="row">
            <div class="col-md-12">
                <div id="editor">
                    <a href="${path}/user/" class="btn btn-info">请先登录</a>
                </div>
            </div>
        </div>
    </c:if>

    <div class="row" style="height: 20px;"></div>

    <div class="row">
        <h5>页脚</h5>
    </div>
    <div id="top" >回顶部</div>
</div>

</body>

<script>
    $(function(){

        //编辑器
        var E = window.wangEditor
        var editor = new E('#editor')
        // 或者 var editor = new E( document.getElementById('editor') )
        editor.create()
        if ($('#userInput').val() == ""){
            editor.$textElem.attr('contenteditable', false);
        }
        //发表帖子
        $("#sendArticle").on('click',function(){
            alert(editor.txt.html())
        })





        //轮播
        $('img[name="lunbo"]').css("height","440px");

        //回到顶部
        $("#top").click(function() {
            $("html,body").animate({scrollTop:0}, 500);
        });
    });



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