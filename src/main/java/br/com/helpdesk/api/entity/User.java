package br.com.helpdesk.api.entity;

import br.com.helpdesk.api.entity.enums.Profile;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document(collection = "user")
@Data
public class User {

    @Id
    private String id;

    @Indexed(unique = true)
    @NotBlank(message = "E-mail is required")
    @Email(message = "E-mail invalid")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6)
    private String password;

    private Profile profile;

}
