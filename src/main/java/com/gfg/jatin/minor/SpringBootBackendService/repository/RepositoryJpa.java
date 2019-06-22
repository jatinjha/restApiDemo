package com.gfg.jatin.minor.SpringBootBackendService.repository;

import com.gfg.jatin.minor.SpringBootBackendService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryJpa extends JpaRepository<User, Long> {


}
