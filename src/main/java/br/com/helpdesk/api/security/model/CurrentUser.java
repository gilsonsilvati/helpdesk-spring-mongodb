package br.com.helpdesk.api.security.model;

import br.com.helpdesk.api.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class CurrentUser {

    private String token;
    private User user;

}
