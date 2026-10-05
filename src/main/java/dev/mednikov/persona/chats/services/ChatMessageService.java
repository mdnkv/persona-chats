package dev.mednikov.persona.chats.services;

import dev.mednikov.persona.chats.domain.ChatMessageResponse;
import dev.mednikov.persona.chats.domain.CreateChatMessageRequest;

import java.util.List;
import java.util.UUID;

public interface ChatMessageService {

    List<ChatMessageResponse> sendChatMessage (CreateChatMessageRequest request);

    List<ChatMessageResponse> getChatMessagesForPersona (UUID personaId);

}
