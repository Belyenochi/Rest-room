<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>	
<head>
<title>Change Password</title>
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
	$('#send').on('click', function(c){
		if ($("#pwd").val()=="") {
				alert("原密码不能为空");
				return;
			}
		if ($("#newpwd1").val()=="") {
				alert("重置密码不能为空");
				return;
			}
		if ($("#newpwd2").val()=="") {
				alert("确认重置密码不能为空");
				return;
			}
		if ($("#newpwd2").val()!=$("#newpwd1").val()) {
				alert("两次密码输入不一致");
				return;
			}

		$.ajax({
          type:"post",
          url:"webservlet?method=updateteacher&teacherId="+"<%=request.getParameter("teacherId")%>"+"&teacherPwd="+$("#pwd").val()+"&newpwd="+$("#newpwd2").val(),
          data:null,
          error: function () {               
                    alert("原密码错误！");
          }, 
          success: function(){
			  		alert("修改密码成功，页面将于5s后关闭！");
			  		setTimeout(function(){window.close()},5000);
              }
          
        })
	});
	$('#reset').on('click', function(){
		$("#pwd").val("");
		$("#newpwd1").val("");
		$("#newpwd2").val("");
	})
});	  
	



</script>
 <!--SIGN UP-->
 <h1>欢迎进入修改密码页面</h1>
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
		<input type="password" id="pwd" name="password" class="password" placeholder="原密码"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" >
		<input type="password" id="newpwd1" class="newpwd" name="newpassword" placeholder="重置密码" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" >	
		<input type="password" class="password" id="newpwd2" name="newpassword" class="newpwd" placeholder="确认重置密码" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">			
	<div class="signin">
		<input type="button" id="send" value="提交" ><input type="button" value="重置" id="reset">
	</div>


</body>
</html>