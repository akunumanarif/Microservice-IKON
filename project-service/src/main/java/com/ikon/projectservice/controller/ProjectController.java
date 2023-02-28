package com.ikon.projectservice.controller;

import com.ikon.projectservice.dto.ProjectDTO;
import com.ikon.projectservice.dto.ResponseDTO;
import com.ikon.projectservice.model.Project;
import com.ikon.projectservice.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public Iterable<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<ProjectDTO>> createProject(@RequestBody ProjectDTO project, Errors errors) {
        ResponseDTO<ProjectDTO> response = new ResponseDTO<>();
        if(errors.hasErrors()) {
            response.setMessage("Gagal menambahkan Project");
            response.setHttpStatus(HttpStatus.BAD_REQUEST);
            response.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        response.setHttpStatus(HttpStatus.OK);
        response.setMessage("Product berhasil ditambahkan");
        log.info("Masuk sini");
        response.setData(projectService.createProject(project));
        log.info("Sampe sini kah?");

        return ResponseEntity.ok().body(response);


    }

}