<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>弹幕历史查询</title>
	<link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<link href="css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
	<link href="css/jquery.decapitate.css" rel="stylesheet" type="text/css" />
  	<link href="css/styles.css" rel="stylesheet" type="text/css" />
  	<script type="text/javascript" src="js/jquery.js"></script>
  <script>
      $(document).ready(function(){
        $.ajax({
              type:"post",
              url:"webservlet?method=searchDanmu&classId="+<%=request.getParameter("classId")%>,
              data:null,
              dataType:"json",
              error: function () {               
                        alert("服务器异常！");
              }, 
              success: function(msg){
                 
				  console.log(msg);
                  for (var i = 0;i < msg.count; i++) {
                       var tr = "<tr>"+
                      "<td>"+msg.danmu[i].dmid+"</td>"+
                      "<td>"+msg.danmu[i].dmcontent+"</td>"+
                      "<td>"+msg.danmu[i].userid+"</td>"+
                      "<td>"+msg.danmu[i].dmsenddate+"</td>"+
                      "</tr>"
                      $('#body').append(tr);
                  }
              }
        })
      });
  </script>
</head>
<body>
	<div class="htmleaf-container">
		<header class="htmleaf-header">
			<h1>历史弹幕信息</h1>
		</header>
		<table id="element-table" class="table table-bordered">
		    <thead>
		      <tr>
		        <th>弹幕编号</th>
		        <th>弹幕内容</th>
		        <th>发送人学号</th>
            	<th>发送时间</th>
		      </tr>
		    </thead>
		    <tbody id="body">
		      <tr><td>1</td><td>H</td><td>Hydrogen</td><td>hhh</td></tr>
		      <tr><td>2</td><td>He</td><td>Helium</td><td>wwww</td></tr>
		      
		    </tbody>
		  </table>

		
	<script src="http://cdn.bootcss.com/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
	<script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
	<script src="js/bootstrap-affix.js"></script>
  	<script src="js/jquery.decapitate.js"></script>
  	<script type="text/javascript">
  		$(document).ready(function() {
		      $('table').decapitate();
		    });
  	</script>
</body>
</html>