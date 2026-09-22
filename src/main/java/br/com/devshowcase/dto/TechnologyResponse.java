package br.com.devshowcase.dto;

import br.com.devshowcase.entity.Technology;

public record TechnologyResponse(Long id, String name) {
    public static TechnologyResponse fromEntity(Technology t) {
        return new TechnologyResponse(t.getId(), t.getName());
    }
}
