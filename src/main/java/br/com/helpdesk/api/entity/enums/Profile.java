package br.com.helpdesk.api.entity.enums;

import lombok.Getter;

@Getter
public enum Profile {

    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_CUSTOMER("ROLE_CUSTOMER"),
    ROLE_TECHNICIAN("ROLE_TECHNICIAN");

    private final String descricao;

    Profile(String descricao) {
        this.descricao = descricao;
    }

}
