package com.ikon.projectservice.repository;


import com.ikon.projectservice.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
        Project findByProjectId(Long projectId);
}