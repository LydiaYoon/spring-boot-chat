package com.example.springbootapi.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


@RequiredArgsConstructor
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    // WebSocket을 활성화 하기 위한 Config 파일

    private final WebSocketHandler webSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler, "/ws/chat").setAllowedOrigins("*");
        // addHandler()
        // WebSocketHandlerRegistry에 WebSocketHandler의 구현체를 등록한다.
        // endpoint를 "/ws/chat"으로 설정한다.
        // 등록된 Handler는 특정 엔드포인트 "/ws/chat"으로 handshake를 완료한 후 맺어진 connection을 관리한다.

        // setAllowedOrigins("*")
        // 도메인이 다른 서버에서도 접속 가능하도록 CORS 설정을 추가
    }

}
