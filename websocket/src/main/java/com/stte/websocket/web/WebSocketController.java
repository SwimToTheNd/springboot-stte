package com.stte.websocket.web;

import com.stte.websocket.domain.SocketMessage;
import com.stte.websocket.domain.SocketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.concurrent.TimeUnit;

/**
 * create by BloodFly at 2018/12/19
 */
@Controller
public class WebSocketController {

    // 当浏览器向服务端发送请求时，通过@MessageMapping映射/welcome这个地址，类似@RequestMapping
    @MessageMapping("/welcome")
    // 当服务端有消息时，会对订阅了@SendTo中路径的浏览器发送消息
    @SendTo("/topic/getResponse")
    public SocketResponse say(SocketMessage message) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(3000);
        return new SocketResponse("欢迎, " + message.getName() + "!");
    }

    //通过SimpMessagingTemplate向浏览器发送消息
    @Autowired
    private SimpMessagingTemplate messagingTemplate;


    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) { //Principal对象包含当前用户的信息
        if (principal.getName().equals("wyf")) {
            // param1:接收消息的用户，param2:浏览器订阅的地址，param3:消息本身
            messagingTemplate.convertAndSendToUser("wisely", "/queue/notifications", principal.getName() + "-send: " + msg);
        } else {
            messagingTemplate.convertAndSendToUser("wyf", "/queue/notifications", principal.getName() + "-send: " + msg);
        }
    }
}
