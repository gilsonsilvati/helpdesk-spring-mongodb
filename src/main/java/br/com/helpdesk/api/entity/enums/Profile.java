package br.com.helpdesk.api.entity.enums;

import lombok.Getter;

@Getter
public enum Profile {

    ROLE_ADMIN("ADMIN"),
    ROLE_CUSTOMER("CUSTOMER"),
    ROLE_TECHNICIAN("TECHNICIAN");

    private final String descricao;

    Profile(String descricao) {
        this.descricao = descricao;
    }

}
