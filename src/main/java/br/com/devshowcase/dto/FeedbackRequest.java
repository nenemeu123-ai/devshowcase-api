package br.com.devshowcase.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FeedbackRequest(

        @NotBlank(message = "Comentário é obrigatório")
        String comment,

        @NotNull(message = "Avaliação é obrigatória")
        @Min(value = 1, message = "Avaliação mínima é 1")
        @Max(value = 5, message = "Avaliação máxima é 5")
        Integer rating,

        @NotNull(message = "projectId é obrigatório")
        Long projectId

) {}