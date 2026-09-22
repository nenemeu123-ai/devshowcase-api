package br.com.devshowcase.controller;

import br.com.devshowcase.dto.FeedbackRequest;
import br.com.devshowcase.dto.FeedbackResponse;
import br.com.devshowcase.service.FeedbackService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class FeedbackController {

    private final FeedbackService service;

    public FeedbackController(FeedbackService service) {
        this.service = service;
    }

    @PostMapping("/{id}/feedbacks")
    @ResponseStatus(HttpStatus.CREATED)
    public FeedbackResponse create(
            @PathVariable Long id,
            @Valid @RequestBody FeedbackRequest request) {

        return service.create(id, request);
    }

    @GetMapping("/{id}/feedbacks")
    public List<FeedbackResponse> findAll(@PathVariable Long id) {
        return service.findAll(id);
    }
}