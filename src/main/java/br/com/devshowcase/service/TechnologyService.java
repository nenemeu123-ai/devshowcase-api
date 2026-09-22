package br.com.devshowcase.service;

import br.com.devshowcase.dto.TechnologyRequest;
import br.com.devshowcase.dto.TechnologyResponse;
import br.com.devshowcase.entity.Technology;
import br.com.devshowcase.repository.TechnologyRepository;
import org.springframework.stereotype.Service;

import br.com.devshowcase.exception.ResourceNotFoundException;
import java.util.List;

@Service
public class TechnologyService {
    private final TechnologyRepository repository;

    public TechnologyService(TechnologyRepository repository) {
        this.repository = repository;
    }

    public TechnologyResponse create(TechnologyRequest request) {
        String name = request.name().trim();
        if (repository.existsByNameIgnoreCase(name)) {
            throw new IllegalArgumentException("Tecnologia já cadastrada");
        }
        Technology t = new Technology();
        t.setName(name);
        return TechnologyResponse.fromEntity(repository.save(t));
    }


    public List<TechnologyResponse> findAll() {
        return repository.findAll().stream()
                .map(TechnologyResponse::fromEntity)
                .toList();
    }

    public TechnologyResponse findById(Long id) {
        Technology technology = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Tecnologia não encontrada: " + id
                ));

        return TechnologyResponse.fromEntity(technology);
    }
    public TechnologyResponse update(Long id, TechnologyRequest request) {
        Technology technology = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Tecnologia não encontrada: " + id
                ));

        technology.setName(request.name().trim());

        return TechnologyResponse.fromEntity(repository.save(technology));
    }
}
