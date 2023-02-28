package com.ikon.projectservice.service;

import com.ikon.projectservice.dto.ProjectDTO;
import com.ikon.projectservice.exceptions.ResourceNotFoundException;
import com.ikon.projectservice.model.Project;
import com.ikon.projectservice.repository.ProjectRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;


    // ? CREATE PROJECT
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
//        project.setTeam(new Team(projectDTO.getTeamId()));
//        project.setTasks(new ArrayList<>());

        project = projectRepository.save(project);

        projectDTO.setId(project.getId());
//        projectDTO.setTasks(new ArrayList<>());

        return projectDTO;
    }

    // ? GET ONE PROJECT
    public ProjectDTO getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", id));

        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(project.getId());
        projectDTO.setName(project.getName());
        projectDTO.setDescription(project.getDescription());
//        projectDTO.setTeamId(project.getTeam().getId());
//        projectDTO.setTasks(TaskMapper.mapToTaskDTOs(project.getTasks()));

        return projectDTO;
    }

    // ? GET ALL PROJECT
    public Iterable<Project> getAllProjects() {
        return projectRepository.findAll();

    }

    // other CRUD operations
}
