<%--
  Created by IntelliJ IDEA.
  User: terry
  Date: 2021/8/19
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <base href="<%=basePath%>">--%>
    <title>Auth server login page</title>
</head>
<style>
    body {
        background-color: gainsboro;
        font-size: 16px;
    }

    .div_top_1 {
        height: 140px;
        width: 100%;
    }

    .div_top_2 {
        height: 50px;
        width: 100%;
    }

    .main {
        width: 417.683px;
        height: 440px;
        background-color: #FFFFFF;
        margin: 0 auto;

    }

    .login {

        width: 360px;
        height: 360px;
        background-color: #FFFFFF;
        margin: 0 auto
    }

    .div_login_head {
        height: 36px;
        background-color: #FFFFFF;
        margin: 0 auto;
        line-height: 36px;
        text-align: center;
        color: #666;
        border-bottom: 3px solid #21b351;
        font-size: 18px;
        line-height: 24px;
        margin-bottom: -1px;
        font-family: "PingFang SC", "Microsoft yahei", "Helvetica Neue", "Helvetica", "Arial", sans-serif;
    }

    .div_input_account {
        width: 360px;
        height: 40px;

    }

    .div_input_pwd {
        width: 360px;
        height: 24px;

    }

    .input_account, .input_pwd {
        width: 360px;
        height: 40px;
        border: none;
        border-bottom: #ddd 1px solid;
        border-radius: 0;
        outline: 0;
        font: inherit;
        font-size: .875rem;
    }

    .div_button_login {
        width: 360px;
        height: 40px;
        margin-top: 36px;
        text-align: center;

    }

    .button_login {
        width: 90px;
        height: 40px;
        background: #1fa54a;
        font-size: 16px;
        cursor: pointer;
        color: white;
        border: none;
        border-radius: 2px;
        outline: 2;

    }

    .div_empty {
        width: 360px;
        height: 24px;

    }
    .div_error {
        width: 360px;
        height: 24px;
        text-align: center;
    }
    .span_error{

        color: #e35b5a;
        font-size: 13px;
    }
</style>
<body>
<div class="div_top_1">


</div>
<div class="main">
    <div class="login">
        <div class="div_top_2">

        </div>
        <div class="div_login_head">
            Auth Server
        </div>

        <div class="div_empty">
        </div>
        <form action="/login" method="post" id="loginForm">
            <div class="div_input_account">
                <input class="input_account" type="text" name="uname" placeholder="username" id="uname"/>
            </div>

            <div class="div_empty">
            </div>


            <div class="div_input_pwd">
                <input class="input_pwd" type="password" name="upwd" placeholder="password" id="upwd"/>
            </div>
            <div class="div_empty">
            </div>
            <div class="div_error">
                <span class="span_error" id="msg"> ${errorMessage}</span>
            </div>
            <div class="div_button_login">
                <input class="button_login" type="button" value="Sign in" id="signinBtn"/>
<%--                <input class="button_login" type="button" value="Sign up" id="signupBtn"/>--%>
            </div>
        </form>
    </div>


</div>

</div>
</body>
<%--import jquery js--%>
<script src="webjars/jquery/3.5.0/jquery.min.js"></script>
<script type="text/javascript">
    $("#signinBtn").click(function () {
        var uname = $("#uname").val();
        var upwd = $("#upwd").val();
        if (isEmpty(uname)) {
            $("#msg").html("Please input your name");
            return;
        }
        if (isEmpty(upwd)) {
            $("#msg").html("Please input your password");
            return;
        }
        $("#loginForm").submit();
    });

    function isEmpty(str) {
        if (str == null || str.trim() == "") {
            return true;
        }
        return  false;
    }
</script>
</html>
