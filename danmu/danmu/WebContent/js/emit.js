$("#send").click(function(){
   if($('li#fancy-spinbox-0-option-1.selected').attr('classid')!=null){
	   if($("#send").attr('senddanmu') == '0'){
		   if ($("#msg").val() != "") {
			
		
		   $.ajax({
		                  type:"post",
		                  contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		                  url:"webservlet?method=insertdanmu",
		                  data: "&dmcontent="+$("#msg").val()+
		          				"&dmsenddate="+getNowFormatDate()+
		          				"&dmstyle="+$('#my-menu3 option:selected').val()+
		        				","+$('#my-menu4 option:selected') .val()+","+$('#my-menu5 option:selected')+
		        				"&userid="+$("#userId").val()+
		        				"&classid="+$('li#fancy-spinbox-0-option-1.selected').attr('classid'),
		                  error: function () {
		                	  dmcontent:$("#msg").val(""),
		                      alert("发送弹幕失败,服务器异常!");
		                      
		                  },
		                  success: function(){	                	 
		                	  send();
		                	  dmcontent:$("#msg").val("");
		                      }  
	
		          })
		   }
		   else{
			   alert("弹幕内容不能为空");
		   }
	   	}
		   
	   else{
		   var newtime = getNowFormatDate();
		   var newmin = getNowFormatDate().split(':')[1];
		   var newsed = getNowFormatDate().split(':')[2];
		  
		   var time = $("#send").attr('sendtime');
		   var min = time.split(':')[1];
		   var sed = time.split(':')[2];
		   
		   var letfmin = (min - newmin)*60;
		   var letfsed = sed - newsed;
		   var leftTime = letfmin + letfsed + 8;
		   
		   alert("发送弹幕太频繁，请过"+leftTime+"秒后再发送！")
	   }
   	}else{
   		alert("请选择班级！");
   	}
});

function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
    return currentdate;
}