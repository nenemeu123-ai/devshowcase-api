package br.com.devshowcase.repository;

import br.com.devshowcase.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {}
