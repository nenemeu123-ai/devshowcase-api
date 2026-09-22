package br.com.devshowcase.service;

import br.com.devshowcase.dto.FeedbackRequest;
import br.com.devshowcase.dto.FeedbackResponse;
import br.com.devshowcase.entity.Feedback;
import br.com.devshowcase.entity.Project;
import br.com.devshowcase.repository.FeedbackRepository;
import br.com.devshowcase.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import br.com.devshowcase.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final ProjectRepository projectRepository;

    public FeedbackService(FeedbackRepository feedbackRepository,
                           ProjectRepository projectRepository) {
        this.feedbackRepository = feedbackRepository;
        this.projectRepository = projectRepository;
    }

    public FeedbackResponse create(FeedbackRequest request) {

        Project project = projectRepository.findById(request.projectId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Projeto não encontrado: " + request.projectId()
                        )
                );

        Feedback feedback = new Feedback();
        feedback.setComment(request.comment());
        feedback.setRating(request.rating());
        feedback.setProject(project);

        Feedback saved = feedbackRepository.save(feedback);

        return toResponse(saved);
    }

    public List<FeedbackResponse> findAll() {
        return feedbackRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private FeedbackResponse toResponse(Feedback feedback) {
        return new FeedbackResponse(
                feedback.getId(),
                feedback.getComment(),
                feedback.getRating(),
                feedback.getProject().getId()
        );
    }
}