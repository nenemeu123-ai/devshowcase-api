package br.com.devshowcase.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;
import java.util.List;

public record ProjectRequest(
    @NotBlank(message = "Título é obrigatório")
    String title,

    @NotBlank(message = "Descrição é obrigatória")
    String description,

    @NotBlank(message = "URL do repositório é obrigatória")
    @URL(message = "URL do repositório inválida")
    String repositoryUrl,

    @URL(message = "URL de deploy inválida")
    String deployUrl,

    @NotNull(message = "profileId é obrigatório")
    Long profileId,

    @Size(min = 1, message = "Informe pelo menos uma tecnologia")
    List<Long> technologyIds
) {}
