<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>注册账号</title>
    <script src="static/bootstrap/jquery-1.12.4.min.js"></script>
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css">
    <script src="static/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="static/css/common.css">
    <script src="${pageContext.request.contextPath}/static/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="static/css/register.css">

    <script src="https://cdn.bootcss.com/limonte-sweetalert2/7.28.11/sweetalert2.all.js"></script>
    <link href="https://cdn.bootcss.com/limonte-sweetalert2/7.28.11/sweetalert2.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/limonte-sweetalert2/7.28.11/sweetalert2.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
    <%--<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>--%>
    <script>
        function addImgAndInfo(selectStr,objId,str){
            var oneObj = document.getElementById(objId);
            oneObj.innerHTML = ""
            var imgobj = document.createElement("img");
            if(selectStr=="true"){
                imgobj.src = "/static/img/common/green.png";
                oneObj.style.color="#000000";
            } else if(selectStr =="false"){
                imgobj.src = "/static/img/common/error.png";
                oneObj.style.color="#ff5b5b";
            } else if(selectStr=="null"){
                imgobj.src = "";
                oneObj.style.color="#8191D2";
            }
            oneObj.appendChild(imgobj);
            oneObj.append(str);
        };
        function checkCanBeRegister(){
            var imgs = document.getElementsByTagName("img");
            var urlStr = window.document.location.href;
            var pathName=window.document.location.pathname;
            var pos=urlStr.indexOf(pathName);
            var localhostPath=urlStr.substring(0,pos);
            for(var i=0;i<imgs.length;i++){
                if(imgs [i].src==localhostPath+"/static/img/common/error.png"){
                    return false;
                }
            }
            return true;
        };
        $(document).ready(function(){
            //添加失焦点事件
            $("#userName").blur(function(){
                var userName=$(this).val();
                re = /^[a-zA-z]\w{4,15}$/;
                if(!re.test(userName)){
                    addImgAndInfo("false","promt-userName","用户名不符合规定");
                }
                else{
                    $.ajax({
                        url:"${pageContext.request.contextPath }/my/ajaxCheckUserName.do",
                        dataType:"text",
                        type:"post",
                        data:{"userName":userName},
                        success:function(data){
                            if(data=="用户名可以使用"){
                                addImgAndInfo("true","promt-userName","用户名可以使用");
                            }
                            else if(data=="用户名已存在"){
                                addImgAndInfo("false","promt-userName","用户名已存在");
                            }

                        },
                        error:function(){
                            alert("ajax有问题!网站正在维护!");
                        }
                    });
                }
            });
            //添加焦点状态
            $("#userName").click(function(){
                addImgAndInfo("null","promt-userName","用户名为5-16位的，以字母开头的");
            });
        });

        $(document).ready(function(){
            //添加失焦点事件
            $("#userMail").blur(function(){
                var userMail=$(this).val();
                var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
                var promtStr = "promt-userMail";
                if(!myreg.test(userMail)){
                    addImgAndInfo("false",promtStr,"邮箱地址不合法");
                }
                else{
                    userMail = $.trim(userMail);
                    if(userMail != ""){
                        $.ajax({
                            url:"${pageContext.request.contextPath }/my/ajaxCheckUserMail.do",
                            dataType:"text",
                            type:"post",
                            data:{"userMail":userMail},
                            success:function(data){
                                if(data=="邮箱已存在"){
                                    addImgAndInfo("false",promtStr,"邮箱已被注册");
                                }
                                else {
                                    addImgAndInfo("true",promtStr,"邮箱可以使用");
                                }
                            },
                            error:function(){
                                alert("ajax有问题!网站正在维护!");
                            }
                        });
                    }
                }
            });
        });

        $(document).ready(function(){
            $("#sendCode").click(function(){
                var email=$("#userMail").val();
                var userName=$("#userName").val();
                var userPassword=$("#userPassword").val();
                var userPasswordAgain=$("#userPasswordAgain").val();
                if(userName == ""||userPassword == ""||userPasswordAgain==""||email == ""){
                    swal({
                        title: '所有信息不为空',
                        type: 'warning'
                    })
                } else if(!checkCanBeRegister()){
                    swal({
                        title: '填写信息有误',
                        type: 'error'
                    })
                }
                else{
                    email = $.trim(email);
                    userName = $.trim(userName);
                    if(email != "" && userName != ""){
                        swal(
                            '正在发送验证码...'
                        );
                        $.ajax({
                            url:"${pageContext.request.contextPath }/my/sendMail.do",
                            dataType:"text",
                            type:"post",
                            data:{"email":email,"userName":userName},
                            success:function(data){
                                swal({
                                    title: '验证码发送成功！',
                                    timer: 3000,
                                    type:'success'
                                }).then(
                                    function () {},
                                    // handling the promise rejection
                                    function (dismiss) {
                                        if (dismiss === 'timer') {
                                            console.log('I was closed by the timer')
                                        }
                                    }
                                )

                            },
                            error:function(){
                                alert("ajax有问题!");
                            }
                        });
                    }
                }
            });
        });
        $(document).ready(function () {
            $("#userPassword,#userPasswordAgain").blur(function () {
                var userPassword = $("#userPassword").val();
                var userPasswordAgain = $("#userPasswordAgain").val();
                var promtStrUserPassword = "promt-userPassword";
                var promtStrUserPasswordAgain = "promt-userPasswordAgain";
                var pwdReg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$/;
                if(!pwdReg.test(userPassword)){
                    addImgAndInfo("false",promtStrUserPassword,"密码由8-16位的数字和字母组合");
                } else {
                    addImgAndInfo("true",promtStrUserPassword,"");
                }
                if(userPassword!=userPasswordAgain&&userPasswordAgain!=""){
                    addImgAndInfo("false",promtStrUserPasswordAgain,"两次密码不一致");
                } else if(userPasswordAgain==""){
                    addImgAndInfo("false",promtStrUserPasswordAgain,"确认密码不为空");
                }
                else {
                    addImgAndInfo("true",promtStrUserPasswordAgain,"");
                }
            })
        })
        $(document).ready(function () {
            $("#submit").click(function() {
                var userCode=$('#userCode').val();
                // var userLastRegisterIp=returnCitySN["cip"];
                var userLastRegisterIp = "0.0.0.0";
                var userMail=$("#userMail").val();
                var userName=$("#userName").val();
                var userPassword=$("#userPassword").val();
                var userStatus=1;
                if(userName == ""||userPassword == ""||userMail == ""||userLastRegisterIp == ""|| userStatus == ""||userCode == ""){
                    swal({
                        title: '所有信息不为空',
                        type: 'warning'
                    })
                } else if(!checkCanBeRegister()){
                    swal({
                        title: '填写信息有误',
                        type: 'error'
                    })
                }
                else{
                    userCode = userCode.trim(userCode);
                    if(userCode != ""){
                        $.ajax({
                            url:"${pageContext.request.contextPath }/my/ajaxCheckCode.do",
                            dataType:"text",
                            type:"post",
                            data:{"verfiCode":userCode},
                            success:function(data){
                                if(data=="验证码正确,请继续完成注册"){
                                    $.ajax({
                                        url:"${pageContext.request.contextPath }/my/AjaxRegister.do",
                                        type:"post",
                                        dataType:"text",
                                        data:{"userName":userName,"userPassword":userPassword,"userMail":userMail,"userLastRegisterIp":userLastRegisterIp,"userStatus":userStatus},
                                        success:function(data){
                                            if(data === 'success'){
                                                swal({
                                                    title: '注册成功！',
                                                    text: '正在前往登录界面',
                                                    type:'success'
                                                })
                                                setTimeout(window.location.href = "${pageContext.request.contextPath }/index.jsp",1000);
                                            }
                                            else{
                                                alert("注册失败!");
                                            }
                                        },
                                        error:function(){
                                            alert("ajax有问题!");
                                        }
                                    });
                                } else {
                                    swal({
                                        title: data,
                                        type: 'error'
                                    })
                                }
                            },
                            error:function(){
                                alert("ajax有问题!");
                            }
                        });
                    }
                }
            })
        })
        <%--function submit(){--%>
            <%--//添加点击提交事件--%>
            <%--var userLastRegisterIp="0.0.0.0";--%>
            <%--var userMail=$("#userMail").val();--%>
            <%--var userName=$("#userName").val();--%>
            <%--var userPassword=$("#userPassword").val();--%>
            <%--var userPasswordAgain=$("#userPasswordAgain").val();--%>
            <%--var userStatus=1;--%>
            <%--if(userName == ""||userPassword == ""||userMail == ""||userLastRegisterIp == ""|| userStatus == ""||userCode != ""){--%>
                <%--swal({--%>
                    <%--title: '所有信息不为空',--%>
                    <%--type: 'warning'--%>
                <%--})--%>
            <%--}--%>
            <%--else{--%>
                <%--if(userPassword === userPasswordAgain){--%>
                    <%--$.ajax({--%>
                        <%--url:"${pageContext.request.contextPath }/my/AjaxRegister.do",--%>
                        <%--type:"post",--%>
                        <%--dataType:"text",--%>
                        <%--data:{"userName":userName,"userPassword":userPassword,"userMail":userMail,"userLastRegisterIp":userLastRegisterIp,"userStatus":userStatus},--%>
                        <%--success:function(data){--%>
                            <%--alert("开始注册验证");--%>
                            <%--if(data === 'success'){--%>
                                <%--alert("注册成功!");--%>
                                <%--window.location.href = "${pageContext.request.contextPath }/my/registerSuccess.do";--%>
                            <%--}--%>
                            <%--else{--%>
                                <%--alert("注册失败!");--%>
                            <%--}--%>
                        <%--},--%>
                        <%--error:function(){--%>
                            <%--alert("ajax有问题!");--%>
                        <%--}--%>
                    <%--});--%>
                <%--}--%>
                <%--else{--%>
                    <%--alert("两次密码不相等!");--%>
                <%--}--%>
            <%--}--%>

        <%--}--%>
    </script>
