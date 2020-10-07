package br.com.helpdesk.api.entity;

import br.com.helpdesk.api.entity.enums.Status;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Document(collection = "change")
@Data
public class Change {

    @MongoId
    private String id;

    @DBRef
    private Ticket ticket;

    @DBRef
    private User user;

    private LocalDateTime date;
    private Status status;

}
