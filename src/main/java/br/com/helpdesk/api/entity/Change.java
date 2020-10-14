package br.com.helpdesk.api.entity;

import br.com.helpdesk.api.entity.enums.Status;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "change")
@Data
public class Change {

    @Id
    private String id;

    @DBRef
    private Ticket ticket;

    @DBRef
    private User user;

    private LocalDateTime date;
    private Status status;

}
