package com.chenqian.controller.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 * Spring websocket配置类
 * @EnableWebSocketMessageBroker 表示这个配置类不仅配置了 WebSocket，还配置了 基于代理的 STOMP 消息；
 * 消息代理
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    /**
     * 定义接收/websocket时采用wensocket连接，添加HttpSessionHandshakeInterceptor是为了websocket握手前将httpsession中的属性
     * 添加到websocket session中，withSockJS添加对sockJS的支持
     *
     * @param stompEndpointRegistry
     */
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //端点
        stompEndpointRegistry.addEndpoint("/websocket").addInterceptors(new HttpSessionHandshakeInterceptor()).withSockJS();
    }

    /**
     * 配置消息代理，以/app为头的url将会先经过MessageMapping
     * /topic直接进入消息代理
     * @param registry
     */

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //客户端向服务端提交以app开头
        registry.setApplicationDestinationPrefixes("/app");
        //代理目的地前缀 ，会处理以topic开头的前缀
        registry.enableSimpleBroker("/topic");
    }
}
