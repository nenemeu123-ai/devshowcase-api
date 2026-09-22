package br.com.devshowcase.controller;

import br.com.devshowcase.dto.TechnologyRequest;
import br.com.devshowcase.dto.TechnologyResponse;
import br.com.devshowcase.service.TechnologyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {
    private final TechnologyService service;

    public TechnologyController(TechnologyService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TechnologyResponse create(@Valid @RequestBody TechnologyRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<TechnologyResponse> findAll() {
        return service.findAll();
    }
    @GetMapping("/{id}")
    public TechnologyResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }
    @PutMapping("/{id}")
    public TechnologyResponse update(
            @PathVariable Long id,
            @Valid @RequestBody TechnologyRequest request) {
        return service.update(id, request);
    }
}
