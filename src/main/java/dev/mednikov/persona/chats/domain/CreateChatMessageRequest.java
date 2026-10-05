package dev.mednikov.persona.chats.domain;

import java.util.UUID;

public record CreateChatMessageRequest(
        UUID personaId, String content
) {
}
