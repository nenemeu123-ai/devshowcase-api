package br.com.devshowcase.controller;

import br.com.devshowcase.dto.ProjectRequest;
import br.com.devshowcase.dto.ProjectResponse;
import br.com.devshowcase.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponse create(@Valid @RequestBody ProjectRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<ProjectResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProjectResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
