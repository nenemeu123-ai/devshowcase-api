package br.com.devshowcase.repository;

import br.com.devshowcase.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
    boolean existsByNameIgnoreCase(String name);
}
