package br.com.devshowcase.dto;

import br.com.devshowcase.entity.Project;
import java.util.List;

public record ProjectResponse(
    Long id,
    String title,
    String description,
    String repositoryUrl,
    String deployUrl,
    Long profileId,
    List<TechnologyResponse> technologies
) {
    public static ProjectResponse fromEntity(Project p) {
        return new ProjectResponse(
            p.getId(),
            p.getTitle(),
            p.getDescription(),
            p.getRepositoryUrl(),
            p.getDeployUrl(),
            p.getProfile().getId(),
            p.getTechnologies().stream().map(TechnologyResponse::fromEntity).toList()
        );
    }
}
