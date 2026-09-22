package br.com.devshowcase.service;

import br.com.devshowcase.dto.ProjectRequest;
import br.com.devshowcase.dto.ProjectResponse;
import br.com.devshowcase.entity.Profile;
import br.com.devshowcase.entity.Project;
import br.com.devshowcase.entity.Technology;
import br.com.devshowcase.exception.ResourceNotFoundException;
import br.com.devshowcase.repository.ProfileRepository;
import br.com.devshowcase.repository.ProjectRepository;
import br.com.devshowcase.repository.TechnologyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProfileRepository profileRepository;
    private final TechnologyRepository technologyRepository;

    public ProjectService(ProjectRepository projectRepository,
                          ProfileRepository profileRepository,
                          TechnologyRepository technologyRepository) {
        this.projectRepository = projectRepository;
        this.profileRepository = profileRepository;
        this.technologyRepository = technologyRepository;
    }

    public ProjectResponse create(ProjectRequest request) {
        Profile profile = profileRepository.findById(request.profileId())
            .orElseThrow(() -> new ResourceNotFoundException(
                "Perfil não encontrado: " + request.profileId()));

        List<Long> ids = request.technologyIds() == null ? List.of() : request.technologyIds();
        List<Technology> technologies = technologyRepository.findAllById(ids);

        if (technologies.size() != ids.stream().distinct().count()) {
            throw new ResourceNotFoundException("Uma ou mais tecnologias não foram encontradas");
        }

        Project project = new Project();
        project.setTitle(request.title().trim());
        project.setDescription(request.description().trim());
        project.setRepositoryUrl(request.repositoryUrl().trim());
        project.setDeployUrl(request.deployUrl() == null ? null : request.deployUrl().trim());
        project.setProfile(profile);
        project.setTechnologies(technologies);

        return ProjectResponse.fromEntity(projectRepository.save(project));
    }

    public List<ProjectResponse> findAll() {
        return projectRepository.findAll().stream()
            .map(ProjectResponse::fromEntity)
            .toList();
    }
    public ProjectResponse findById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Projeto não encontrado: " + id
                        )
                );

        return ProjectResponse.fromEntity(project);
    }
}
