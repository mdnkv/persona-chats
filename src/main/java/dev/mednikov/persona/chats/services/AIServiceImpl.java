package dev.mednikov.persona.chats.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AIServiceImpl implements AIService{

    private final ChatClient chatClient;

    public AIServiceImpl(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @Override
    public String getPersonaAnswer(String message) {
        return this.chatClient.prompt()
                .user(message)
                .call()
                .content();
    }

}
