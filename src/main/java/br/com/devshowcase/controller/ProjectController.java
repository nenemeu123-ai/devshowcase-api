package br.com.devshowcase.controller;

import br.com.devshowcase.dto.ProjectRequest;
import br.com.devshowcase.dto.ProjectResponse;
import br.com.devshowcase.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    public Page<ProjectResponse> findAll(
            @RequestParam(required = false) String technology,
            Pageable pageable) {

        return service.findAll(technology, pageable);
    }

    @GetMapping("/{id}")
    public ProjectResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }
    @PutMapping("/{id}/upvote")
    public ProjectResponse upvote(@PathVariable Long id) {
        return service.upvote(id);
    }
}
