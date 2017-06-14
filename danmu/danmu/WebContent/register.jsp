<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>	
<head>
<title>Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<meta name="keywords" content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!--webfonts-->
<!--//webfonts-->
<script src="jQ/jquery-3.2.0.min.js"></script>
</head>
<body>
<script>$(document).ready(function(c) {
	$('#register').on('click', function(c){
		if ($("#userid").val()=="") {
				alert("账号不能为空");
				return;
			}
		if ($("#username").val()=="") {
				alert("昵称不能为空");
				return;
			}
		if ($("#password")[0].val()!=$("#newpwd1")[1].val("")) {
				alert("两次密码输入不一致");
				return;
			}
	});	  
	//重置功能
	$('#reset').on('click', function(c){
	$(" #userid").val("");
	$(" #username").val("");
	$(" .password").val("");
	})

});


</script>
 <!--SIGN UP-->
 <h1>欢迎进入注册页面</h1>
<div class="login-form">
	<div class="close"> </div>
		<div class="head-info">
			<label class="lbl-1"> </label>
			<label class="lbl-2"> </label>
			<label class="lbl-3"> </label>
		</div>
			<div class="clear"> </div>
	<div class="avtar">
		<img src="images/avtar.png" />
	</div>
					<input type="text" id="userid" class="userid" name="userid" placeholder="用户名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" >
					<input type="text" id="username" class="username" name="username" placeholder="昵称" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" >
					<input type="text" class="password" name="password" placeholder="密码" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">
						
					<input type="text" class="password" name="password" placeholder="确认密码" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">
					
			
	<div class="signin">
		<input type="button" id="register" value="注册" ><input type="button" value="重置" id="reset">
	</div>


</body>
</html>