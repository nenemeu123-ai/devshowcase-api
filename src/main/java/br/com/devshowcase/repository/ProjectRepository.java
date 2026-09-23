package br.com.devshowcase.repository;

import br.com.devshowcase.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Page<Project> findDistinctByTechnologies_NameContainingIgnoreCase(
            String technology,
            Pageable pageable
    );
}
