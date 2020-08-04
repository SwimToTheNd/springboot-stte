package com.stte.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * create by BloodFly at 2018/12/19
 */
@Configuration
//开户使用STOMP协议来传输基于处理（message broker）的消息，这时控制器支持使用@MessageMapping，就像使用@RequestMapping一样
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {


    //注册STOMP协议的节点（endpoint）,并映射指定的URL
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //注册一个STOMP的endpoint，并指定使用SocketJS协议
        registry.addEndpoint("/endpointWisely").withSockJS();
        //注册一个名为/endpointChat的端点
        registry.addEndpoint("/endpointChat").withSockJS();
    }


    //配置消息代理（MessageBroker）
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //广播式应配置一个/topic消息代理，点对点式应该增加一个/queue的消息代理
        registry.enableSimpleBroker("/topic","/queue");
    }
}
