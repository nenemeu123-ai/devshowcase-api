package br.com.devshowcase.controller;

import br.com.devshowcase.dto.ProfileRequest;
import br.com.devshowcase.dto.ProfileResponse;
import br.com.devshowcase.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
    private final ProfileService service;

    public ProfileController(ProfileService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileResponse create(@Valid @RequestBody ProfileRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public ProfileResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }
    @GetMapping
    public List<ProfileResponse> findAll() {
        return service.findAll();
    }
}
