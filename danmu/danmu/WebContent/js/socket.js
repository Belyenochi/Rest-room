/*		  var webSocket = new WebSocket('ws://localhost:8080/danmu/websocket');  
	      webSocket.onerror = function(event) {  
	          alert(event.data);  
	      };  
	      //与WebSocket建立连接  
	      webSocket.onopen = function(event) {  
	          document.getElementById('messages').innerHTML = '与服务器端建立连接';  
	      };  
	      //处理服务器返回的信息  
	      webSocket.onmessage = function(event) {  
	          document.getElementById('messages').innerHTML += '<br />'+ event.data;  
	      };  
	      function start() {  
	          //向服务器发送请求  
	          webSocket.send("userid="+$("#userId").val()+"dmcontent="+$("#msg").val());  
	      }
*/
	  var websocket = null;
       
      //判断当前浏览器是否支持WebSocket
      if('WebSocket' in window){
          websocket = new WebSocket("ws://192.168.1.7:8080/danmu/websocket");
      }
      else{
          alert('Not support websocket')
      }
       
      //连接发生错误的回调方法
      websocket.onerror = function(){
          setMessageInnerHTML("error");
      };
       
      //连接成功建立的回调方法
      websocket.onopen = function(event){
    	  document.title='欢迎登陆BB教学用弹幕系统';
      }
       
      //接收到消息的回调方法
      websocket.onmessage = function(){
        //setMessageInnerHTML(event.data);
    	  var atr = new Array();
          console.log(event.data);
          var str = event.data.toString();
          event.data=null;
          
          atr = str.split(",");
          var username = atr[0].split("=")[1];
          var dmcontent= atr[2].split("=")[1];
          var dmfontsize= atr[4].split("=")[1].split("&")[0];
          var dmfonthight = atr[4].split("=")[1].split("&")[1];
          var dmfontcolor = atr[4].split("=")[1].split("&")[2];
          var random = Math.random();
          var oC2;
          var oGC2;
          var numW;
          var numH;
          if (dmfonthight=="buttom") random = random * 200 + 400;
          if (dmfonthight=="centre") random = random * 200 + 200;
          if (dmfonthight=="top") random = random * 200 ;
          
    
//          var numW;  
//          var numH;  
          maxTxt = 800; 
         
          var m = dmcontent;  
          //alert(m);  
          startFun(m);   
       
          function startFun(msg){  
              doDraw(msg);  
              var sId = setInterval(function(){       
                  if (numW > -1)  
                  {  
                      numW--;  
                      oGC2.clearRect(0,0,oC2.width,oC2.height);  
                      oGC2.fillText(msg,numW,random);  
                  } else {  
                      oGC2.clearRect(0,0,oC2.width,oC2.height);  
                      clearInterval(sId);  
                  }  
              },15);   
          } 
          function doDraw(msg){  
              oC2 = document.getElementById('c2');  
              oGC2 = oC2.getContext('2d');     
              numW = oC2.width;  
              numH = oC2.height;   
              
              if (dmfontsize=="small") {oGC2.font="10px Serif"};
              if (dmfontsize=="middle") {oGC2.font="15px Serif"};
              if (dmfontsize=="big"){oGC2.font="20px Serif"};

              oGC2.fillStyle= dmfontcolor;  
              //oGC.fillRect(0,0,numW,100);  
              oGC2.fillText(msg,numW,random);
          }  
    }
      
         
      //连接关闭的回调方法
      websocket.onclose = function(){
          setMessageInnerHTML("close");
      }
       
      //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
      window.onbeforeunload = function(){
          websocket.close();
      }
       
      //将消息显示在网页上
      function setMessageInnerHTML(innerHTML){
          // document.getElementById('my-player').innerHTML += innerHTML + '<br/>';
          alert(innerHTML);
      }
       
      //关闭连接
      function closeWebSocket(){
          websocket.close();
      }
       
      //发送消息
      function send(){
          websocket.send("username="+$("#name").val()+",userid="+$("#userId").val()+",dmcontent="+$("#msg").val()+",classid="+$('li#fancy-spinbox-0-option-1.selected').attr('classid')+",dmstyle="+$('#my-menu3 option:selected').val()+"&"+$('#my-menu4 option:selected').val()+"&"+$('#my-menu5 option:selected').val());
   	}