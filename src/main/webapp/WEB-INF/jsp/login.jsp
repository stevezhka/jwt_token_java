<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <base href="<%=basePath%>">--%>
    <title>Log In - Chatbot Auth</title>
    <link rel="icon" type="image/x-icon" href="image/auth.ico" />
    <link rel="stylesheet" type="text/css" href="css/login.css" >
    <%--import jquery js--%>
    <script src="webjars/jquery/3.5.0/jquery.min.js"></script>
</head>
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