</head>
<body>
    <div class="modal-header" id="modal-page-title">
        <div class="row">
            <div class="page-header" id="page-title">
                <div class="col-md-1"></div>
                <div class="col-md-10">
                    <img src="static/img/common/cuitLogo.png" id="header-cuit-logo"/><small class="text-info" id="header-web-title">教师出国申请平台</small>
                </div>
            </div>
        </div>
    </div>
    <div class="modal-body" id="bg">
        <div id="login">
            <br>
            <br>
            <h1 class="text-center" id="login-title">注册账号</h1>
                <div class="text-center row">
                    <label class="inputlabel col-lg-6" >
                        <br>
                        <span class="glyphicon glyphicon-user"></span>
                        <input type="text" name="userName" id="userName" placeholder="帐号">
                    </label>
                    <label class="inputlabel col-lg-6">
                        <span class="glyphicon glyphicon-envelope"></span>
                        <input type="email" name="userMail" id="userMail" placeholder="邮件">
                    </label>
                </div>
                <div class="text-left  row">
                    <div class="col-lg-1"></div>
                    <div class="col-lg-4 div-promt">
                        <label class="promt" id="promt-userName"></label>
                    </div>
                    <div class="col-lg-1"></div>
                    <div class="col-lg-5 div-promt">
                        <label class="promt" id="promt-userMail"></label>
                    </div>
                </div>
                <div class="text-center row">
                    <label class="inputlabel col-lg-6">
                        <br>
                        <span class="glyphicon glyphicon-lock"></span>
                        <input type="password" name="userPassword" id="userPassword" placeholder="密码">
                    </label>
                    <label class="inputlabel col-lg-6">
                        <span class="glyphicon glyphicon-lock"></span>
                        <input type="password" name="userPasswordAgain" id="userPasswordAgain" placeholder="确认密码">
                    </label>
                </div>
                <div class="text-left row">
                    <div class="col-lg-1"></div>
                    <div class="col-lg-4 div-promt">
                        <label class="promt" id="promt-userPassword"></label>
                    </div>
                    <div class="col-lg-1"></div>
                    <div class="col-lg-5 div-promt">
                        <label class="promt" id="promt-userPasswordAgain"></label>
                    </div>
                </div>
                <div class="text-center row">
                    <label class="inputlabel col-lg-6">
                        <br>
                        <span class="glyphicon glyphicon-heart"></span>
                        <input type="text" name="userCode" id="userCode" placeholder="验证码">
                    </label>
                    <label class="inputlabel col-lg-6">
                        <span class="glyphicon"></span>
                    <input type="button" value="发送邮箱验证码" id="sendCode">
                    </label>
                </div>
                <div>
                    <p class="text-center">
                        <input type="button" value="注册" id="submit" name="submit">
                    </p>
                </div>
        </div>
    </div>
</body>
</html>