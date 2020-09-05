package com.example.springbootapi.chatroom.model;

import com.example.springbootapi.chatroom.service.ChatService;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public class ChatRoom {
    private String roomId;
    private String name;
    private Set<WebSocketSession> sessions = new HashSet<>();
    // WebSocket connection이 맺어진 세션을 가리킨다.
    // 해당 세션을 통해서 메시지를 보낼 수 있다. (sendMessage())

    // 채팅방 생성
    public static ChatRoom create(@NonNull String name) {
        ChatRoom created = new ChatRoom();
        created.roomId = UUID.randomUUID().toString();
        created.name = name;
        return created;
    }

    public void handleActions(WebSocketSession session, ChatMessage chatMessage, ChatService chatService) {
        if (chatMessage.getType().equals(MessageType.ENTER)) {
            addSession(session);
            chatMessage.setMessage(chatMessage.getWriter() + "님이 입장했습니다.");
        }
        sendMessage(chatMessage, chatService);
    }

    public <T> void sendMessage(T message, ChatService chatService) {
        sessions.parallelStream().forEach(session -> chatService.sendMessage(session, message));
    }

    private void addSession(WebSocketSession session) {
        sessions.add(session);
    }

}

