<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>正在与BB弹幕建立连接...</title>  
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">  
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <!--  
    <link href="favicon.ico" rel="shortcut icon" type="image/x-icon" />  
    <link href="favicon.ico" rel="Bookmark" type="image/x-icon" />  
    -->  
    <meta name="Generator" content="EditPlus®">  
    <meta name="Author" content="">  
    <meta name="Keywords" content="">  
    <meta name="Description" content="">    
    <link href="css/jquery.fancyspinbox.css" rel="stylesheet" type="text/css">  
    <link rel="stylesheet" href="css/menu.css" type="text/css">
    <script src="jQ/jquery-3.2.0.min.js"></script>
	
    <script src="js/mobile.js"></script>  
    <script>
      window.onload=function(){
      $('.ui-select').css("display","none");
      $(".menu").blur(function(){
        $(".inhide").css('display','none');
      });
      $(".menu").focus(function(){
        $(".inhide").css('display','block');
      });
      $("#layout").click(function(){
    	  $.ajax({
              type:"post",
              url:"webservlet?method=deletesession",
              data:null,
              async: false,
              error: function () {         
              },
              success: function(message){
            	  self.location='login.jsp'; 
              }  
          });
      });
      $("#send").click(function(){
          if($("#send").attr('senddanmu')=='0'){
    	  $("#send").attr('senddanmu', '1');
    	  $("#send").attr('sendtime',getNowFormatDate());
          }
    	  setTimeout(function(){
        	  $("#send").attr('senddanmu', '0');
        	  },8000);
          
    	  
      });

      $("#changepwd").click(function(){
    	  self.location='changepwd.jsp';
      });
      $('.selected').change(function(){
    	  if ($("option:selected",this).val() == 'sky'){
				$("#page").css("background-image","url(WebContent/images/sky.jpg)");
    	  }
    	  else if($("option:selected",this).val() == 'beaufiful'){  
				$("#page").css("background-image","url(WebContent/images/beautiful.jpg)");
    	  }
    	  else  if($("option:selected",this).val() == 'moren'){  
				$("#page").css("background-image","#fff");
    	  }
      });
}
    </script>
  </head>
  <body>
   <script>
      var manageraccount = "<%=request.getSession().getAttribute("userId")%>";
      if(manageraccount=="null"){
      self.location='404.html'; 
    }
    </script> 
    <div id="page" data-role="page">
      <div id="header" style="height:100px">
        <div class="container">
          <select id="my-menu">         
            <option value="" selected="">请选择班级</option>
            <script>
              $.ajax({
                  type:"post",
                  url:"webservlet?method=searchclass",
                  data:null,
                  dateType:"json",
                  async: false,
                  error: function () {
                      alert("服务器异常!");
                      
                  },
                  success: function(message){
                      console.log(message);
                      msg = eval("("+message+")")
                      for (var i = 0; i < msg.count; i++) {
                          console.log(msg.class[i].classname);
                        $("#my-menu").append("<option classid='"+msg.class[i].classid+"'>"+msg.class[i].classname+"</option>");
                      }  
                  }
              });
            </script>
          </select> 

          <script src="js/jquery.js"></script>        
          <script src="js/jquery.fancyspinbox.js"></script>       
          <script>$('#my-menu').fancyspinbox();</script>


          <select id="my-menu2" class="selected">
            <option value="sky">蓝天</option>                        
            <option value="huihong">恢弘</option>            
            <option value="moren" selected="selected">默认皮肤</option>
          </select> 
          <!-- user dropdown starts -->
          <ul style="display:inline" class="menu" tabindex="-1">
            <li >您好，<%=request.getSession().getAttribute("userName")%>用户</li>
            <input type="hidden" value="<%=request.getSession().getAttribute("userId")%>" id="userId">
            <input type="hidden" value="<%=request.getSession().getAttribute("userName")%>" id="name">
            <li class="inhide"><a id="changepwd">修改密码</a></li>
            <li class="inhide"><a id="layout">登出</a></li>
            <span class="ico_down"></span>

          </ul>
        </div>
      </div>
        <canvas id="c2" width="800" height="745" ></canvas>   
      <div id="danmu">
        <textarea id="msg" placeholder="来一发弹幕～(100个字符以内)" onkeyup="words_deal();"></textarea>
		<script type="text/javascript">
		function words_deal(){ 
	    	  var curLength=$("#msg").val().length; 
	    	  if(curLength>100) 
	    	  { 
	    	  var num=$("#msg").val().substr(0,100); 
	    	  $("#msg").val(num); 
	    	  alert("超过字数限制，多出的字将被截断！" ); 
	    	  } 
  	  	} 
		</script>
        <select id="my-menu3" name="fontsize">
            <option value="big">大</option>            
            <option value="small">小</option>                                  
            <option value="middle" selected="">弹幕字体（中）</option>
        </select> 
        <select id="my-menu4" name="position">
            <option value="buttom">下方</option>            
            <option value="centre">中间</option> 
            <option value="top" selected="">顶端</option>
        </select> 
        <select id="my-menu5" name="position">
            <option value="red">红色</option>            
            <option value="green">绿色</option> 
            <option value="grey">灰色</option> 
            <option value="purple ">紫色 </option> 
            <option value="blue" selected="">蓝色</option>
        </select> 
        <input type="button" value="发送弹幕" id="send" senddanmu="0"> 
      </div>    

	  <script src="js/emit.js"></script>
	  <script src="js/socket.js"></script>
  </body>
</html>