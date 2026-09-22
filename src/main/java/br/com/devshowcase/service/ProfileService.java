package br.com.devshowcase.service;

import br.com.devshowcase.dto.ProfileRequest;
import br.com.devshowcase.dto.ProfileResponse;
import br.com.devshowcase.entity.Profile;
import br.com.devshowcase.exception.ResourceNotFoundException;
import br.com.devshowcase.repository.ProfileRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfileService {
    private final ProfileRepository repository;

    public ProfileService(ProfileRepository repository) {
        this.repository = repository;
    }

    public ProfileResponse create(ProfileRequest request) {
        if (repository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("E-mail já cadastrado");
        }
        Profile p = new Profile();
        p.setName(request.name().trim());
        p.setEmail(request.email().trim().toLowerCase());
        p.setBio(request.bio());
        return ProfileResponse.fromEntity(repository.save(p));
    }

    public ProfileResponse findById(Long id) {
        return ProfileResponse.fromEntity(repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Perfil não encontrado: " + id)));
    }
    public List<ProfileResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(ProfileResponse::fromEntity)
                .toList();
    }
}
