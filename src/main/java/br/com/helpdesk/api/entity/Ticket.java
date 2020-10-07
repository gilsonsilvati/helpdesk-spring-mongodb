package br.com.helpdesk.api.entity;

import br.com.helpdesk.api.entity.enums.Priority;
import br.com.helpdesk.api.entity.enums.Status;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "ticket")
@Data
public class Ticket {

    @MongoId
    private String id;

    @DBRef(lazy = true)
    private User user;

    @DBRef(lazy = true)
    private User assigned;

    private LocalDateTime date;
    private String title;
    private Integer number;
    private Status status;
    private Priority priority;
    private String description;
    private String image;

    @Transient
    private List<Change> changes;

}
