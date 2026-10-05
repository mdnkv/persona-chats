package dev.mednikov.persona.chats.controllers;

import dev.mednikov.persona.chats.domain.ChatMessageResponse;
import dev.mednikov.persona.chats.domain.CreateChatMessageRequest;
import dev.mednikov.persona.chats.services.ChatMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/chats")
@CrossOrigin("*")
public class ChatMessageRestController {

    private final ChatMessageService service;

    public ChatMessageRestController(ChatMessageService service) {
        this.service = service;
    }

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody List<ChatMessageResponse> sendMessage (@RequestBody CreateChatMessageRequest body){
        return this.service.sendChatMessage(body);
    }

    @GetMapping("/persona/{personaId}")
    public @ResponseBody List<ChatMessageResponse> getChatMessagesForPersona(@PathVariable UUID personaId){
        return this.service.getChatMessagesForPersona(personaId);
    }

}
