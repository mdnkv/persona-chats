package dev.mednikov.persona.chats.services;

import dev.mednikov.persona.chats.domain.ChatMessageResponse;
import dev.mednikov.persona.chats.domain.CreateChatMessageRequest;
import dev.mednikov.persona.chats.mappers.ChatMessageResponseDtoMapper;
import dev.mednikov.persona.chats.models.ChatMessage;
import dev.mednikov.persona.chats.models.MessageRole;
import dev.mednikov.persona.chats.repositories.ChatMessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ChatMessageServiceImpl implements ChatMessageService{

    private final AIService aiService;
    private final ChatMessageRepository chatMessageRepository;
    private final ChatMessageResponseDtoMapper mapper;

    public ChatMessageServiceImpl(AIService aiService, ChatMessageRepository chatMessageRepository, ChatMessageResponseDtoMapper mapper) {
        this.aiService = aiService;
        this.chatMessageRepository = chatMessageRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ChatMessageResponse> sendChatMessage(CreateChatMessageRequest request) {
        // Create user message
        ChatMessage userMessage = new ChatMessage();
        userMessage.setContent(request.content());
        userMessage.setMessageRole(MessageRole.USER);
        userMessage.setPersonaId(request.personaId());
        userMessage.setCreatedAt(LocalDateTime.now());

        // Get previous messages
        // TODO

        // Get AI answer
        String answer = this.aiService.getPersonaAnswer(request.content());

        // Create persona message
        ChatMessage personaMessage = new ChatMessage();
        personaMessage.setContent(answer);
        personaMessage.setPersonaId(request.personaId());
        personaMessage.setMessageRole(MessageRole.PERSONA);
        personaMessage.setCreatedAt(LocalDateTime.now());

        // Return result
        return this.chatMessageRepository.saveAll(List.of(userMessage, personaMessage))
                .stream().map(this.mapper::map).toList();
    }

    @Override
    public List<ChatMessageResponse> getChatMessagesForPersona(UUID personaId) {
        return this.chatMessageRepository.findAllByPersonaId(personaId)
                .stream().map(this.mapper::map).toList();
    }

}
