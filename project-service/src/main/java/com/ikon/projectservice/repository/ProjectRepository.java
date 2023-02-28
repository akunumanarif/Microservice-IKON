package com.ikon.projectservice.repository;


import com.ikon.projectservice.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface ProjectRepository extends JpaRepository<Project, Long> {
//    List<Project> findByTeamId(Long teamId);
}