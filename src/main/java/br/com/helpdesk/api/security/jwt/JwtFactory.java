package br.com.helpdesk.api.security.jwt;

import br.com.helpdesk.api.entity.User;
import br.com.helpdesk.api.entity.enums.Profile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JwtFactory {

    private JwtFactory() { }

    public static JwtUser create(User user) {
        return new JwtUser(user.getId(), user.getEmail(), user.getPassword(), mapToGrantedAuthorities(user.getProfile()));
    }

    private static Collection<? extends GrantedAuthority> mapToGrantedAuthorities(Profile profile) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(profile.getDescricao()));

        return authorities;
    }

}
