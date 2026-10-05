package dev.mednikov.persona.chats.repositories;

import dev.mednikov.persona.chats.models.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, UUID> {

    @Query("SELECT m FROM ChatMessage m WHERE m.personaId = :personaId ORDER BY m.createdAt ASC")
    List<ChatMessage> findAllByPersonaId (UUID personaId);

}
