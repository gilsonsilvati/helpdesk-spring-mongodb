package br.com.helpdesk.api.entity.enums;

import lombok.Getter;

@Getter
public enum Priority {

    HIGH("High"),
    NORMAL("Normal"),
    LOW("Low");

    private final String descricao;

    Priority(String descricao) {
        this.descricao = descricao;
    }

}
