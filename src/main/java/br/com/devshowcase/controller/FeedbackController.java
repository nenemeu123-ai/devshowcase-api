package br.com.devshowcase.controller;

import br.com.devshowcase.dto.FeedbackRequest;
import br.com.devshowcase.dto.FeedbackResponse;
import br.com.devshowcase.service.FeedbackService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    private final FeedbackService service;

    public FeedbackController(FeedbackService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FeedbackResponse create(
            @Valid @RequestBody FeedbackRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<FeedbackResponse> findAll() {
        return service.findAll();
    }
}