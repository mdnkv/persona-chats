package dev.mednikov.persona.chats.mappers;

import dev.mednikov.persona.chats.domain.ChatMessageResponse;
import dev.mednikov.persona.chats.models.ChatMessage;
import org.mapstruct.Mapper;

@Mapper
public interface ChatMessageResponseMapper {

    ChatMessageResponse map (ChatMessage chatMessage);

}
