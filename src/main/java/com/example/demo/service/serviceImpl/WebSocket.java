package com.example.demo.service.serviceImpl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.message;
import com.example.demo.dao.messageMapper;
import com.example.demo.result.Result;
import com.example.demo.result.ResultGenerator;
import com.example.demo.utils.GetBeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import static com.example.demo.service.serviceImpl.MessageServiceImpl.*;

/**
 * @ClassName WebSocket
 * @Description WebSocket实现（一个特殊的service）
 * @Date 2022/4/15 0:15
 */
@Component
@ServerEndpoint("/webSocket/{userId}")
@Slf4j
public class WebSocket {


    private MessageServiceImpl messageService;

    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的
     */
    private static int onlineCount = 0;

    /**
     * concurrent 包的线程安全Set，用来存放每个客户端对应的 myWebSocket对象
     * 根据userId来获取对应的 WebSocket
     */
    private static ConcurrentHashMap<Integer, WebSocket> webSocketMap = new ConcurrentHashMap<>();

    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();
    /**
     * 接收 sid
     */
    private Integer userId;


    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;



    /**
     * 连接建立成功调用的方法
     *
     * @param session
     * @param userId
     */
    @OnOpen
    public void onOpen(Session session,@PathParam("userId") Integer userId){
        this.session = session;
        this.userId = userId;
        webSocketMap.put(userId, this);

        addOnlineCount(); // 在线数 +1
        log.info("有新窗口开始监听:" + userId + ",当前在线人数为" + getOnlineCount());

        log.info("webSocket消息，有新的连接");

    }


    /**
     * 关闭连接
     */
    @OnClose
    public void onClose(){
        if (webSocketMap.get(this.userId) != null) {
            webSocketMap.remove(this.userId);
            subOnlineCount(); // 人数 -1
            log.info("有一连接关闭，当前在线人数为：" + getOnlineCount());
        }
        log.info("webSocket消息，连接断开");
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     *
     */
    @OnMessage
    public void onMessage(String message){

        log.info("收到来自窗口" + userId + "的信息：" + message);

        if (StringUtils.isNotBlank(message)) {
            try {
                // 解析发送的报文
                JSONObject jsonObject = JSON.parseObject(message);
                // 追加发送人（防窜改）
                Integer type =jsonObject.getInteger("type");
                Integer toUserId =jsonObject.getInteger("acceptId");
                jsonObject.put("real_send_id",userId);


                //String toUserId = jsonObject.getString("toUserId");
                // 传送给对应 toUserId 用户的 WebSocket

                //模拟传输数据过程(只有一个websocket,所以发送给自己才可以接收到,时间从r中取出)
                jsonObject.put("info_time","2022-05-03 11:33:05");
                jsonObject.put("info_id",7);
                webSocketMap.get(userId).sendMessage(jsonObject.toJSONString());
                /**   真实过程
                if (toUserId!=null && webSocketMap.containsKey(toUserId)) {
                    webSocketMap.get(toUserId).sendMessage(jsonObject.toJSONString());
                } else {
                    log.info("请求的userId：" + toUserId + "不在该服务器上"+jsonObject.toJSONString()); // 否则不在这个服务器上，发送到 MySQL 或者 Redis
                }
                //无论最后是否立即返回给接收消息用户，都需要将消息存入数据库
                ApplicationContext act = GetBeanUtil.getApplicationContext();
                messageService=act.getBean(MessageServiceImpl.class);
                Result r=messageService.insertDB(jsonObject);
                if(r.getCode()==200){
                    System.out.println("存入数据库成功");
                }
                 **/

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 实现服务器主动推送
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String  message){   //其中一个用户发送一个消息，则调用此方法
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 群发自定义消息(还没改，暂时不用)
     *
     * @param message
     * @param userId
     * @throws IOException
     */
    public static void sendInfo(String message, @PathParam("userId") Integer userId) throws IOException {
        // 遍历集合，可设置为推送给指定sid，为 null 时发送给所有人
        Iterator entrys = webSocketMap.entrySet().iterator();
        while (entrys.hasNext()) {
            Map.Entry entry = (Map.Entry) entrys.next();

            if (userId == null) {
                webSocketMap.get(entry.getKey()).sendMessage(message);
                log.info("发送消息到：" + entry.getKey() + "，消息：" + message);
            } else if (entry.getKey().equals(userId)) {
                webSocketMap.get(entry.getKey()).sendMessage(message);
                log.info("发送消息到：" + entry.getKey() + "，消息：" + message);
            }
        }
    }

    private static synchronized int getOnlineCount() {
        return onlineCount;
    }

    private static synchronized void addOnlineCount() {
        WebSocket.onlineCount++;
    }

    private static synchronized void subOnlineCount() {
        WebSocket.onlineCount--;
    }

}

