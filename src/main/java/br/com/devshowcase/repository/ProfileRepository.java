package br.com.devshowcase.repository;

import br.com.devshowcase.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    boolean existsByEmail(String email);
}
