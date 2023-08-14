package com.sist.chat;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/web/chat/chat-ws")
public class ChatManager {
  @OnOpen
  // 연결 요청시에 처리 
  public void onOpen(Session session)
  {
	  
  }
  @OnClose
  // 연결 종료시 처리 
  public void onClose(Session session)
  {
	  
  }
  @OnMessage
  // 채팅 
  public void onMessage(String message,Session session)
  {
	  
  }
}
