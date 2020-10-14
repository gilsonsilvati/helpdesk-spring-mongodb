package br.com.helpdesk.api.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class JwtAuthenticationRequest implements Serializable {

    private static final long serialVersionUID = 5436718394968609337L;

    private String email;
    private String password;

}
