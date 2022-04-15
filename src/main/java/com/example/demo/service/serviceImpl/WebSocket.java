package com.example.demo.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @ClassName WebSocket
 * @Description WebSocket实现（一个特殊的service）
 * @Date 2022/4/15 0:15
 */
@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {
    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSocketSet.add(this);
        log.info("webSocket消息，有新的连接");
    }

    @OnClose
    public void onClose(){
        webSocketSet.remove(this);
        log.info("webSocket消息，连接断开");
    }

    @OnMessage
    public void onMessage(String message){
        log.info("webSocket消息，收到客户端发来的消息",message);
        sendMessage("hahahahah");
    }

    public void sendMessage(String  message){   //其中一个用户发送一个消息，则调用此方法
        for (WebSocket webSocket: webSocketSet){
            log.info("webSocket消息，广播消息",message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

