package br.com.helpdesk.api.entity.enums;

import lombok.Getter;

@Getter
public enum Status {

    NEW("New"),
    ASSIGNED("Assigned"),
    RESOLVED("Resolved"),
    APPROVED("Approved"),
    DISAPPOVED("Disapproved"),
    CLOSED("Closed");

    private final String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

}
