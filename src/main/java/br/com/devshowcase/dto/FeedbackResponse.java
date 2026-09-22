package br.com.devshowcase.dto;

public record FeedbackResponse(
        Long id,
        String comment,
        Integer rating,
        Long projectId
) {}