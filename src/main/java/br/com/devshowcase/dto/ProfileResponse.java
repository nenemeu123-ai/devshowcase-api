package br.com.devshowcase.dto;

import br.com.devshowcase.entity.Profile;

public record ProfileResponse(Long id, String name, String email, String bio) {
    public static ProfileResponse fromEntity(Profile p) {
        return new ProfileResponse(p.getId(), p.getName(), p.getEmail(), p.getBio());
    }
}
