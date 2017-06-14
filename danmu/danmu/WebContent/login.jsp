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
<body>
<script>
$(document).ready(function(c) {
	$('.close').on('click', function(c){
		$('.login-form').fadeOut('slow', function(c){
	  		$('.login-form').css('display','none');
		});
	});
	$("body").click(function(){
		$('.login-form').css('display','block');
		})	  
	$('#register').on('click', function(c){
	location.href = "register.html";

	});

	$('#Login').on('click', function(c){
		if ($(" #userid").val()=="") {
			alert("用户名不能为空");
		}else if($(" #userpwd").val()==""){
			alert("用户密码不能为空");
		}else{
			$.ajax({
                    type:"post",
                    url:"webservlet?method=login",
                    data:"&userId="+document.getElementById("userId").value+
                    "&userPwd="+document.getElementById("userPwd").value,
                    async: false,
                    error: function () {
                        alert("账号或者密码错误");                       
                    },
                    success: function(message){
                        if (message=="student") {
                            self.location.href="emit.jsp";
                        }else{
                            console.log(message);
                            alert("服务器出现错误")
                        }
                        
                    }
                });
		}
	});
});


</script>
 <!--SIGN UP-->
 <h1>欢迎登陆BB教学用弹幕系统</h1>
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
			
					<input type="text" name="userId" class="text" id="userId" placeholder="用户名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" >
					
					<input type="password" name="userPwd" id="userPwd" placeholder="密码" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">
					
			
	<div class="signin">
		
		<input type="button" value="Login" id="Login"><input type="button" value="register" id="register">
	</div>


</body>
</html>