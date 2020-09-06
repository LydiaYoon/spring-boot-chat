package com.example.springbootchat.chat.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    private String roomId;
    private String writer;
    private String message;
    private String writeDate;
    private MessageType type;
}
