package com.example.springbootchat.chat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    private String roomId;
    private String writer;
    private String message;
    private String writeDate;
    private MessageType type;
}
