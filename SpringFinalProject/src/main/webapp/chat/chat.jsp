<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.myrow{
  width: 800px;
  height: 750px;
  margin: 0px auto;
}
#chatArea{
  height: 250px;
  overflow-y:auto;
  border: 1px solid black 
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js"></script>
<script type="text/javascript">
let websocket;
function connection() // 서버 연결 
{
	websocket=new WebSocket("ws://localhost/web/chat/chat-ws")
	websocket.onopen=onOpen;
	websocket.onclose=onClose;
	websocket.onmessage=onMessage;
}
// on=>Callback (자동 호출)
function onOpen(event) // 연결되었을때 처리
{
	 alert("채팅서버와 연결되었습니다!!")
}
function onClose(event) // 퇴장시에 처리 
{
	 alert("채팅서버와 연결 종료되었습니다!!")
}
function onMessage(event) // 채팅 메세지 전송시 
{
	// msg:데이터전송 , 구분자 => roomin:
	 let data=event.data;
	 if(data.substring(0,4)==="msg:")
	 {
		 appendMessage(data.substring(4));
     }
}
function disconnection() // 퇴장시 처리 
{
	websocket.close();
}
function send() // 서버에 채팅 요청 => 값 전송 
{
	let name=$('#name').val();
	if(name.trim()==="")
	{
		$('#name').focus();
		return;
	}
	let msg=$('#sendMsg').val();
	if(msg.trim()==="")
	{
		$('#sendMsg').focus();
		return;
	}
	
	websocket.send("msg:["+name+"]"+msg);
	$('#sendMsg').val("")
	$('#sendMsg').focus()
}
function appendMessage(msg) //div에 문자열 결합 
{
	  $('#recvMsg').append(msg+"<br>");
	  let ch=$('#chatArea').height();
	  let m=$('#recvMsg').height()-ch;
	  $('#chatArea').scrollTop(m);
}
$(function(){
	$('#startBtn').click(function(){
		connection()
	})
	$('#endBtn').click(function(){
		disconnection()
	})
	$('#sendBtn').click(function(){
		send();
	})
	$('#sendMsg').keydown(function(key){
		if(key.keyCode==13)
		{
			send();
		}
	})
})
</script>
</head>
<body>
<div class="wrapper row3">
  <main class="container clear">
  <h2 class="sectiontitle">실시간 채팅</h2>
  <div class="row myrow">
   <table class="table">
    <tr>
     <td class="inline">
      이름:<input type=text id="name" size=15 class="input-sm" readonly value="${sessionScope.name }">
      <input type=button id="startBtn" value="입장" class="btn btn-sm btn-danger">
      <input type=button id="endBtn" value="퇴장" class="btn btn-sm btn-primary">
     </td>
    </tr>
    <tr>
     <td>
       <div id="chatArea">
        <div id="recvMsg"></div>
       </div>
     </td>
    </tr>
    <tr>
      <td class="inline">
        <input type=text id="sendMsg" size=80 class="input-sm">
        <input type=button id=sendBtn value=전송 
          class="btn btn-sm btn-success">
      </td>
    </tr>
   </table>
  </div>
  </main>
</div>
</body>
</html>