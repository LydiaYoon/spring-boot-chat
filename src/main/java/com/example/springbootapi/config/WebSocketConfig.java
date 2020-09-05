package com.example.springbootapi.config;

import com.example.springbootapi.chatroom.nostomp.ChatHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Profile("!stomp")
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private ChatHandler chatHandler; // WebSocketHandler의 구현체

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatHandler, "/ws/chat").setAllowedOrigins("*").withSockJS();
        // addHandler()
        // WebSocketHandlerRegistry에 WebSocketHandler의 구현체를 등록한다.
        // 등록된 Handler는 특정 엔드포인트 "/ws/chat"으로 handshake를 완료한 후 맺어진 connection을 관리한다.
    }
}
