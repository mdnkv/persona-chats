package dev.mednikov.persona.chats.models;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "chats_messages")
public class ChatMessage {

    @Id @GeneratedValue @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    private UUID id;

    @Column(name = "persona_id", nullable = false)
    private UUID personaId;

    @Column(name = "message_content", nullable = false)
    private String content;

    @Column(name = "message_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private MessageRole messageRole;

    @Column(name = "created_at")
//    @CreationTimestamp
    private LocalDateTime createdAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPersonaId() {
        return personaId;
    }

    public void setPersonaId(UUID personaId) {
        this.personaId = personaId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageRole getMessageRole() {
        return messageRole;
    }

    public void setMessageRole(MessageRole messageRole) {
        this.messageRole = messageRole;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
