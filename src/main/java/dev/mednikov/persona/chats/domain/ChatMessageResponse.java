package dev.mednikov.persona.chats.domain;

import dev.mednikov.persona.chats.models.MessageRole;

import java.util.UUID;

public record ChatMessageResponse(
        UUID id,
        UUID personaId,
        String content,
        MessageRole messageRole
) {
}
